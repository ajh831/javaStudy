// 정렬 기준 : 내림차순

import java.util.*;

public class Exercise11_13 {
	public static void main(String[] args) throws Exception {
		SutdaDeck13 deck = new SutdaDeck13();
		
		deck.shuffle();
		
		Player13[] pArr = {
				new Player13("타짜", deck.pick(), deck.pick()),
				new Player13("고수", deck.pick(), deck.pick()),
				new Player13("물주", deck.pick(), deck.pick()),
				new Player13("중수", deck.pick(), deck.pick()),
				new Player13("하수", deck.pick(), deck.pick())
		};
		
		TreeMap rank = new TreeMap(new Comparator() {
			public int compare(Object o1, Object o2) {
				if(o1 instanceof Player13 && o2 instanceof Player13) {
					Player13 p1 = (Player13)o1;
					Player13 p2 = (Player13)o2;
					return p2.point - p1.point;
				}
				return -1;
			}
		});
		
		for (int i = 0; i < pArr.length; i++) {
			Player13 p = pArr[i];
			rank.put(p, deck.getPoint(p));
			System.out.println(p + " " + deck.getPoint(p));
		}
		
		System.out.println();
		System.out.println("1위는 " + rank.firstKey() + "입니다.");
	}
}

class SutdaDeck13 {
	final int CARD_NUM = 20;
	SutdaCard13[] cards = new SutdaCard13[CARD_NUM];

	int pos = 0; // 다음에 가져올 카드의 위치
	HashMap jokbo = new HashMap(); // 족보를 저장할 HashMap

	SutdaDeck13() {
		for (int i = 0; i < cards.length; i++) {
			int num = i % 10 + 1;
			boolean isKwang = i < 10 && (num == 1 || num == 3 || num == 8);

			cards[i] = new SutdaCard13(num, isKwang);
		}
		registerJokbo(); // 족보를 등록
	}

	void registerJokbo() {
		int score = 4000;
		for (int i = 11; i > 0; i--) {
			if (i == 11) {
				jokbo.put("KK", score);
			} else {
				String str = String.valueOf(i) + String.valueOf(i);
				score -= 10;
				jokbo.put(str, score);
			}
		}

		jokbo.put("12", 2060);
		jokbo.put("21", 2060);
		jokbo.put("14", 2050);
		jokbo.put("41", 2050);
		jokbo.put("19", 2040);
		jokbo.put("91", 2040);
		jokbo.put("110", 2030);
		jokbo.put("101", 2030);
		jokbo.put("410", 2020);
		jokbo.put("104", 2020);
		jokbo.put("46", 2010);
		jokbo.put("64", 2010);
	}

	int getPoint(Player13 p) {
		if (p == null)
			return 0;

		SutdaCard13 c1 = p.c1;
		SutdaCard13 c2 = p.c2;

		Integer result = 0;

		if (c1.isKwang && c2.isKwang) {
			result = (Integer) jokbo.get("KK");
		} else {
			result = (Integer) jokbo.get("" + c1.num + c2.num);

			if (result == null) {
				result = new Integer((c1.num + c2.num) % 10 + 1000);
			}
		}

		p.point = result.intValue();

		return result.intValue();
	}

	SutdaCard13 pick() throws Exception {
		SutdaCard13 c = null;

		if (0 <= pos && pos < CARD_NUM) {
			c = cards[pos];
			cards[pos++] = null;
		} else {
			throw new Exception("남아있는 카드가 없습니다.");
		}

		return c;
	}

	void shuffle() {
		for (int x = 0; x < CARD_NUM * 2; x++) {
			int i = (int) (Math.random() * CARD_NUM);
			int j = (int) (Math.random() * CARD_NUM);
			
			SutdaCard13 tmp = cards[i];
			cards[i] = cards[j];
			cards[j] = tmp;
		}
	}
}

class Player13 {
	String name;
	SutdaCard13 c1;
	SutdaCard13 c2;

	int point;

	Player13(String name, SutdaCard13 c1, SutdaCard13 c2) {
		this.name = name;
		this.c1 = c1;
		this.c2 = c2;
	}

	public String toString() {
		return "[" + name + "]" + c1.toString() + ", " + c2.toString();
	}

}

class SutdaCard13 {
	int num;
	boolean isKwang;

	SutdaCard13() {
		this(1, true);
	}

	SutdaCard13(int num, boolean isKang) {
		this.num = num;
		this.isKwang = isKang;
	}

	public String toString() {
		return num + (isKwang ? "K" : "");
	}

}