import java.util.regex.*;


// 단어 찾아서 변경
public class RegularEx4 {
	public static void main(String[] args) {
		//				 from          to			from				  to
		//                '2,3,4,5,6,7,8'			  '31,32,33,34,35,36,37'			
		String source = "A broken hand works, but not a broken heart.";
		String pattern = "broken";
		StringBuffer sb = new StringBuffer();
		
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(source);
		System.out.println("source : " + source);
		
		int i=0;
		
		while(m.find()) {
			System.out.println(++i + "번째 매칭 : " + m.start() + "~" + m.end());
			// broken을 drunke으로 치환하여 sb에 저장
			m.appendReplacement(sb, "drunken");
		}
		
		m.appendTail(sb);
		System.out.println("Replacement count : " + i);
		System.out.println("result : " + sb.toString());
	}
}
