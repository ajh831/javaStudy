
public class ThreadEx8 {
	public static void main(String[] args) {
		ThreadEx8_1 th1 = new ThreadEx8_1();
		ThreadEx8_2 th2 = new ThreadEx8_2();
		
		// th1.setPriority(5); // setPriority 기본값 : 5
		th2.setPriority(7);	// setPriority(int newPriority) : 쓰레드의 우선순위 지정값으로 변경
		
		System.out.println("Priority of th1(-) : "  + th1.getPriority());	// getPriority() : 쓰레드의 우선순위 반환
		System.out.println("Priority of th2(|) : "  + th2.getPriority());
		th1.start();
		th2.start();
	}
}

class ThreadEx8_1 extends Thread {
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print('-');
			for (int x = 0; x < 10000000; x++) {	// 시간 지연용 for문
				
			}
		}
	}
}

class ThreadEx8_2 extends Thread {
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print('|');
			for (int x = 0; x < 10000000; x++) {	// 시간 지연용 for문
				
			}
		}
	}
}
