// 시작 단과 끝 단, 두개의 정수를 입력하여 구구단을 출력한다.
// 1. 구구단 클래스 필요
// 2. 입력받는 메서드 필요
// 3. 출력하는 메서드 필요

// 1. 입력받는 클래스 필요
// 	1.1. 입력을 받는다
// 2. 입력받은 값을 반환한다

import java.util.*;

class Gogodan {
	final int num1;
	final int num2;

	Gogodan() {
		this(2, 9);
	}

	Gogodan(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
		print(num1, num2);
	}

	public static boolean print(int num1, int num2) {
		System.out.println("USAGE : GugudanTest 3 5");
		if (!(num1 >= 2 && num1 <= 9 && num2 >= 2 && num2 <= 9)) {
			System.out.println("단의 범위는 2와 9사이의 값이어야 합니다.");
			return true;
		} else {
			String str = "";
			for (int i = num1; i <= num2; i++) {
				for (int j = 1; j < 10; j++) {
					System.out.println(i + "*" + j + "=" + i * j);
				}
				System.out.println();
			}
			return false;
		}
	}
}

class Input {
	Scanner sc = new Scanner(System.in);
	String number1 = sc.nextLine();
	int num1 = Integer.valueOf(number1);
	String number2 = sc.nextLine();
	int num2 = Integer.valueOf(number2);

	Gogodan gogodan = new Gogodan(num1, num2);
}


public class Exercise9_11 {
	public static void main(String[] args) {
		while (true) {
			System.out.println("시작 단과 끝 단, 두 개의 정수를 입력해주세요.");
			while (true) {
				Input i = new Input();
			}

		}
	}
}
