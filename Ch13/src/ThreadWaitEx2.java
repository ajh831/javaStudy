import java.util.*;

public class ThreadWaitEx2 {
	public static void main(String[] args) throws Exception {
		Table2 Table2 = new Table2(); // 여러 쓰레드가 공유하는 객체

		new Thread(new Cook2(Table2), "Cook").start();
		new Thread(new Customer2(Table2, "donut"), "CUST1").start();
		new Thread(new Customer2(Table2, "burger"), "CUST2").start();

		Thread.sleep(5000); // 5초 후에 강제 종료
		System.exit(0); // 프로그램 전체 종료.(모든 쓰레드 종료)
	}
}

// 손님
class Customer2 implements Runnable {
	private Table2 table;
	private String food;

	Customer2(Table2 table, String food) {
		this.table = table;
		this.food = food;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
			String name = Thread.currentThread().getName();

			if (eatFood()) {
				System.out.println(name + " ate a " + food);
			} else {
				System.out.println(name + " failed to eat. :(");
			}
		}
	}

	boolean eatFood() {
		return table.remove(food);
	}
}

// 요리사
class Cook2 implements Runnable {
	private Table2 table;

	Cook2(Table2 table) {
		this.table = table;
	}

	public void run() {
		while (true) {
			// 임의의 요리를 하나 선택해서 Table2에 추가
			int idx = (int) (Math.random() * table.dishNum());
			table.add(table.dishNames[idx]);

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}

// 테이블
class Table2 {
	String[] dishNames = { "donut", "donut", "burger" }; // donut이 더 자주 나온다
	final int MAX_FOOD = 6; // 테이블에 놓을 수 있는 최대 음식의 개수

	private ArrayList<String> dishes = new ArrayList<>();

	public synchronized void add(String dish) { // synchronized를 추가
		// 테이블에 음식이 가득차면, 읍식 추가 X
		if (dishes.size() >= MAX_FOOD) {
			return;
		}
		dishes.add(dish);
		System.out.println("Dishes : " + dishes.toString());
	}

	public boolean remove(String dishName) {
		synchronized (this) {
			while (dishes.size() == 0) {
				String name = Thread.currentThread().getName();
				System.out.println(name + " is waiting.");	// 음식이 없어서 테이블에 lock을 건채로 기다림
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
			}
			// 지정된 요리와 일치하는 요리를 테이블에서 제거
			for (int i = 0; i < dishes.size(); i++) {
				if (dishName.equals(dishes.get(i))) {
					dishes.remove(i);
					return true;
				}
			}
		}
		return false;
	}

	public int dishNum() {
		return dishNames.length;
	}
}