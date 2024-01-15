
public class FinallyTest3 {
	public static void main(String[] args) {
		method1();
		System.out.println("method1()의 수행을 마치고 main메서드로 돌아옴");
	}
	
	static void method1() {
		try {
			System.out.println("method1()이 호출됨");
			return;	// 현재 실행중인 메서드 종료
//			throw new Exception("에러 발생");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {	// return문이 존재하더라도 finally문 실행 후 return!!!
			System.out.println("method1()의 finally블럭이 실행됨");
		}
	}
}
