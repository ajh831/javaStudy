
public class ThreadEx12 {
	public static void main(String[] args) {
		ThreadEx12_1 th1 = new ThreadEx12_1();
		ThreadEx12_2 th2 = new ThreadEx12_2();
		th1.start();
		th2.start();
		
//		// 기본 예외처리
//		try {
////			th1.sleep(2 * 1000);	// 자기자신을 멈추게 하는 것이므로 클래스 이름(Thread)을 사용해서 작성할 것
//			Thread.sleep(2 * 1000);
//		} catch(InterruptedException e) {}
			
		delay(2 * 1000);
		
		System.out.print("<<main 종료>>");
	}
	
	// 예외처리 메서드
	static void delay(long millis) {
		try {
			Thread.sleep(millis);
		} catch(InterruptedException e) {}
	}
}

class ThreadEx12_1 extends Thread {
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print("-");
		}
		System.out.print("<<th1 종료>>");
	}
}

class ThreadEx12_2 extends Thread {
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print("|");
		}
		System.out.print("<<th2 종료>>");
	}
}
