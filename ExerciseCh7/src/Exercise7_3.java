// 섯다카드 20장을 담는 SutdaCard2배열을 초기화.
// 섯다카드 1~10까지의 숫자 적힌 카드가 1장씩 들어있음
// 숫자가 1,3,8인 경우 둘 중의 한장은 광

class SutdaDeck2 {
	final int CARD_NUM = 20;
	SutdaCard2[] cards = new SutdaCard2[CARD_NUM];

	SutdaDeck2() {
		int num = 0;
		boolean[] boolArr = RandomKwang(CARD_NUM);
		boolean bool = false;
		for (int i = 0; i < cards.length; i++) {
			num = (i % 10) + 1;
			if (num == 1 || num == 3 || num == 8) {
				bool = boolArr[i];
			} else {
				bool = false;
			}

			cards[i] = new SutdaCard2(num, bool);
		}
	}
	
	// 메서드명 : shuffle
	// 반환타입 X, 매개변수 X
	void shuffle() {
		for (int i = 0; i < cards.length; i++) {
			int shuff = (int) (Math.random() * CARD_NUM);
			SutdaCard2 tmp = cards[0];
			cards[0] = cards[shuff];
			cards[shuff] = tmp;
		}
	}
	
	// 메서드명 : pick
	// 반환타입 SutdaCard
	// 매개변수 : int index - 위치
	SutdaCard2 pick(int index) {
		
		return cards[index];
	}

	// 메서드명 : pick
	// 반환타입 SutdaCard
	// 매개변수 : X
	SutdaCard2 pick() {
		int index = (int) (Math.random() * CARD_NUM);
		return cards[index];
	}
	
	// 1,3,8인 경우 둘 중 한장이 광일 수 있게 숫자 부여
	boolean[] RandomKwang(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			int randIdx = (int) (Math.random() * 2);
			if(i < arr.length/2) {
				if(randIdx == 0) {
					arr[i] = 2;
				} else {
					arr[i] = randIdx;
				}
			} else {
				if(arr[i-n/2] == 1) {
					arr[i] = 2;					
				} else {
					arr[i] = 1;
				}
			}
		}
//		System.out.println(Arrays.toString(arr));
		
		boolean[] bolArr = new boolean[arr.length];
		for (int i = 0; i < bolArr.length; i++) {
			if (arr[i] == 1) {
				bolArr[i] = false;
			} else {
				bolArr[i] = true;
			}
		}
		
		return bolArr;
	}
}

class SutdaCard2 {
	int num;
	boolean isKwang;

	SutdaCard2() {
		this(1, true);
	}

	SutdaCard2(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}

	// info() 대신 Object클래스의 toString()을 오버라이딩했다.
	public String toString() {
		return num + (isKwang ? "K" : "");
	}
}

public class Exercise7_3 {
	public static void main(String[] args) {
		SutdaDeck2 deck = new SutdaDeck2();
		
		for (int i = 0; i < deck.cards.length; i++) {
			System.out.print(deck.cards[i] + ",");
		}
		System.out.println();

		System.out.println(deck.pick(0));
		System.out.println(deck.pick());
		
		deck.shuffle();
		
		for (int i = 0; i < deck.cards.length; i++) {
			System.out.print(deck.cards[i] + ",");
		}
	}
}
