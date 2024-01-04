class SutdaCard2 {
	int num = 1; // 1~10 사이의 정수
	boolean isKwang = true; // 광이면 true, 아니면 false
	String result;

	SutdaCard2() {
	}

	SutdaCard2(int n, boolean k) {
		this.num = n;

		if (k == false) {
			this.isKwang = k;
		}

	}

	String info() {
		if (this.isKwang == true) {
			this.result = this.num + "K";
		} else {
			this.result = String.valueOf(this.num);
		}
		return this.result;
	}
}

public class Exercise6_2 {
	public static void main(String[] args) {
		SutdaCard2 card1 = new SutdaCard2(3, false);
		SutdaCard2 card2 = new SutdaCard2();

		System.out.println(card1.info());
		System.out.println(card2.info());
	}
}
