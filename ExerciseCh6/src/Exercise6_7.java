class MyPoint {
	int x;
	int y;
	
	MyPoint() {

	}
	
	MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	double getDistance(int x1, int y1) {
		int a = (this.x-x1)*(this.x-x1);
		int b = (this.y-y1)*(this.y-y1);
		double c = Math.sqrt(a+b);
		
		return c;
	}
	
}

public class Exercise6_7 {
	public static void main(String[] args) {
		MyPoint p = new MyPoint(1,1);
		
		// p와 (2,2)의 거리를 구한다.
		System.out.println(p.getDistance(2, 2));
	}

}
