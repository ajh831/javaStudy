
public class StringEx3 {
	public static void main(String[] args) {
		// 길이가 0인 char 배열 생성
		char[] cArr = new char[0]; // char[] cArr = {};와 같음
		String s = new String(cArr); // String s = new String("");와 같음

		System.out.println("cArr.length=" + cArr.length);
		System.out.println("@@@"+s+"@@@");
	}
}
