
public class ExceptionEx12 {
	public static void main(String[] args) throws Exception{
		method1();	// 같은 클래스내의 static멤버이므로 객체 생성 없이 직접 호출이 가능함.
	}
	
	static void method1() throws Exception {
		method2();
	}

	static void method2() throws Exception {
		throw new Exception();	// 예외를 강제적으로 발생시킴
	}
	
//	실행결과
//	Exception in thread "main" java.lang.Exception
//	at ExceptionEx12.method2(ExceptionEx12.java:12)
//	at ExceptionEx12.method1(ExceptionEx12.java:8)
//	at ExceptionEx12.main(ExceptionEx12.java:4)
	
//	순서 생각해보기
//	1. main메서드가 method1()을 호출
//	2. method1()이 method2()를 호출
//	3. method2()에서 강제적인 예외 발생
//	4. 예외처리문이 없으므로 method2()는 종료되면서 throws Exception으로 호출한 method1()에게 예외를 넘김
//	5. 예외처리문이 없으므로 method1()은 종료되면서 throws Exception으로 호출한 main메서드로 예외를 넘김
//	6. 예외처리문이 없으므로 main메서드 종료
	
}
