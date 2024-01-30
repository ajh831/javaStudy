import java.util.*;

public class ThreadEx1 {
	public static void main(String[] args) {
		ThreadEx1_1 t1 = new ThreadEx1_1();
		
		Runnable r = new ThreadEx1_2();
		Thread t2 = new Thread(r); // Runnable 인터페이스를 구현한 것이므로 Thread를 상속받은게 아니니까 Thread로 객체 생성을 해줘야 됨
		
		t1.start();	// Thread t1 실행시킴
		t2.start();	// Thread t2 실행시킴
		// start()가 호출되어도 바로 실행되는 것이 아님
		// 먼저 start() 했더라도 먼저 실행되는 것이 아님
		// => OS 스케쥴러가 실행순서 결정
		
	}
}

// 쓰레드 1 : Thread클래스 상속
class ThreadEx1_1 extends Thread {
	
	public void run() {	// Thread가 수행할 작업
		for(int i=0; i< 5 ; i++) {
			setName("Thread-New 0"); // Thread 이름 변경
			
			// getName() : 쓰레드의 이름 반환
			System.out.println(getName());	// 조상 Thread의 getName() 호출
			// this.getName() -> this. 생략됨
		}
		
	}
}

// 쓰레드 2 : Runnable 인터페이스 구현
class ThreadEx1_2 implements Runnable {
	public void run() {	// Thread가 수행할 작업
		for(int i=0; i< 5 ; i++) {
			Thread.currentThread().setName("Thread-New 1");
			
			// Thread.currentThread() : 현재 실행중인 Thread를 반환
			System.out.println(Thread.currentThread().getName());	// 조상 Thread의 getName() 호출
		}
	}
}
// => 멀티 쓰레드