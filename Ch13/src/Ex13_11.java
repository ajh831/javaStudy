class Ex13_11 {
	static long startTime = 0;

	public static void main(String args[]) {
		ThreadEx11_1 th1 = new ThreadEx11_1();
		ThreadEx11_2 th2 = new ThreadEx11_2();
		th1.start();
		th2.start();
		startTime = System.currentTimeMillis();
		
		// join() : main쓰레드가 명시한 쓰레드의 작업이 끝날 때까지 기다리도록 함
		// join()을 사용하지 않는 경우 main쓰레드가 먼저 종료되고 start()한 쓰래드가 수행됨
			// ex)
			// 소요시간:0||--||||||||-------||------||||
		// join()을 사용하는 경우 start()한 쓰레드가 수행 및 종료된 이후에 main쓰레드가 종료됨
			// ex)
			// ||--||||||||-------||------||||소요시간:3
		try {
			th1.join(); // main쓰레드가 th1의 작업이 끝날 때까지 기다린다.
			th2.join(); // main쓰레드가 th2의 작업이 끝날 때까지 기다린다.
		} catch (InterruptedException e) {
		}

		System.out.print("소요시간:" + (System.currentTimeMillis() - Ex13_11.startTime));
	} // main
}

class ThreadEx11_1 extends Thread {
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print(new String("-"));
		}
	} // run()
}

class ThreadEx11_2 extends Thread {
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print(new String("|"));
		}
	} // run()
}