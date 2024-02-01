public class ThreadEx17 {
	public static void main(String[] args) {
		ThreadEx17_1 th1 = new ThreadEx17_1("*");
		ThreadEx17_1 th2 = new ThreadEx17_1("**");
		ThreadEx17_1 th3 = new ThreadEx17_1("***");
		th1.start();
		th2.start();
		th3.start();
		
		try {
			Thread.sleep(2000);
			th1.suspend();
			Thread.sleep(2000);
			th2.suspend();
			Thread.sleep(3000);
			th1.resume();
			Thread.sleep(3000);
			th1.stop();
			th2.stop();
			Thread.sleep(2000);
			th3.stop();
		} catch (InterruptedException e) {
		}
	}

}

class ThreadEx17_1 implements Runnable {
	// volatile : 쉽게 바뀌는 변수이므로 복사본을 사용하지 않고 원본을 사용하겠다는 뜻
	volatile boolean suspended = false;
	volatile boolean stopped = false;
	
	Thread th;
	
	ThreadEx17_1(String name) {
		th = new Thread(this, name);	// Thread(Runnable r, String name)
	}
	
	public void run() {
		while(!stopped) {	// stop의 값이 false인 동안 반복
			if(!suspended) {	// suspended의 값이 false일 때만 작업 수행
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch(InterruptedException e) {}
			}
		}
		System.out.println(Thread.currentThread().getName() + " - stopped");
	}
	
	public void suspend() {
		suspended = true;
	}
	
	public void resume() {
		suspended = false;
	}
	
	public void stop() {
		stopped = true;
	}
	
	public void start() {
		th.start();
	}
//	start() 메서드를 추가하여 쓰레드를 시작하는 로직을 캡슐화하였다. 이를 통해 쓰레드를 시작하는 방법이 일관되고 명확해졌다.
}

// ThreadEx16과 ThreadEx17의 차이점은 뭘까?
