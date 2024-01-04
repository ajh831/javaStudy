
public class OperatorEx17 {
	public static void main(String[] args) {
		double pi = 3.141592;
		double shortPi = (int)(pi * 1000 + 0.5) / 1000.0;	// 소수점 넷째자리에서 반올림
//		pi * 1000 = 3141.592
//				+ 0.5 = 3142.092
//		(int) 3142.092 = 3142
//		3142 / 1000.0 = 3.142
		System.out.println(shortPi);
	}
}
