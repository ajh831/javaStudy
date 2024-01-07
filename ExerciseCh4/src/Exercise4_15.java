
public class Exercise4_15 {
	public static void main(String[] args) {
		int number = 12321;
		int tmp = number;
		
		int result = 0;	// 변수 number를 거꾸로 변환해서 담을 변수
		
//		tmp = 12321
//		12321 % 10 = 1
//		result = 1 * 10
//			result = 10
//			tmp = 12321 / 10 = 1232

//		tmp = 1232
//		1232 % 10 = 2
//		result = 10 + 2
//		result = 12 * 10
//			result = 120
//			tmp = 1232 / 10 = 123

//		tmp = 123
//		123 % 10 = 3
//		result = 120 + 3
//		result = 123 * 10
//			result = 1230
//			tmp = 123 / 10 = 12
		
//		tmp = 12
//		12 % 10 = 2
//			tmp = 12 / 10 = 1
		
//		tmp = 1
//		1 % 10 = 1
//			tmp = 1 / 10 = 0
		
		while (tmp != 0) {
			result = tmp%10 + result*10;
			tmp /= 10;
		}
		System.out.println(result);
		
		if (number == result) {
			System.out.println(number + "는 회문수 입니다.");
		} else {
			System.out.println(number + "는 회문수가 아닙니다.");
		}
	}
}
