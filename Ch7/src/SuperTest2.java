
public class SuperTest2 {
	public static void main(String[] args) {
		Child2 c = new Child2();
		c.method();
	}
}

class Parent2 {
	int x = 10;	// 참조변수 super가 가리키는 것
}

class Child2 extends Parent2 {
	int x = 20;	// 참조변수 this가 가리키는 것
	
	void method() {
		System.out.println("x = " + x);
		System.out.println("this.x = " + this.x);
		System.out.println("super.x = " + super.x);
	}
}
