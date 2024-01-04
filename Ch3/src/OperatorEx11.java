
public class OperatorEx11 {
	public static void main(String[] args) {
//		A == 65
//		a == 97
//		0 == 48
		
		char a = 'a';
		char d = 'd';
		char zero = '0';
		char two = '2';
		
		System.out.printf("'%c' - '%c' = %d%n", d, a, d - a);
//		'd' - 'a' == 100 - 97 = 3
		System.out.printf("'%c' - '%c' = %d%n", two, zero, two - zero);
//		'2' - '0' == 50 - 48 = 2
//		숫자 char는 '0'을 빼주면 int 숫자를 얻을 수 있음
		System.out.printf("'%c'=%d%n", a, (int)a);
		System.out.printf("'%c'=%d%n", d, (int)d);
		System.out.printf("'%c'=%d%n", zero, (int)zero);
		System.out.printf("'%c'=%d%n", two, (int)two);
	}
}
