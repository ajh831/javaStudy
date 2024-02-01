
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
	}
}
