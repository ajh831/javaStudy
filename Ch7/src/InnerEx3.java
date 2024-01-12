
public class InnerEx3 {
	private int outerIv = 0;
	static int outerCv = 0;

	class InstanceInner {
		int iiv  = outerIv;  // 1. 외부 클래스의 private멤버도 접근가능하다.
		int iiv2 = outerCv;
	}

	static class StaticInner {
// 스태틱 클래스는 외부 클래스의 인스턴스멤버에 접근할 수 없다.
//		int siv = outerIv;
		static int scv = outerCv;
	}

	void myMethod() {
		int lv = 0;	// lv가 변수지만, 값을 변경하는 코드가 없으므로 실제로는 상수와 다름 없음
					// 값이 바뀌지 않는 변수는 상수로 간주 => 웬만하면 final 붙이는게 좋음
		final int LV = 0;  // JDK1.8부터 final 생략 가능
	
		class LocalInner {	// 2. 지역 내부 클래스를 감싸고 있는 메서드의 상수만 사용 가능
			int liv = outerIv;
			int liv2 = outerCv;
//	외부 클래스의 지역변수는 final이 붙은 변수(상수)만 접근가능하다.
			int liv3 = lv;	// 원래는 에러. (JDK1.8부터 에러 아님)
			int liv4 = LV;	// OK
		} 
	}
}
