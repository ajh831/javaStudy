
public class OperatorEx7 {
	public static void main(String[] args) {
		byte a = 10;
		byte b = 20;
//		byte c = a + b;	// 에러. 컴파일 에러 발생함
//		byte c = a + (byte)b;	// 에러. 한쪽만 하면 안됨
		byte c = (byte)(a + b);
		System.out.println(c);
		
//		명시적으로 형변환 하지 않아도 되는 것
//								cf) float은 4byte로 int 8byte보다 작은 것 같지만 10의 38승 정도 되므로 int 보다 큼
//		byte -> short -> int -> float -> double
//				char  ->	
	}
}
