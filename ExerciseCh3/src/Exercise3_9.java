
public class Exercise3_9 {
	public static void main(String[] args) {
		char ch = 'z';
//		ch가 영문자(대문자, 소문자) 이거나 숫자일 때만 b값이 true
		boolean b = (
				ch>='a'&&ch<='z' || ch>='A'&&ch<='Z' || ch>='0'&&ch<='9'
				);
		
		System.out.println(b);
	}
}
