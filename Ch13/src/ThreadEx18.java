
public class ThreadEx18 {
	public static void main(String[] args) {
		ThreadEx18_1 th1 = new ThreadEx18_1("*");
		ThreadEx18_1 th2 = new ThreadEx18_1("**");
		ThreadEx18_1 th3 = new ThreadEx18_1("***");
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

class ThreadEx18_1 implements Runnable {
	boolean suspended = false;
	boolean stopped = false;
	
	Thread th;
	
	ThreadEx18_1(String name) {
		th = new Thread(this, name);	// Thread(Runnable r, String name)
	}
	
	public void run() {
		String name = th.getName();
		
		while(!stopped) {	// stop이 true, suspended가 false인 경우 쓰레드가 정지될때까지 시간지연이 발생할 것
			if(!suspended) {// 이 상황에 interrupt()를 호출하면 예외가 발생하여 즉시 일시정지 상태에서 벗어날 수 있음
				System.out.println(name);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println(name + " - interrupted");
				}
			} else {
				Thread.yield();	// 남은 실행시간을 while문에서 낭비하지않고 다른 쓰레드에게 양보
			}
		}
		System.out.println(name + " - stopped");
	}
	
	public void suspend() {
		suspended = true;	// 일시 정지
		th.interrupt();	// 쓰레드의 interrupted상태를 false에서 true로 변경
						// 자고 있을 수도 있어서 interrupt를 해줘야지 응답성이 좋아짐
		System.out.println(th.getName() + " - interrupt() by suspend()");
	}
	
	public void stop() {
		stopped = true;
		th.interrupt();
		System.out.println(th.getName() + " - interrupt()  by stop()");
	}
	
	public void resume() {
		suspended = false;
	}
	
	public void start() {
		th.start();
	}
}
