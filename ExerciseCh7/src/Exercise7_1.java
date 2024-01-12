import java.util.Arrays;
import java.util.Iterator;

// 섯다카드 20장을 담는 SutdaCard배열을 초기화.
// 섯다카드 1~10까지의 숫자 적힌 카드가 1장씩 들어있음
// 숫자가 1,3,8인 경우 둘 중의 한장은 광

class SutdaDeck {
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];

	SutdaDeck() {
		// 우선 cards에 num을 넣어본다
//		num 1 2 3 4 5 6 7 8 9 10 11 12
//		i	0 1 2 3 4 5 6 7 8 9  10 11
//                               -10
//		num 1 2 3 4 5 6 7 8 9 10  1  2 
//							num-i 1  1  1	

//		숫자가 1, 3, 8인 경우 둘 중 한장 광!
//		1,3,8이 위치할 수 있는 자리는
//		v   v         v      v    v              v
//		0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19
//		1 2 3 4 5 6 7 8 9 10 1 2  3   4  5  6  7  8  9  10

//		배열 위치 0,2,7,10,12,17
//		+1
//		        1 3 8 11 13 18

		int num = 1;
		int num2 = 0;
		for (int i = 0; i < cards.length; i++) {

//			1. 숫자넣기
			if (num >= 11) {
				num = num - i + num2;
				cards[i] = new SutdaCard(num, false); // 뒤쪽 1,2,3,4~10
				num2++;
			} else {
				cards[i] = new SutdaCard(num, false); // 앞쪽 1,2,3,4~10
			}

//			2. 광자리 찾기
			String str = (i + 1) + "";
			int idx = str.charAt(str.length() - 1) - '0'; // 숫자 일의 자리값 추출
			System.out.println("idx : " + idx);

//			배열의 크기를 확인하고 나누기 10을해서 떻어지는 몫이 1~10이 반복하는 개수
//			개수를 랜덤으로 해서 해당하는 위치를 각각 1개씩 추출

			int deckCnt = CARD_NUM / 10;

//			1,3,8,11,13,18
//			System.out.println(randIdx);

//			1 1 1 1 1 1 1 1 1 1 2 2 2 2 2 2 2 2 2 2 구간
			int[] idxArr = new int[3];
			for (int j = 0; j < 3; j++) {
				int randIdx = (int) (Math.random() * deckCnt) + 1; // 1 or 2값을 구할 수 있음
				idxArr[j] = randIdx; // 무작위 3개
			}
//			System.out.println("ㅌㅌ" + Arrays.toString(idxArr));
			
//			idxArr[0] = 1
//			idxArr[1] = 2
//			idxArr[2] = 1
			
			if (idxArr[0] == 1) {
				cards[i] = new SutdaCard(num, false);
			}
			

			num++;
		}
	};
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

	// info() 대신 Object클래스의 toString()을 오버라이딩했다.
	public String toString() {
		return num + (isKwang ? "K" : "");
	}
}

public class Exercise7_1 {
	public static void main(String[] args) {
		SutdaDeck deck = new SutdaDeck();

		for (int i = 0; i < deck.cards.length; i++) {
			System.out.print(deck.cards[i] + ",");
		}
	}
}
