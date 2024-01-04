class Card {
	String kind;	// iv
	int number;		// iv
	static int width = 100;	// cv
	static int height = 250;// cv
}

class CardTest {
	public static void main(String[] args) {
		System.out.println("Card.widht = " + Card.width);
		System.out.println("Card.height = " + Card.height);
		
		Card c1 = new Card();
		c1.kind = "Heart";
		c1.number = 7;
		
		Card c2 = new Card();
		c2.kind = "Spade";
		c2.number = 4;
		
		System.out.println("c1은 " +  c1.kind + ", " + c1.number + "이며, 크기는 (" + c1.width + ", " + c1.height + ")");
		System.out.println("c2는 " +  c2.kind + ", " + c2.number + "이며, 크기는 (" + c2.width + ", " + c2.height + ")");
//		System.out.println("c1의 width와 height를 각각 50, 80으로 변경합니다.");
//		c1.width = 50;	// 객체를 여러개 만들었을 때 c1을 바꿨는데 왜 c2도 바뀐거지?와 같이 오해할 수 있으므로
//		c1.height = 80;
		System.out.println("Card의 width와 height를 각각 50, 80으로 변경합니다.");
		Card.width = 50; // 이와 같이 class명을 이용하여 cv(공통변수)값을 변경
		Card.height = 80;

		System.out.println("c1은 " +  c1.kind + ", " + c1.number + "이며, 크기는 (" + c1.width + ", " + c1.height + ")");
		System.out.println("c2는 " +  c2.kind + ", " + c2.number + "이며, 크기는 (" + c2.width + ", " + c2.height + ")");
	}
}
