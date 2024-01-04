
public class OperatorEx18 {
	public static void main(String[] args) {
		double pi = 3.141592;
//		double shortPi = (int)(pi * 1000 + 0.5) / 1000.0;	// 소수점 넷째자리에서 반올림
		double shortPi = Math.round(pi * 1000) / 1000.0;
		System.out.println(shortPi);
	}
}
