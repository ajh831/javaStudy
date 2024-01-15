import java.util.ArrayList;

public class RoundTest {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();	// 원래 객체만 저장가능한 클래스
		list.add(new Integer(100)); // list에는 객체만 추가가능
		list.add(100); // JDK1.5이전에는 에러였지만 현재는 컴파일러가 자동으로 컴파일 해줌
		// 기본형도 저장가능 -> 자동으로 컴파일러가 변환을 해주기 때문에(오토박싱)
		
//		Integer i = list.get(0); // list에 저장된 첫번째 객체를 꺼냄
		int i = list.get(0).intValue(); // intValue()로 Integer를 int로 변환
		int i2 = list.get(0); // Integer -> int 자동으로 형변환 (오토)언박싱
	}
}
