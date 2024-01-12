import javax.management.RuntimeErrorException;

public class ExceptionEx11 {
	public static void main(String[] args) {
//		throw new RuntimeErrorException(); // RuntimeException을 고의로 발생시킴
		
//		처리 결과
//		Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
//			The constructor RuntimeErrorException() is undefined
//
//			at ExceptionEx11.main(ExceptionEx11.java:5)

//		성공적으로 컴파일되지만 RuntimeException 발생으로 비정상적 종료됨
//		RuntimeException클래스와 그 자손들은 예외처리를 강요하지 않음(선택)
	}
}
