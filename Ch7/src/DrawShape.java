
public class DrawShape {
	public static void main(String[] args) {
		Point[] p = {
				new Point(100, 100),
				new Point(140, 50),
				new Point(200, 100)
		};
		
		Triangle t = new Triangle(p);
//		Point p = new Point(150,150);
//		Circle c = new Circle(p, 50); 이 두 문장을 하나로 합쳐놓은 것이 아래 코드
		Circle c = new Circle(new Point(150, 150), 50);
		
		System.out.println("삼각형");
		t.draw();	// 삼각형 그리기
		System.out.println("\n원");
		c.draw();	// 원 그리기
	}
}

class Shape {	// 도형(색상)
	String color = "black";

	void draw() {
		System.out.printf("[color=%s]%n", color);
	}
}

class Point {	// 꼭짓점
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	Point() {
		this(0, 0);
	}

	String getXY() {
		return "(" + x + ", " + y + ")"; // x와 y의 값을 문자열로 반환
	}
}

class Circle extends Shape { // 원은 도형이다. : 상속관계
	Point center; // 원의 원점좌표
	int r; // 반지름
	

	Circle() {
		this(new Point(0, 0), 100); //
	}

	Circle(Point center, int r) {
		this.center = center;
		this.r = r;
	}

//	오버라이딩 : 조상 클래스에 정의된 메서드와 같은 메서드를 자손 클래스에 정의하는 것
	void draw() { // 원을 그리는 대신에 원의 정보를 출력하도록 함
		color = "orange";	// Shape를 상속 받았으니까 타입 정의 안하고 바로 변수 사용
		System.out.printf("[center=(%dx, %d), r=%d, color=%s]%n", center.x, center.y, r, color);
	}
}

class Triangle extends Shape {	// 삼각형은 도형이다. : 상속관계
//	삼각형은 꼭짓점을 가지고 있다. : 포함관계
	Point[] p = new Point[3];	// 3개의 Point인스턴스를 담을 배열을 생성
	
	Triangle(Point[] p) {
		this.p = p;
	}
	
//	오버라이딩 : 조상 클래스에 정의된 메서드와 같은 메서드를 자손 클래스에 정의하는 것
	void draw() {
		System.out.printf("[p1=%s, p2=%s, p3=%s, color=%s]%n"
				, p[0].getXY(), p[1].getXY(), p[2].getXY(), color);
	}
}
