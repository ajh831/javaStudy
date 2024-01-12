import java.util.Objects;

// 객체를 문자열로 바꾼다 : toString -> iv값들을 문자열로 바꾼다

class Card {
	String kind;
	int number;

	Card() {
		this("SPADE", 1);
	}

	Card(String kind, int number) {
		this.kind = kind;
		this.number = number;
	}
}

public class CardToString {
	public static void main(String[] args) {
		Card c1 = new Card();
		Card c2 = new Card();

		System.out.println(c1.toString());
		System.out.println(c2.toString());

	}
}
