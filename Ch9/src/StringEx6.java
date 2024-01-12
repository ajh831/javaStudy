
public class StringEx6 {
	public static void main(String[] args) {
		int iVal = 100;

		String strVal1 = iVal + "";
		String strVal2 = String.valueOf(iVal);

		double dVal = 200.0;
		String strVal3 = dVal + "";

//		double sum = Integer.parseInt(strVal1)
		double sum = Integer.parseInt("+" + strVal1)
				+ Double.parseDouble(strVal3); // 옛날 방식

		double sum2 = Integer.valueOf(strVal1) + Double.valueOf(strVal3); // 요즘엔 valueOf가 추세

		System.out.println(String.join("", strVal1, "+", strVal3, "=") + sum);
		System.out.println(strVal1 + "+" + strVal3 + "=" + sum);
	}
}
