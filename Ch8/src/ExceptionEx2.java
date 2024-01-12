
public class ExceptionEx2 {
	public static void main(String[] args) {
		int number = 10;;
		int result = 0;
		
		for (int i = 0; i < 10; i++) {
			result = number / (int) (Math.random() * 10);
			System.out.println(result);
		}
	}
}
