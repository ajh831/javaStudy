
public class PointTest2 {
	public static void main(String[] args) {
//		Point3D_2 p3 = new Point3D_2(1, 2, 3);
		Point3D_2 p3 = new Point3D_2();
		System.out.println("p3.x = " + p3.x);
		System.out.println("p3.y = " + p3.y);
		System.out.println("p3.z = " + p3.z);
	}
}

class Point2D {
	int x = 10;
	int y = 20;

	Point2D(int x, int y) {
//		super(); // Object클래스의 기본 생성자인 Objec()를 호출
		
		this.x = x;
		this.y = y;
	}

	String getLocation() {
		return "x : " + x + ", y : " + y;
	}
}

class Point3D_2 extends Point2D {
	int z = 30;

	Point3D_2() {
		this(100, 200, 300);
	}

	Point3D_2(int x, int y, int z) {
		super(x, y);	// Point(int x, int y)를 호출
		this.z = z;
	}

	String getLocation() { // 오버라이딩
		return "x : " + x + ", y : " + y + ", z : " + z;
	}
}
