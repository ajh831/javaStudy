import java.util.regex.*;

public class RegularEx1 {
	public static void main(String[] args) {
		String[] data = {"bat", "baby", "bonus", "cA", "ca", "co", "c.",
						"c0", "car", "combat", "count", "date", "disc"};
		Pattern p = Pattern.compile("c[a-z]*");	// c로 시작하는 소문자 영단어
		Pattern p2 = Pattern.compile("b[a-z]*");	// b로 시작하는 소문자 영단어
		
		System.out.print("c로 시작하는 단어 : ");
		for (int i = 0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if (m.matches()) {
				System.out.print(data[i] + ",");
			}
		}
		System.out.print("\nb로 시작하는 단어 : ");
		for (int i = 0; i < data.length; i++) {
			Matcher m = p2.matcher(data[i]);
			if (m.matches()) {
				System.out.print(data[i] + ",");
			}
		}
	}
}
