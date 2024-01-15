import java.util.regex.*;

public class RegularEx3 {
	public static void main(String[] args) {
		String source = "HP:011-1111-1111, HOME:02-999-9999 ";
		// 괄호로 나누어 정규식을 3부분으로 나누어서 묶음(그룹화)
		String pattern = "(0\\d{1,2})-(\\d{3,4})-(\\d{4})";
		// 0\\d{1,2} : 0으로 시작하는 최소 2자리 최대 3자리 숫자(0포함)
		// \\d{3,4} : 최소 3자리 최대 4자리의 숫자
		// \\d{4} : 4자리의 숫자
		
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(source);
		
		int i=0;
		while(m.find()) {	// 찾으면 true, 못찾으면 false
			System.out.println( ++i + ": " + m.group() + " -> " + m.group(1)
									+ ", " + m.group(2) + ", " + m.group(3));
		}
	}
}
