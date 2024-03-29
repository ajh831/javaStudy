import java.util.*;
import static java.util.Objects.*;	// Objects클래스의 메서드를 static import

public class ObjectsTest {
	public static void main(String[] args) {
		String[][] str2D = new String[][] {{"aaa", "bbb"}, {"AAA", "BBB"}};
		String[][] str2D_2 = new String[][] {{"aaa", "bbb"}, {"AAA", "BBB"}};
		
		System.out.println("str2D = {");
		
		for(String[] tmp : str2D) {
			System.out.print(Arrays.toString(tmp));
		}
		System.out.println("}");
		
		for(String[] tmp : str2D_2) {
			System.out.print(Arrays.toString(tmp));
		}
		System.out.println("}");
		
		System.out.println("equals(str2D, str2D_2)="
				+ Objects.equals(str2D,str2D_2));
		System.out.println("deepEquals(str2D, str2D_2)="
				+ Objects.deepEquals(str2D,str2D_2));
		
		System.out.println("isNull(1) = " + isNull(1));
		System.out.println("isNull(null) = " + isNull(null));
		System.out.println("nonNull(1) = " + nonNull(1));
		System.out.println("nonNull(null) = " + nonNull(null));
		System.out.println("hashCode(null) = " + Objects.hashCode(null));
		// hashCode : 각 객체의 주소값을 변환하여 생성한 객체의 고유한 정수값
		System.out.println("toString(null) = " + Objects.toString(null));
		System.out.println("toString(null, \"\") = " + Objects.toString(null, ""));
		
		Comparator c = String.CASE_INSENSITIVE_ORDER;	// 대소문자 구분 안하는 비교
		
		System.out.println("compare(\"aa\",\"bb\") = " + compare("aa", "bb", c));
		System.out.println("compare(\"bb\",\"aa\") = " + compare("bb", "aa", c));
		System.out.println("compare(\"ab\",\"AB\") = " + compare("ab", "AB", c));
	}
}
