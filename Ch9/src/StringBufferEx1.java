
public class StringBufferEx1 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("abc");
		StringBuffer sb2 = new StringBuffer("abc");
		
		System.out.println("sb == sb2 ? " + (sb == sb2));	// false. 주소가 다름
		System.out.println("sb.equals(sb2) ? " + sb.equals(sb2));	// false. equlas()가 오버라이딩 되어있지 않음
		
		// StringBuffer의 내용을 String으로 변환
		String s = sb.toString();	// String s = new String(sb);와 같음
		String s2 = sb2.toString();
		
		System.out.println("s.equals(s2) ? " + s.equals(s2)); // String으로 변환해주어서 동일한 글자가 되어 주소가 같아짐
	}
}
