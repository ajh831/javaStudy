import java.math.BigInteger;

public class BigIntegerEx {
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {	// 1!부터 99!까지 출력
			System.out.printf("%d!=%s%n", i, calcFactorial(i));
		}
	}
	
	static String calcFactorial(int n) {
		return factorial(BigInteger.valueOf(n)).toString();
	}
	
//	BigInteger.ZERO = 0
//	BigInteger.ONE = 1
//	BigInteger.TEN = 10
	static BigInteger factorial(BigInteger n) {
		if(n.equals(BigInteger.ZERO)) {	// 작수인경우
			return BigInteger.ONE;
		} else {	// return n * factorial(n-1);
			return n.multiply(factorial(n.subtract(BigInteger.ONE)));	// subtract : 빼기
		}
	}
}
