
public class Ex14_0 {
	public static void main(String[] args) {
//		Object obj = (a, b) -> a > b ? a : b // 람다식. 익명객체
		// 위 아래 동일 한 것
		Object obj = new Object() {
			int max(int a, int b) {
				return a > b ? a : b;
			}
		};
		
//		int value = obj.max(3,5);	// 에러. 참조변수 obj의 타입이 Object이지만 amx()라는 버튼이 아에 없어서 호출할 수 없음
		// 그래서 필요한게 함수형 인터페이스
		
//		MyFunction_EX f = new MyFunction_EX() {
////			int max(int a, int b) {
////				return a > b ? a : b;
////			}
//			public int max(int a, int b) {	// 오버라이딩 규칙 : 접근제어자는 좁게 못 바꾼다
//				return a > b ? a : b;
//			}
//		};
		
//		위의 코드를 람다식으로 짧게 줄이면 아래의 코드가 된다.
		// 람다식(익명 객체)을 다루기 위한 참조변수의 타입은 함수형 인터페이스로 한다.
		MyFunction_EX f = (a, b) -> a > b ? a : b; // 람다식, 익명객체
		
		int value = f.max(3, 5); // 함수형 인터페이스
		System.out.println("value = " + value);
	}
}


@FunctionalInterface	// 함수형 인터페이스는 단 하나의 추상 메서드만 가져야 함.
interface MyFunction_EX {
//	public abstract int max(int a, int b);
	int max(int a, int b);	// 인터페이스의 모든 메서드는 public이면서 동시에 abstract이므로 생략가능
}