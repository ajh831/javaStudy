import java.util.Scanner;

public class SutdaCard {
	public static void main(String[] args) {
		int num;	// 1~10 사이의 정수
		boolean isKwang = false;	// 광이면 true, 아니면 false
		
		num = (int) (Math.random()*10);
		Scanner sc = new Scanner(System.in);
		String kwang = sc.nextLine();
		if (kwang.equals("광")) {
			isKwang = true;
		}
		
		System.out.println(num);
		System.out.println(isKwang);
	}
}
