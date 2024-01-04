
public class IntegerSize {
	public static void main(String[] args) {
		int num = 100_000_000;
		System.out.println(num);
		
//		int num2 = 100_000_000_000;	// 에러.
//		System.out.println(num2);
		
//		int num3 = 10_000_000_000;	// 에러.
//		System.out.println(num3);
		
		int num4 = 1_000_000_000;
		System.out.println(num4);
		
//		int num5 = 9_999_999_999;	// 에러.
//		System.out.println(num5);
		
		int num6 = 1_000_000_001;	// 에러.
		System.out.println(num6);
		
		int num7 = 2_147_483_647;
		System.out.println(num7);

//		int num8 = 2_147_483_648;	// 에러.
//		System.out.println(num8);

		int a = 1_000_000_000;
		int b = 2_000_000_000;
		System.out.println(a * b); // 오류
		System.out.println(a * (long)b); // 형변환
	}
}
