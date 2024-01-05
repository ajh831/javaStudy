
public class PointTest {
	public static void main(String[] args) {
		Point3D p3 = new Point3D(1, 2, 3);
		System.out.println(p3.getLocation());
	}
}

class Point2 {
	int x, y;
	
	Point2() {
		
	}
	
	Point2(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	String getLocation() {
		return "x : " + x + ", y : " + y;
	}
}

class Point3D extends Point2 {
	int z;
	
	Point3D(int x, int y, int z) {
//		방법 1
		super();
		
		this.x = x;
		this.y = y;
		this.z = z;

////		방법 2	
//		super(x, y);
//		
//		this.z = z;
	}
	
	String getLocation() {	// 오버라이딩
		return "x : " + x + ", y : " + y + ", z : " + z;
	}
}
