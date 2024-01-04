
public class Exercise6_6 {
//	두 점의 거리 계산
//	피타고라스?
	static double getDistance(int x, int y, int x1, int y1) {
		int a = (x-x1)*(x-x1);
		int b = (y-y1)*(y-y1);
		double c = Math.sqrt(a+b);
		
		return c;
	}

	public static void main(String[] args) {
		System.out.println(getDistance(1, 1, 2, 2));
	}

}
