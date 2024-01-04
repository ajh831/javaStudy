
public class OperatorEx8 {
	public static void main(String[] args) {
		int a = 1_000_000;	// 1백만
		int b = 2_000_000;	// 2백만
		
		long c = a * b;	// 2_000_000_000_000;
		
		System.out.println(c); // 결과 : -1454759936로 값이 제대로 나오지 않음
//		값이 제대로 나오지 않는 이유
//		변수 c가 long 타입으로 지정되어 있으나,
//		변수 a와 b는 int 타입을 가지고 있기 때문에 연산 결과 또한 int형으로 나타나게 됨
//		계산 결과가 이미 -1454759936으로 나타났기 때문(오버플로우 발생)에 long 타입으로 자동 형변환이 되더라도 값은 그대로 유지
	}
}
