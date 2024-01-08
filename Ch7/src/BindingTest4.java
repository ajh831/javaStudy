
public class BindingTest4 {
	public static void main(String[] args) {
		Parent5 p = new Child5();
		Child5 c = new Child5();

		System.out.println("p.x = " + p.x);
		p.method();
		System.out.println();
		System.out.println("c.x = " + c.x);
		c.method();
	}
}

class Parent5 {
	int x = 100;

	void method() {
		System.out.println("Parent Method");
	}
}

class Child5 extends Parent5 {
	int x = 200;

	void method() {
		System.out.println("x = " + x);	// this.x와 동일
		System.out.println("super.x = " + super.x);	// Parent5의 x
		System.out.println("this.x = " + this.x);	// Child5의 x
	}
}
