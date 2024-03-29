// 실행 결과
// c1 = 3K
// c2 = 3K
// c1.equals(c2) : true 

// SutdaCard클래스의 equals()를 멤버변수인 num, isKwang의 값을 비교하도록 오버라이딩하시오

import java.util.Objects;

public class Exercise9_1 {
	public static void main(String[] args) {
		SutdaCard c1 = new SutdaCard(3, true);
		SutdaCard c2 = new SutdaCard(3, true);
		SutdaCard c3 = new SutdaCard(3, false);
		
		System.out.println("c1 = " + c1);
		System.out.println("c2 = " + c2);
		System.out.println("c3 = " + c3);
		System.out.println("c1.equals(c2) : " + c1.equals(c2));
		System.out.println("c1.equals(c3) : " + c1.equals(c3));
	}
}

class SutdaCard {
	int num;
	boolean isKwang;

	SutdaCard() {
		this(1, true);
	}

	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}

	public boolean equals(Object obj) {
//		// 내가 푼 것
//		boolean result = false;
//		String str = toString();
//		String objStr = String.valueOf(obj.toString());
//		
//		if (Objects.equals(str, objStr)) {
//			result = true;
//		}
//		
//		return result;
		
// -----------------------------------------------------------------------
		// 해설
		if(obj instanceof SutdaCard) {	// 매개변수가 Object 타입이므로 instanceof로 확인 후 형변환
			SutdaCard c = (SutdaCard) obj;
			return num == c.num && isKwang == c.isKwang;
		}
		return false;
		
	}

	public String toString() {
		return num + (isKwang ? "K" : "");
	}
}
