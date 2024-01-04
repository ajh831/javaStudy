
public class OperatorEx12 {
	public static void main(String[] args) {
		char c1 = 'a';	// 'a' == 97
		char c2 = c1;
		char c3 = ' ';	// 참고) char에는 ''(빈문자열)을 저장할 수 없음
		
		int i = c1 + 1;	// 'a' + 1 == 97 + 1 = 98
		
		c3 = (char)(c1 + 1); // (char)98 = 'b'
		c2++;	// 97+1 = 98 = 'b'
		c2++;	// 98+1 = 99 = 'c'
		
		System.out.println("i=" + i);
		System.out.println("c2=" + c2);
		System.out.println("c3=" + c3);
	}
}
