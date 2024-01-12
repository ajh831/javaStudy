
public class ExceptionEx8 {
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(0/0); // 예외발생
			System.out.println(4); // 실행 안됨
		} catch (ArithmeticException ae) {
//			printStackTrack() : 예외발생시의 호출스택에 있던 메서드 정보와 예외 메시지 출력
//			getMessage() : 발생한 예외클래스의 인스턴스에 저장된 메시지 반환
			ae.printStackTrace();	// 참조변수 ae를 통해, 생성됨 ArithemticException 인스턴스에 접근 가능
			System.out.println("예외 메시지 : " + ae.getMessage());
		}
		System.out.println(6);
	}
}
