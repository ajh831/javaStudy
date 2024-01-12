// 얉은 복사 깊은 복사 스스로 고민하고 해보기
import java.util.Objects;

class PointTest {
	int x;
	int y;
	
	PointTest() {
		this(1, 1);
	}
	
	PointTest(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof PointTest)) return false;
		
		PointTest p = (PointTest) obj;
		
		return this.x == p.x && this.y == p.y;
	}
	
	public int hashCode() {
		return Objects.hash(x,y);
	}
	
	public String toString() {
		return "x : " + x + ", y : " + y;
	}
}

class Circle implements Cloneable {
	PointTest p;
	double r;
	
	Circle(PointTest p, double r) {
		this.p = p;
		this.r = r;
	}
	
	public Circle clone() {	// 주소를 복사하므로 복사하게 되면 동일한 값을 보여줌
		Object obj = null;
		
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
		}
		return (Circle)obj;
	}

//	값은 동일하지만 다른 객체로 return 시키려면?
	Circle(Circle c) {
		this.p = c.p;
		this.r = c.r;
	}
	
	public Circle clone2() {	// 주소를 복사하므로 복사하게 되면 동일한 값을 보여줌
		Object obj = null;
		
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
		}
		Circle objC = (Circle)obj;
		
		objC.p = new PointTest(this.p.x, this.p.y);
		
		return objC;
	}
	
	public String toString() {
		return "p : (" + p + "), r : " + r;
	}
	
	public boolean equals(Object obj) {
		if (!(obj instanceof Circle)) return false;
		
		Circle c = (Circle) obj;
		
		return this.p.equals(c.p) && this.r == c.r;
	}
	
	public int hashCode() {
		return Objects.hash(p,r);
	}
}


public class CloneTest {
	public static void main(String[] args) {
		Circle c1 = new Circle(new PointTest(1, 1), 2.0);
		Circle c2 = c1.clone();
		Circle c3 = c1.clone2();
		
		c1.p.x = 10;
		c1.p.y = 10;
		
		if (c1.equals(c2)) {
			System.out.println("c1과 c2는 같습니다.");
		} else {
			System.out.println("c1과 c2는 다릅니다.");
		}
		
		if (c1.equals(c3)) {
			System.out.println("c1과 c3는 같습니다.");
		} else {
			System.out.println("c1과 c3는 다릅니다.");
		}

		System.out.println("c1 > "+c1.toString());
		System.out.println("c2 > "+c2.toString());
		System.out.println("c3 > "+c3.toString());
	}
}
