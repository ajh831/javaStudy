
public class Exercise6_8 {

}

class PlayingCard {
	int kind;	// 인스턴스변수
	int num;	// 인스턴스변수
	
	static int width;	// 클래스변수
	static int height;	// 클래스변수
	
	PlayingCard(int k, int n) {	// k, n : 지역변수
		kind = k;
		num = n;
	}
	
	public static void main(String[] args) {
		PlayingCard card = new PlayingCard(1, 1);
	}
}