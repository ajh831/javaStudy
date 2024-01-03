
public class FactorialTest3 {
	static long factorial3 (int n) {
		if(n <= 0 || n > 20) {	// 매개변수의 유효성 검사
			return -1;
		}
		if(n <= 1) {
			return 1;
		}
//		return n * factorial2(n-1);
		
		int result = 1;
		while(n!=0) {
			System.out.printf("=%20d%n", result);
			result *= n--;
		}
		return result;
	}
	
	public static void main(String[] args) {
//		int n = 21;
		int n = 20;
//		long result = 0;
		
//		for (int i = 1; i <= n; i++) {
//			result = factorial2(i);
//			
//			if (result == -1) {
//				System.out.printf("유효하지 않은 값입니다. (0 < n <= 20) : %d%n", n);
//				break;
//			}
//			
//			System.out.printf("%2d!=%20d%n", i, result);
//		for (int i = 1; i <= n; i++) {
//			result = factorial2(i);
//			
//			if (result == -1) {
//				System.out.printf("유효하지 않은 값입니다. (0 < n <= 20) : %d%n", n);
//				break;
//			}
//			
//			System.out.printf("%2d!=%20d%n", i, result);
//		}
		
			long result = factorial3(n);
			
	}
}
