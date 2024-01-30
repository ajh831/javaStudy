
public class ThreadEx3 {
	public static void main(String[] args) {
		ThreadEx3_1 t1 = new ThreadEx3_1();
		t1.run();
	}
}

class ThreadEx3_1 extends Thread {
	public void run() {
		throwException();
	}

	public void throwException() {
		try {
			throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

// 실행 결과
//java.lang.Exception
//		at ThreadEx3_1.throwException(ThreadEx3.java:16)
//		at ThreadEx3_1.run(ThreadEx3.java:11)
//		at ThreadEx3.main(ThreadEx3.java:5)

// 이전 예제와 다르게 Thread가 생성되지 않아서 main메서드가 포함되어 있는 것을 확인할 수 있음
