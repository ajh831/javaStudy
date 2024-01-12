
public class ExceptionEx9 {
	public static void main(String[] args) {
		try {
			Exception e = new Exception("고의로 발생시켰음.");
			throw e; // 예외 발생시킴
//			throw new Exception("고의로 발생시켰음."); // 위의 두줄을 한줄로 요약한 코드
		} catch (Exception e) {
			System.out.println("에러 메시지 : " + e.getMessage()); // 예외 메시지 보여줌
			e.printStackTrace(); // 예외 발생시 호출스텍에 있던 예외 메시지 보여줌
		}
		System.out.println("프로그램이 정상 종료되었음.");
	}
}
