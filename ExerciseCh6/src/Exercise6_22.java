import java.text.ParseException;

public class Exercise6_22 {
	static boolean isNumber (String str) {
		boolean check = true;
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) < '0' || str.charAt(i) > '9') {
				check = false;
				return check;
			}
		}
		
		return check;
	}
	
	public static void main(String[] args) {
		String str = "a123";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));

		str = "1234567";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));
	}
}
