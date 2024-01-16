abstract class Shape23 {
	Point23 p;

	Shape23() {
		this(new Point23(0, 0));
	}

	Shape23(Point23 p) {
		this.p = p;
	}

	abstract double calcArea();

	Point23 getPosition() {
		return p;
	}

	void setPosition(Point23 p) {
		this.p = p;
	}
}

class Circle23 extends Shape23 {
	int x, y;
	double r; // 반지름
	static Point23 p = new Point23();

	Circle23() {
		this(p, 1.0);
	}

	Circle23(double r) {
		this(p, r);
	}

	Circle23(int r) {
		this(p, r);
	}

	Circle23(Point23 Point23, double r) {
		this.x = Point23.x;
		this.y = Point23.y;
		this.r = r;
	}

	double calcArea() {
		// 원의 넓이 = 반지름 * 반지름 * 원주율
		// 원주율 = 원주 / 지름
		// 원주 = 지름 * 3.14

		double area = r * r * (((r + r) * Math.PI) / (r + r));

		return area;
	}

	public String toString() {
		return "[" + x + "," + y + "," + r + "]";
	}
}

class Rectangle23 extends Shape23 {
	int x, y;
	double width;
	double height;
	static Point23 p = new Point23();

	Rectangle23() {
		this(p, 1.0, 1.0);
	}

	Rectangle23(double width, double height) {
		this(p, width, height);
	}

	Rectangle23(int width, int height) {
		this(p, width, height);
	}

	Rectangle23(Point23 Point23, double width, double height) {
		this.x = Point23.x;
		this.y = Point23.y;
		this.width = width;
		this.height = height;
	}

	double calcArea() {
		double area = this.width * this.height;

		return area;
	}

	boolean isSquare() {
		if (this.width == this.height) {
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		return "[" + x + "," + y + "," + width + "," + height + "]";
	}
}

class Point23 {
	int x;
	int y;

	Point23() {
		this(0, 0);
	}

	Point23(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "[" + x + "," + y + "]";
	}
}

public class Exercise7_23 {
	static double sumArea(Shape23[] arr) {
		double sum= 0 ;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i].calcArea();
		}
		
		return sum;
	}
	
	
	public static void main(String[] args) {
		Shape23[] arr = {new Circle23(5.0), new Rectangle23(3,4), new Circle23(1)};
		System.out.println("면적의 합:" + sumArea(arr));
	}
}
