// 섯다카드 20장을 담는 SutdaCard1배열을 초기화.
// 섯다카드 1~10까지의 숫자 적힌 카드가 1장씩 들어있음
// 숫자가 1,3,8인 경우 둘 중의 한장은 광

class SutdaDeck1 {
	final int CARD_NUM = 20;
	SutdaCard1[] cards = new SutdaCard1[CARD_NUM];

	SutdaDeck1() {
		int num = 0;
		boolean[] boolArr = RandomKwang(CARD_NUM);
//		System.out.println(Arrays.toString(boolArr));
		boolean bool = false;
		for (int i = 0; i < cards.length; i++) {
			num = (i % 10) + 1;
			if (num == 1 || num == 3 || num == 8) {
				bool = boolArr[i];
			} else {
				bool = false;
			}

			cards[i] = new SutdaCard1(num, bool);
		}
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

class SutdaCard1 {
	int num;
	boolean isKwang;

	SutdaCard1() {
		this(1, true);
	}

	SutdaCard1(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}

	// info() 대신 Object클래스의 toString()을 오버라이딩했다.
	public String toString() {
		return num + (isKwang ? "K" : "");
	}
}

public class Exercise7_1_2 {
	public static void main(String[] args) {
		SutdaDeck1 deck = new SutdaDeck1();

		for (int i = 0; i < deck.cards.length; i++) {
			System.out.print(deck.cards[i] + ",");
		}
	}
}
