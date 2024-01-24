// 사용법을 익히기 위한
// java.lang 패키지 테스트
import java.util.*;

public class StringClassTest {
	public static void main(String[] args) {
// 1. String(String s)
		// 주어진 문자열을 갖는 String 객체 생성
		System.out.println("= String(String s) =");
		String s = new String("Hello Java");
		System.out.println(s);
		
// 2. Stirng(char[] value)
		// 주어진 문자열을 갖는 String객체 생성
		// char 배열을 String객체의 매개변수로 넣는 경우 각각의 문자가 합쳐져 하나의 문자열이 됨
		System.out.println("\n= Stirng(char[] value) =");
		char[] c = {'H','e','l','l','o',' ','J','a','v','a'};
		s = new String(c);
		System.out.println(s);
		
// 3. String(StringBuffer buf)
		System.out.println("\n= String(StringBuffer buf) =");
		// StringBuffer 객체가 갖고 있는 문자열과 동일한 내용의 String 객체를 생성
		StringBuffer sb = new StringBuffer("Hello StringBuffer");
		s = new String(sb);
		// string : 불변 -> 문자에 변화를 주는 경우 새로운 주소를 가리키게 됨
		// StringBuffer : 가변 -> 동일한 메모리영역(주소)에서 값이 변화하게 됨
		System.out.println(sb);
		// StringBuffer 객체인 참조변수 sb를 출력했는데 주소가 나오지 않고 문자열이 나오는 이유
		// StringBuffer 내에서 toString() 메서드를 오버라이딩 했기 때문
		System.out.println(s);
		
		System.out.println(s.equals(sb)); // false
		// s.equals(sb)가 false로 나오는 이유
		// String 클래스의 equals() 메서드는 값을 비교하기에 앞서서 타입을 먼저 비교함
		// s와 sb는 String과 StringBuffer 타입으로 서로 다르기 때문에 false를 반환
		
		System.out.println(sb.equals(s)); // false
		// sb.equals(s)가 false로 나오는 이유
		// StringBuffer는 equals()메서드를 오버라이딩하고 있지 않음
		// Object 클래스의 equals()메서드는 값을 비교하는 것이 아닌 주소값을 비교함
		// sb와 s는 서로 다른 객체이기 때문에 false를 반환
		
		System.out.println(s.equals(sb.toString())); // true
		
// 4. char charAt(int index)
		// 지정된 위치에 있는 문자를 반환
		System.out.println("\n= char charAt(int index) =");
		
		
	}
}
