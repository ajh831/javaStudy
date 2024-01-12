
public class ExceptionEx7 {
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(0/0);	// 0으로 나눠서 고의로 ArithmeticException을 발생시킴
			System.out.println(4);	// 실행되지 않음
		} catch (ArithmeticException ae) {
			if(ae instanceof ArithmeticException) {
				// ArithmeticException 타입의 참조변수 ae를 ArithmeticException로 형변환이 가능한지 확인
				System.out.println("true");
			}
			System.out.println("ArithmeticException");
		} catch (Exception e) {
			System.out.println("Exception");
		}
		System.out.println(6);
	}
}
