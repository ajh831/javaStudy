import java.util.*;

public class ThreadEx16 {
	public static void main(String[] args) {
		RunImplEx16 r1 = new RunImplEx16();
		RunImplEx16 r2 = new RunImplEx16();
		RunImplEx16 r3 = new RunImplEx16();
		Thread th1 = new Thread(r1, "*");
		Thread th2 = new Thread(r2, "**");
		Thread th3 = new Thread(r3, "***");
		th1.start();
		th2.start();
		th3.start();
		
		try {
			Thread.sleep(2000);
			r1.suspend(); // th1.suspend() 아님!
			Thread.sleep(2000);
			r2.suspend();
			Thread.sleep(3000);
			r1.resume();
			Thread.sleep(3000);
			r1.stop();
			r2.stop();
			Thread.sleep(2000);
			r3.stop();
		} catch (InterruptedException e) {
		}
	}

}

class RunImplEx16 implements Runnable {
	// volatile : 쉽게 바뀌는 변수이므로 복사본을 사용하지 않고 원본을 사용하겠다는 뜻
	volatile boolean suspended = false;
	volatile boolean stopped = false;
	
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
}