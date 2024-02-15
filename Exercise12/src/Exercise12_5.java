public class Exercise12_5 {
	public static void main(String[] args) {
		Deck5 d = new Deck5(); // 카드 한 벌(Deck)을 만든다.
		Card5 c = d.pick(0); // 섞기 전에 제일 위의 카드를 뽑는다.
		System.out.println(c);
		
		d.shuffle(); // 카드를 섞는다
		c = d.pick(0); // 섞은 후에 제일 위의 카드를 뽑는다.
		System.out.println(c);
	}
}

class Deck5 {
	final int CARD_NUM = Card5.Kind.values().length
			* Card5.Number.values().length; // 카드의 개수
	Card5 cardArr[] = new Card5[CARD_NUM]; // Card객체 배열을 포함
	
	Deck5 () {
		/*
		 * (1) 알맞은 코드를 넣어서 완성하시오.
		 * Deck의 카드를 초기화 한다.
		 */
		Card5.Kind.values();
		Card5.Number.values();
		
		int idx = 0;
		for(Card5.Kind kind : Card5.Kind.values()) {
			for(Card5.Number num : Card5.Number.values()) {
				cardArr[idx++] = new Card5(kind, num);
			}
		}
		
		
	}
	
	Card5 pick(int index) { // 지정한 위치(index)에 있는 카드 하나를 꺼내서 반환
		return cardArr[index];
	}
	
	Card5 pick() { // Deck에서 카드 하나를 선택한다.
		int index = (int) (Math.random() * CARD_NUM);
		return pick(index);
	}
	
	void shuffle() { // 카드의 순서를 섞는다.
		for (int i = 0; i < cardArr.length; i++) {
			int r = (int) (Math.random() * CARD_NUM);
			
			Card5 temp = cardArr[i];
			cardArr[i] = cardArr[r];
			cardArr[r] = temp;
		}
	}
	
}

class Card5 {
	enum Kind { CLOVER, HEART, DIAMOND, SPADE }
	enum Number {
		ACE, TWO, THREE, FOUR, FIVE,
		SIX, SEVEN, EIGHT, NINE, TEN,
		JACK, QUEEN, KING
	}
	
	Kind kind;
	Number num;
	
	Card5() {
		this(Kind.SPADE, Number.ACE);
	}
	
	Card5(Kind kind, Number num) {
		this.kind = kind;
		this.num = num;
	}
	
	public String toString() {
		return "[" + kind.name() + ", " + num.name() + "]";
	}
}
