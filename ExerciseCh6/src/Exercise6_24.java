
public class Exercise6_24 {
	static int abs (int num) {
//		방법1
//		int result = Math.abs(num);
//		return result;
		
//		방법2
		if (num < 0) {
			num = -num;
		}
		return num;
	}
	
	public static void main(String[] args) {
		int value = 5;
		System.out.println(value + "의 절대값 : " + abs(value));
		value = -10;
		System.out.println(value + "의 절대값 : " + abs(value));
	}
}
