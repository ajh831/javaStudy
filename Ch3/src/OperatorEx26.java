
public class OperatorEx26 {
	public static void main(String[] args) { 
		int a = 5;
		int b = 0;

		System.out.printf("a=%d, b=%d%n", a, b);
		System.out.printf("a!=0 || ++b!=0 = %b%n%n", a!=0 || ++b!=0); // ++b == 1 -> true || true => true
		
		System.out.printf("a=%d, b=%d\n", a, b);
		System.out.printf("a==0 && ++b!=0 = %b%n%n", a==0 && ++b!=0); // false && true => false
		
		System.out.printf("a=%d, b=%d%n", a, b);
	}
}
