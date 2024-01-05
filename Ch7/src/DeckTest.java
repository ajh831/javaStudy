
public class DeckTest {
	public static void main(String[] args) {
		Deck d = new Deck();	// 카드 한 벌(Deck)을 만듦
		Card c = d.pick(0);	// 섞기 전에 제일 위의 카드를 뽑음
		System.out.println(c);	// System.out.println(c.toString());과 같음
//		위와 같이 참조변수의 출력이나 덧셈연산자를 이용한 참조변수와 문자열의 결합에는
//		toString()이 자동적으로 호출되어 참조변수를 문자열로 대치한 후 처리함
		
		d.shuffle();	// 카드를 섞음
		c = d.pick(0);	// 섞은 후에 제일 위의 카드를 뽑음
		System.out.println(c);	// System.out.println(c.toString());과 같음
	}
}

class Deck {
	final int CARD_NUM = 52;	// 카드의 개수
//	Deck은 Card를 가지고 있다. : 포함관계
	Card cardArr[] = new Card[CARD_NUM];	// Card객체 배열을 포함
	
	Deck() {
		int i=0;
		
		for (int k = Card.KIND_MAX; k > 0; k--) {
			for (int n = 0; n < Card.NUM_MAX; n++) {
				cardArr[i++] = new Card(k, n+1);
			}
		}
	}
	
	Card pick(int index) {	// 지정된 위치(index)에 있는 카드 하나를 꺼내서 반환
		return cardArr[index];
	}
	
	Card pick() {	// 지정된 위치(index)에 있는 카드 하나를 꺼내서 반환
		int index = (int)(Math.random() * CARD_NUM);
		return pick(index);
	}
	
	void shuffle() {	// 카드의 순서를 섞음
		for (int i = 0; i < cardArr.length; i++) {
			int r = (int)(Math.random() * CARD_NUM);
			
			Card temp = cardArr[i];
			cardArr[i] = cardArr[r];
			cardArr[r] = temp;
		}
		
	}
}

class Card {
	static final int KIND_MAX = 4;	// 카드 무늬의 수
	static final int NUM_MAX = 13;	// 무늬별 카드 수
	
	static final int SPADE = 4;
	static final int DIAMOND = 4;
	static final int HEART = 4;
	static final int CLOVER = 4;
	
	int kind;
	int number;
	
	Card() {
		this(SPADE, 1);
	}

	Card(int kind, int number) {
		this.kind = kind;
		this.number = number;
	}
	
	public String toString() {
		String[] kinds = {"", "CLOVER", "HEART", "DIAMOND", "SPADE"};
		String numbers = "0123456789JQK";	// 숫자 10은 X로 표현
		
		return "kind : " + kinds[this.kind]
				+ ", number : " + numbers.charAt(this.number);
	}
}
