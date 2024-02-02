import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadWaitEx4 {
	public static void main(String[] args) throws Exception {
		Table4 Table4 = new Table4(); // 여러 쓰레드가 공유하는 객체

		new Thread(new Cook4(Table4), "Cook").start();
		new Thread(new Customer4(Table4, "donut"), "CUST1").start();
		new Thread(new Customer4(Table4, "burger"), "CUST2").start();

		Thread.sleep(2000);
		System.exit(0); // 프로그램 전체 종료.(모든 쓰레드 종료)
	}
}

// 손님
class Customer4 implements Runnable {
	private Table4 table;
	private String food;

	Customer4(Table4 table, String food) {
		this.table = table;
		this.food = food;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
			String name = Thread.currentThread().getName();

			table.remove(food);
			System.out.println(name + " ate a " + food);
		}
	}
}

// 요리사
class Cook4 implements Runnable {
	private Table4 table;

	Cook4(Table4 Table4) {
		this.table = Table4;
	}

	public void run() {
		while (true) {
			// 임의의 요리를 하나 선택해서 Table4에 추가
			int idx = (int) (Math.random() * table.dishNum());

			table.add(table.dishNames[idx]);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
		}
	}
}

// 테이블
class Table4 {
	String[] dishNames = { "donut", "donut", "burger" }; // donut이 더 자주 나온다
	final int MAX_FOOD = 6; // 테이블에 놓을 수 있는 최대 음식의 개수

	private ArrayList<String> dishes = new ArrayList<>();

	private ReentrantLock lock = new ReentrantLock();
	private Condition forCook = lock.newCondition();
	private Condition forCust = lock.newCondition();

	public void add(String dish) {
		lock.lock();

		try {
			while (dishes.size() >= MAX_FOOD) {
				String name = Thread.currentThread().getName();
				System.out.println(name + " is waiting.");
				try {
					forCook.await(); // wait() : COOK 쓰레드를 기다리게 함
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
			}
			// System.out.println("   Cook add a " + dish);
			dishes.add(dish);
			forCust.signal(); // notify() : 기다리고 있는 CUST를 깨우기 위함
			System.out.println("Dishes : " + dishes.toString());
		} finally {
			lock.unlock();
		}
	}

	public boolean remove(String dishName) {
		lock.lock();

//		synchronized (this) {
		String name = Thread.currentThread().getName();

		try {
			while (dishes.size() == 0) {
				System.out.println(name + " is waiting.");
				try {
					forCust.await(); // CUST쓰레드를 기다리게 함
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
			}
			while (true) {
				// 지정된 요리와 일치하는 요리를 테이블에서 제거
				for (int i = 0; i < dishes.size(); i++) {
					if (dishName.equals(dishes.get(i))) {
						dishes.remove(i);
						forCook.signal(); // 잠자고 있는 COOK을 깨움
						return true;
					}
				}

				try {
					System.out.println(name + " is waiting.");
					forCust.await(); // 원하는 음식이 없는 CUT쓰레드를 기다리게함
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
			}
//		}
		} finally {
			lock.unlock();
		}
	}

	public int dishNum() {
		return dishNames.length;
	}
}