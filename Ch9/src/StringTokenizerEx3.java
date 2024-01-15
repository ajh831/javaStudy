import java.util.StringTokenizer;

public class StringTokenizerEx3 {
	public static void main(String[] args) {
		String source = 
				"1,김천재,100,100,100|2,박수재,95,80,90|3,이자바,80,90,90";
		// StringTokenizer는 단 한 문자의 구분자만 사용할 수 있으므로
		// "+-*/=()" 전체가 하나의 구분자가 아니라 각각의 문자가 모두 구분자임
		StringTokenizer st = new StringTokenizer(source, "|");
		
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			
			StringTokenizer st2 = new StringTokenizer(token, ",");
			while (st2.hasMoreTokens()) {
				System.out.println(st2.nextToken());
			}
			System.out.println("------");
		}
	}
}
