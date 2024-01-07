import java.util.Scanner;

public class Exercise4_14 {
	public static void main(String[] args) {
//		1~100 사이의 임의의 값을 얻어서 answer에 저장한다.
		int answer = (int)(Math.random()*100) + 1;
		int input = 0;
		int count = 0;
		
//		화면으로 부터 사용자 입력을 받기 위해서 Scanner클래스 사용
		Scanner sc = new Scanner(System.in);
		
		do {
			count++;
			System.out.print("1과 100 사이의 값을 입력하세요 : ");
			input = sc.nextInt();
			
			if (input == answer) {
				System.out.println("맞췄습니다.");
				System.out.printf("시도횟수는 %d번 입니다.", count);
				break;
			} else if (input < answer) {
				System.out.println("더 큰 수를 입력하세요.");
			} else {
				System.out.println("더 작은 수를 입력하세요.");
			}
			
		} while (true);
	}
}
