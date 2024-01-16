abstract class Shape {
	Point p;

	Shape() {
		this(new Point(0, 0));
	}

	Shape(Point p) {
		this.p = p;
	}

	abstract double calcArea();

	Point getPosition() {
		return p;
	}

	void setPosition(Point p) {
		this.p = p;
	}
}

class Circle {
	int x, y;
	double r; // 반지름
	static Point p = new Point();

	Circle() {
		this(p, 1.0);
	}

	Circle(Point point, double r) {
		this.x = point.x;
		this.y = point.y;
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
		return "[" + x + "," + y + "," + r +"]";
	}
}

class Rectangle {
	int x, y;
	double width;
	double height;
	static Point p = new Point();
	
	Rectangle() {
		this(p, 1.0, 1.0);
	}

	Rectangle(Point point, double width, double height) {
		this.x = point.x;
		this.y = point.y;
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
		return "[" + x + "," + y + "," + width + "," + height +"]";
	}
}

class Point {
	int x;
	int y;

	Point() {
		this(0, 0);
	}

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "[" + x + "," + y + "]";
	}
}

public class Exercise7_22 {
	public static void main(String[] args) {
		Circle c = new Circle();
		c.r = 2;
		System.out.println(c.calcArea());
		
	}
}
