
public class Exercise4_2 {
	public static void main(String[] args) {
//		1~20까지의 정수 중 2or3의 배수가 아닌 수의 총합
//		1, 5, 7, 11, 13, 17, 19
		int sum=0;
		for (int i = 1; i <= 20; i++) {
			if (i%2!=0 && i%3!=0) {
				sum += i;
//				System.out.println(i);
			}
		}
		System.out.println(sum);
	}
}
