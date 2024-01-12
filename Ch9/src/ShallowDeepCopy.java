class Circle1 implements Cloneable { // clone()을 사용하려면 Cloneable 인터페이스를 확장해야됨
	Point1 p;
	double r;

	Circle1(Point1 p, double r) {
		this.p = p;
		this.r = r;
	}

	public Circle1 shallowCopy() { // 얕은 복사
		Object obj = null;

		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
		}

		return (Circle1) obj;
	}

	public Circle1 deepCopy() { // 깊은 복사
		Object obj = null;

		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
		}

		Circle1 c = (Circle1) obj;
		c.p = new Point1(this.p.x, this.p.y);

		return c;
	}

	public String toString() {
		return "[p=" + p + ", r=" + r + "]";
	}
}

class Point1 {
	int x, y;

	Point1() {
		this(1, 1);
	}

	Point1(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "[(" + x + ", " + y + ")";
	}

}

public class ShallowDeepCopy {
	public static void main(String[] args) {
		Point1 p = new Point1();
		Circle1 c1 = new Circle1(p, 2.0);
		Circle1 c2 = c1.shallowCopy();
		Circle1 c3 = c1.deepCopy();
		
		System.out.println("c1=" + c1);
		System.out.println("c2=" + c2);
		System.out.println("c3=" + c3);
		
		c1.p.x = 9;
		c1.p.y = 9;
		
		System.out.println("\n= c1의 변경 후 =");
		System.out.println("c1=" + c1);
		System.out.println("c2=" + c2);
		System.out.println("c3=" + c3);
	}
}
