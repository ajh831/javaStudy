
public class ThreadEx15_2 {
	public static void main(String[] args) {
		MyThread th1 = new MyThread("*");
		MyThread th2 = new MyThread("**");
		MyThread th3 = new MyThread("***");

		th1.start();
		th2.start();
		th3.start();

		try {
			Thread.sleep(2000);
			th1.suspend(); // 쓰레드 th1 일시정지
			Thread.sleep(2000);
			th2.suspend(); // 쓰레드 th2 일시정지
			Thread.sleep(3000);
			th1.resume(); // 쓰레드 th1 재개(다시 동작)
			Thread.sleep(3000);
			th1.stop(); // 쓰레드 th1 정지
			th2.stop(); // 쓰레드 th2 정지
			Thread.sleep(2000);
			th3.stop(); // 쓰레드 th3 정지
		} catch (InterruptedException e) {
		}
	}
}

class MyThread implements Runnable {
	boolean suspended = false;
	boolean stopped = false;
	
	Thread th;
	
	MyThread(String name) {
		th = new Thread(this, name);	// Thread(Runnable r, String name)
	}
	
	void start() {
		th.start();
	}

	void stop() {
		this.stopped = true;
	}
	
	void suspend() {
		this.suspended = true;
	}
	
	void resume() {
		this.stopped = false;
	}
	
	public void run() {
		while (!stopped) {
			if (!suspended) {
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch(InterruptedException e) {}
			}
		}
	}
}
