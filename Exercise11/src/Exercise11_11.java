import java.util.*;

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
		if (obj instanceof SutdaCard) {
			SutdaCard c = (SutdaCard) obj;
			return num == c.num && isKwang == c.isKwang;
		} else {
			return false;
		}
	}
	
	public int hashCode() {	// hashCode() : 해시함수는 찾고자하는 값을 입력하면, 그 값이 저장된 위치를 알려주는 해시코드를 반환
		return toString().hashCode();
	}

	public String toString() {
		return num + (isKwang ? "K" : "");
	}
	
}

public class Exercise11_11 {
	public static void main(String[] args) {
		SutdaCard c1 = new SutdaCard(3, true);
		SutdaCard c2 = new SutdaCard(3, true);
		SutdaCard c3 = new SutdaCard(1, true);

		HashSet set = new HashSet();

		set.add(c1);
		set.add(c2);
		set.add(c3);

		System.out.println(set);
	}
}