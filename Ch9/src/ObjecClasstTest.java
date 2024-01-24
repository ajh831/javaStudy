// 사용법을 익히기 위한
// java.lang 패키지 테스트
import java.util.*;

public class ObjecClasstTest {
	public static void main(String[] args) {
// 1. protected Object clone();
		// 객체 자신의 복사본을 반환하는 메서드
		// 단순히 인스턴스변수의 값만 복사하기 때문에 참조타입의 인스턴스 변수가 클래스는 완전한 복사가 이루어지지 않음
		
		// 배열의 경우 복제된 인스턴스도 같은 배열의 주소를 갖기 때문에 복제된 인스턴스 작업이 기존의 인스턴스에 영향을 미치게 됨
		// clone()메서드를 오버라이딩하여 새로운 배열을 생헝한 뒤 내용 복사해야됨
		
		System.out.println("== protected Object clone() ==");
		// 얕은 복사
		System.out.println("= 얕은 복사 =");
		int[] arr = {1,2,3};
		int[] copy;
		copy = arr;
		copy[0] = 5;
		System.out.println("arr 주소 : " + arr);
		System.out.println("copy 주소 : " + copy);
		// 주소값 비교
		if (arr.equals(copy)) {
			System.out.println("주소값 일치");
			System.out.println("arr : " + Arrays.toString(arr));
			System.out.println("copy : " + Arrays.toString(copy));
		} else {
			System.out.println("주소값 불일치");
		}
		
		// 깊은 복사
		System.out.println();
		System.out.println("= 깊은 복사 =");
		int[] arr2 = {1,2,3,4,5};
		int[] copy2;
		copy2 = arr2.clone();
		copy2[0] = 5;
		System.out.println("arr 주소 : " + arr2);
		System.out.println("copy 주소 : " + copy2);
		// 주소값 비교
		if (arr2.equals(copy2)) {
			System.out.println("주소값 일치");
		} else {
			System.out.println("주소값 불일치");
			System.out.println("arr : " + Arrays.toString(arr2));
			System.out.println("copy : " + Arrays.toString(copy2));
		}
		// 배열을 복사하였을 때 값만 복사되고 주소값은 다른 것을 확인할 수 있음
		
		
		
// 2. public Class getClass();
		// 객체 자신의 클래스 정보를 담고 있는 Class인스턴스를 반환
		// 즉, 현재 참조하고 있는 클래스를 확인할 수 있는 메서드
		System.out.println("\n== public Class get Class() ==");
		Car c1 = new Car();
		Car c2 = new Taxi();
		Boat b = new Boat();
		
		System.out.println("c1의 getClass : " + c1.getClass());
		System.out.println("c2의 getClass : " + c2.getClass());
		System.out.println("b의 getClass : " + b.getClass());
		
		
		
// 3. public int hashCode();
		// 객체 자신의 해시코드를 반환
		// 값이 같은 경우 해시코드도 동일해야함
		System.out.println("\n== public int hashCode() ==");
		String str1 = "abcde";
		String str2 = "abcde";
		
		System.out.println("str1과 str2의 값 동일 여부 : " + str1.equals(str2));
		System.out.println("str1의 hashCode : " + str1.hashCode());
		System.out.println("str2의 hashCode : " + str2.hashCode());
		
		System.out.println("\nstr2 값 변경");
		str2 += "123";
		System.out.println("str1과 str2의 값 동일 여부 : " + str1.equals(str2));
		System.out.println("str1의 hashCode : " + str1.hashCode());
		System.out.println("str2의 hashCode : " + str2.hashCode());
		
		
		
	}
}

class Car {

}

class Taxi extends Car {

}

class Boat {

}