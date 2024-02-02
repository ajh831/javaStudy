import java.util.*;

public class ThreadWaitEx3 {
	public static void main(String[] args) throws Exception {
		Table3 Table3 = new Table3(); // 여러 쓰레드가 공유하는 객체

		new Thread(new Cook3(Table3), "Cook").start();
		new Thread(new Customer3(Table3, "donut"), "CUST1").start();
		new Thread(new Customer3(Table3, "burger"), "CUST2").start();

		Thread.sleep(2000);
		System.exit(0); // 프로그램 전체 종료.(모든 쓰레드 종료)
	}
}

// 손님
class Customer3 implements Runnable {
	private Table3 table;
	private String food;

	Customer3(Table3 table, String food) {
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
class Cook3 implements Runnable {
	private Table3 table;

	Cook3(Table3 Table3) {
		this.table = Table3;
	}

	public void run() {
		while (true) {
			// 임의의 요리를 하나 선택해서 Table3에 추가
			int idx = (int) (Math.random() * table.dishNum());
			
			table.add(table.dishNames[idx]);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
		}
	}
}

// 테이블
class Table3 {
	String[] dishNames = { "donut", "donut", "burger" }; // donut이 더 자주 나온다
	final int MAX_FOOD = 6; // 테이블에 놓을 수 있는 최대 음식의 개수

	private ArrayList<String> dishes = new ArrayList<>();

	public synchronized void add(String dish) { // synchronized를 추가
		while (dishes.size() >= MAX_FOOD) {
			String name = Thread.currentThread().getName();
			System.out.println(name + " is waiting.");
			try {
				wait(); // COOK쓰레드를 기다리게 함
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
		System.out.println("   Cook add a " + dish);
		dishes.add(dish);
//		notify(); // 기다리고 있는 CUST를 깨우기 위함
		notifyAll(); // 기다리고 있는 CUST를 깨우기 위함
		System.out.println("Dishes : " + dishes.toString());
	}

	public boolean remove(String dishName) {
		synchronized (this) {
			String name = Thread.currentThread().getName();
			
			while (dishes.size() == 0) {
				System.out.println(name + " is waiting.");
				try {
					wait(); // CUST쓰레드를 기다리게 함
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
			}

			while (true) {
				// 지정된 요리와 일치하는 요리를 테이블에서 제거
				for (int i = 0; i < dishes.size(); i++) {
					if (dishName.equals(dishes.get(i))) {
						dishes.remove(i);
//						notify(); // 잠자고 있는 COOK을 깨우기 위함
						notifyAll(); // 잠자고 있는 COOK을 깨우기 위함
						return true;
					}
				}
				
				try {
					System.out.println(name + " is waiting.");
					wait(); // 원하는 음식이 없는 CUT쓰레드를 기다리게함
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
			}
		}
	}

	public int dishNum() {
		return dishNames.length;
	}
}