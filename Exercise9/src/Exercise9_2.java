// 실행결과
// [1,2,3]
// [1,2,3]
// p1==p2 ? false
// p1.equals(p2) ? true

// equals(), toString() 오버라이딩하시오

import java.util.Iterator;
import java.util.Objects;

public class Exercise9_2 {
	public static void main(String[] args) {
		Point3D p1 = new Point3D(1, 2, 3);
		Point3D p2 = new Point3D(1, 2, 3);

		System.out.println(p1);
		System.out.println(p2);
		System.out.println("p1==p2 ? " + (p1 == p2));
		System.out.println("p1.equals(p2) ? " + p1.equals(p2));
	}
}

class Point3D {
	int x, y, z;

	Point3D() {
		this(0, 0, 0);
	}

	Point3D(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public boolean equals(Object obj) {
		boolean result = false;
		// == 객체 주소 비교
		// equals 객체의 값 비교
		
		Point3D obj2 = (Point3D) obj;
		if (this.x == obj2.x && this.y == obj2.y && this.z == obj2.z) {
			result = true;
		}
		
		return result;
	}


	public String toString() {
		return "[" + this.x + "," + this.y + "," + this.z + "]";
	}
}
