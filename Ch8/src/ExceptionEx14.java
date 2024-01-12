
public class ExceptionEx14 {
	public static void main(String[] args) {
		try {
			method1(); // 같은 클래스내의 static멤버이므로 객체 생성 없이 직접 호출이 가능함.
		} catch (Exception e) {
			System.out.println("main메서드에서 예외가 처리되었습니다.");
			e.printStackTrace();
		}
	}

	static void method1() throws Exception{
		throw new Exception();	// 예외발생
	}
}
