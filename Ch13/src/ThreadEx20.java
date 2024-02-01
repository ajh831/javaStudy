import javax.security.auth.Refreshable;

public class ThreadEx20 {
	public static void main(String[] args) {
		ThreadEx20_1 gc = new ThreadEx20_1();
		gc.setDaemon(true);
		gc.start();
		
		int requireMemory = 0;
		
		for (int i = 0; i < 20; i++) {
			requireMemory = (int) (Math.random() * 100)  * 20;	//  0부터 1980까지의 범위 정수
		
			// 필요한 메모리가 사용할 수 있는 양보다 크거나 전체 메모리의 60%이상을
			// 사용했을 경우 gc를 깨움
			if(gc.freeMemory() < requireMemory || gc.freeMemory() < gc.totalMemory() * 0.4) {	// 남은 메모리가 전체 40% 미만인 경우
				gc.interrupt();
				// try - catch 문이 없는 경우에 gc.interrupt()를 하여도 MAX 값이 1000인데 넘는 값들이 나오게 됨
				// gc가 interrupt에 의해 깨어났음에도 불구하고 gc() 수행되지 전에 main 쓰레드의 작업이 수행되어 메모리를 사용하기 때문
				try {
					gc.join(100);
				} catch (InterruptedException e) {
				}
			}
			
			gc.usedMemory =+ requireMemory;
			System.out.println("usedMemory : " + gc.usedMemory);
		}

	}
}

class ThreadEx20_1 extends Thread {
	final static int MAX_MEMORY = 1000;	// 최대 메모리 : 1000
	int usedMemory = 0;	// 사용 메모리
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(10 * 1000);	// 10초 기다림
			} catch(InterruptedException e) {
				System.out.println("Awaken by interrupt(). catch문");
			}
			
			gc();// garbage collection을 수행
			System.out.println("Garbage Collected. Free Memory : " + freeMemory());	// 남은 메모리
		}
	}
	
	public void gc() {
		usedMemory -= 300;	// 사용 메모리에서 300을 뺌
		if(usedMemory < 0) usedMemory = 0;	// 사용 메모리가 0보다 작은 경우 0으로 초기화
	}
	
	public int totalMemory() {	// 총 사용 메모리는 MAX 메모리 반환
		return MAX_MEMORY;
	}
	public int freeMemory() {	// 남은 메모리는 MAX 메모리 - 사용 메모리
		return MAX_MEMORY - usedMemory;
	}
}