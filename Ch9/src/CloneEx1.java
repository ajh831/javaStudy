class Point implements Cloneable { // Cloneable인터페이스를 구현한 클래스에서만 clone() 호출 가능
	int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "x=" + x + ", y=" + y;
	}

//	public Object clone() {
//		Object obj = null;
//		try {
//			obj = super.clone(); // clone()은 반드시 예외처리를 해줘야됨
//		} catch (CloneNotSupportedException e) {
//		}
//		return obj;
//	}
	
	public Point clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
		}
		return (Point) obj;
	}
}

public class CloneEx1 {
	public static void main(String[] args) {
		Point original = new Point(3, 5);
//		Point copy = (Point)original.clone(); // 복제(clone)해서 새로운 객체를 생성
											  // Object 타입으로 반환되었기 때문에 다시 Point로 형변환 시켜줘야됨
		Point copy = original.clone(); 
		System.out.println("original :\t" + original);
		System.out.println("copy :\t\t" + copy);
	}
}
