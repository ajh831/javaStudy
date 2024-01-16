import java.util.Arrays;

public class Exercise7_19 {
	public static void main(String[] args) {
		Buyer b = new Buyer();
		b.buy(new Tv());
		b.buy(new Computer());
		b.buy(new Tv());
		b.buy(new Audio());
		b.buy(new Computer());
		b.buy(new Computer());
		b.buy(new Computer());

		b.summary();
	}
}

class Buyer {
	int money = 1000; // 가진돈
	Product[] cart = new Product[3];
	int i = 0;

	void buy(Product p) {
		if (this.money < p.price) {
			System.out.println("잔액이 부족하여 " + p + "을/를 살수 없습니다.");
		} else {
			this.money -= p.price; // (1) 1.2
			add(p); // (1) 1.3
		}
	}

	void add(Product p) {
		if (this.i >= cart.length) { // (2) 1.1
			Product[] newCart = new Product[cart.length * 2]; // (2) 1.1.1
			for (int j = 0; j < cart.length; j++) {
				newCart[j] = this.cart[j]; // (2) 1.1.2
			}
			this.cart = newCart; // (2) 1.1.3
		}
		
		cart[this.i] = p;	// (2) 1.2
		// (2) 1.2
		this.i++;

	}

	void summary() {
		int sum = 0;
		// (3) 1.1
		System.out.print("구입한 물건:");
		for (int j = 0; j < cart.length; j++) {
			System.out.print(this.cart[j] + ",");
		}
		// (3) 1.2
		for (int j = 0; j < cart.length; j++) {
			sum += cart[j].price;
		}
		System.out.println();
		System.out.println("사용한 금액:" + sum);
		System.out.println("남은 금액:" + money);
	}
}

class Product {
	int price;

	Product(int price) {
		this.price = price;
	}
}

class Tv extends Product {
	Tv() {
		super(100);
	}

	public String toString() {
		return "Tv";
	}
}

class Computer extends Product {
	Computer() {
		super(200);
	}

	public String toString() {
		return "Computer";
	}
}

class Audio extends Product {
	Audio() {
		super(50);
	}

	public String toString() {
		return "Audio";
	}
}
