
public class TryWithResourceEx {
	public static void main(String[] args) {
		try (CloseableResource cr = new CloseableResource()) {
			cr.exceptionWork(false); // 예외발생 X
		} catch (WorkException e) {
			e.printStackTrace();
		} catch (CloseException e) {
			e.printStackTrace();
		}
		System.out.println();

		try (CloseableResource cr = new CloseableResource()) {
			cr.exceptionWork(true); // 예외발생 O
		} catch (WorkException e) {
			e.printStackTrace();	// 예외 또 발생
		} catch (CloseException e) {
			e.printStackTrace();
		}
	}

}

//try-with-resources문의 괄호()안에 객체 생성 문장을 넣으면, 따로 close()를 호출하지 않아도
//try블럭을 벗어나는 순간 자동으로 close() 호출됨
//그 다음에 catch블럭 or finally블럭이 수행됨
//자동으로 close()를 호출할 수 있으려면, 클래스가 AutoCloseable이라는 인터페이스를 구현한 것이여야지 가능함

class CloseableResource implements AutoCloseable {	// AutoCloseable 인터페이스 구현
	public void exceptionWork(boolean exception) throws WorkException {
		System.out.println("exceptionWork(" + exception + ") 가 호출됨");

		if (exception) {
			throw new WorkException("WorkException발생!!!");
		}

	}

	public void close() throws CloseException {
		System.out.println("close()가 호출됨");
		throw new CloseException("CloseException발생!!!");
	}
}

class WorkException extends Exception {	// WorkException은 Exception을 상속받고 있음
	WorkException(String msg) {	// 문자열을 매개변수로 받는 생성자
		super(msg);	// 조상인 Exception클래스의 생성자를 호출
	}
}

class CloseException extends Exception {
	CloseException(String msg) {
		super(msg);
	}
}
