class MyPoint_1 {
	int x;
	int y;
}

class Circle_1 extends MyPoint_1 { // 상속
	int r;
}

class Circle_2 {	// 포함
	MyPoint_1 p = new MyPoint_1();	// 참조변수의 초기화
	int r;
}

public class InheritanceTest {
	public static void main(String[] args) {
		Circle_1 c = new Circle_1();
		c.x = 1;
		c.y = 2;
		c.r = 3;
		System.out.println("c.x = " + c.x);
		System.out.println("c.y = " + c.y);
		System.out.println("c.r = " + c.r);
		
		System.out.println();
		Circle_2 c2 = new Circle_2();
		c2.p.x =1;
		c2.p.y =2;
		c2.r =3;
		System.out.println("c2.p.x = " + c2.p.x);
		System.out.println("c2.p.y = " + c2.p.y);
		System.out.println("c2.r = " + c2.r);
		
	}
}
