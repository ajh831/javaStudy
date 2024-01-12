
public class ExceptionEx13 {
	public static void main(String[] args) {
		method1(); // 같은 클래스내의 static멤버이므로 객체 생성 없이 직접 호출이 가능함.
	}

	static void method1() {
		try {
			throw new Exception();	// 예외발생
		} catch (Exception e) {
			System.out.println("method1메서드에서 예외가 처리되었습니다.");
			e.printStackTrace();
		}
	}
}
