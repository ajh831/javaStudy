
public class ExceptionEx5 {
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(0/0); // 0으로 나눠서 고의로 ArithmeticException을 발생시킴
			System.out.println(4);
		} catch (ArithmeticException ae) {
			System.out.println(5);
		}
		System.out.println(6);
	}
}
