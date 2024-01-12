import java.util.Objects;

// 객체를 문자열로 바꾼다 : toString -> iv값들을 문자열로 바꾼다

class Card3 {
	String kind;
	int number;

	Card3() {
		this("SPADE", 1);
	}

	Card3(String kind, int number) {
		this.kind = kind;
		this.number = number;
	}

	// Object클래스의 toString()을 오버라이딩
	public String toString() {
		return "kind:" + kind + " number:" + number;
	}
	
	public boolean equals(Object obj) {
		if (!(obj instanceof Card3))return false;
		
		Card3 c = (Card3)obj;
		
		return this.kind.equals(c.kind) && this.number == c.number;
	}
	
	// equals()를 오버라이딩하면 hashCode()도 오버라이딩 해야한다
	public int hashCode() {
		return Objects.hash(kind, number);	// 가변인자라서 여러개 넣어도 됨
	}
}

public class CardToString3 {
	public static void main(String[] args) {
		Card3 c1 = new Card3();
//		Card3 c1 = new Card3("Heart",3);
		Card3 c2 = new Card3();

		if (c1.equals(c2)) {
			System.out.println("c1과 c2는 같습니다.");
		} else {
			System.out.println("c1과 c2는 다릅니다.");
		}
		
		System.out.println(c1.toString());
		System.out.println(c2.toString());

		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());

//		오버라이딩 하기 전 값
//		Card3@63440df3
//		Card3@3aeaafa6
		
//		오버라이딩 후
//		kind:SPADE number:1
//		kind:SPADE number:1

	}
}
