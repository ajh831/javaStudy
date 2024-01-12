
public class StringEx1 {
	public static void main(String[] args) {
		String str1 = "abc";	// 문자열 리터럴(상수) "abc"의 주소가 str1에 저장됨
		String str2 = "abc";	// 문자열 리터럴(상수) "abc"의 주소가 str2에 저장됨
		System.out.println("String str1 = \"abc\";");
		System.out.println("String str2 = \"abc\";");
		
		System.out.println("str1 == str2 ? " + (str1 == str2));	// true. 주소가 동일하므로
		System.out.println("str1.equals(str2) ? " + str1.equals(str2));	// true. 동일한 문자 이므로
		
		System.out.println();
		String str3 = new String("abc");	// 새로운 String 인스턴스를 생성
		String str4 = new String("abc");	// 새로운 String 인스턴스를 생성
		System.out.println("String str3 = \"abc\";");
		System.out.println("String str4 = \"abc\";");
		
		System.out.println("str3 == str4 ? " + (str3 == str4));	// false. 각각의 객체이므로 주소가 다름
		System.out.println("str3.equals(str4) ? " + str3.equals(str4));	// true. 동일한 문자 이므로
		
		
	}
}
