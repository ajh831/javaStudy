
public class OperatorEx16 {
	public static void main(String[] args) {
		float pi = 3.141592f;
		float shortPi = (int)(pi * 1000) / 1000f;
//		pi * 1000 = 3141.592
//		(int) 3141.592 = 3141
//		3141 / 1000f == 3141 / 1000.0 = 3.141
		System.out.println(shortPi);
	}
}
