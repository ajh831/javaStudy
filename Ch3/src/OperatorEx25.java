import java.util.Scanner;

public class OperatorEx25 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		char ch = ' ';

		System.out.printf("문자를 하나 입력하세요.>");

		String input = sc.nextLine();
		ch = input.charAt(0); // 문자가 여러개 입력됐을 경우 첫번째 문자 추출
		System.out.println(ch);

		if ('0' <= ch && ch <= '9') {
			System.out.printf("입력하신 문자는 숫자입니다.\n");
		}

		if (('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z')) {
			System.out.printf("입력하신 문자는 영문자입니다.\n");
		}
	}
}
