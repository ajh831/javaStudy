final class Card4 {
	String kind;
	int num;

	Card4() {
		this("SPADE", 1);
	}

	Card4(String kind, int num) {
		this.kind = kind;
		this.num = num;
	}

	public String toString() {
		return kind + ":" + num;
	}

}

public class ClassEx1 {
	public static void main(String[] args) throws Exception{ 	// newInstance()오류로 예외처리
		Card4 c = new Card4("HEART", 4);	// new연산자로 객체 생성
		Card4 c2 = Card4.class.newInstance();	// Class객체를 통해서 객체 생성
		
//		Class객체를 이용하면 클래스에 정의된 멤버 이름, 개수 등 클래스에 대한 모든 정보를 얻을 수 있음
		Class cObj = c.getClass();	// 생성된 객체로부터 class 정보 얻는 방법
		
		System.out.println(c);	// Class4에서 오버라이딩한 toString이 반환됨
		System.out.println(c2);	// Class4에서 오버라이딩한 toString이 반환됨
		System.out.println(cObj.getName());	// 클래스명
		System.out.println(cObj.toGenericString());	// 제어자 클래스 클래스명
		System.out.println(cObj.toString());	// 클래스 클래스명(제어자 제외)
	}
}
