// 시작 단과 끝 단, 두개의 정수를 입력하여 구구단을 출력한다.
// 1. 구구단 클래스 필요
// 2. 입력받는 메서드 필요
// 3. 출력하는 메서드 필요

// 1. 입력받는 클래스 필요
// 	1.1. 입력을 받는다
// 2. 입력받은 값을 반환한다

import java.util.*;

// 해설
public class Exercise9_11 {
	public static void main(String[] args) {
		int from = 0;
		int to = 0;

		try {
			if (args.length != 2) {
				throw new Exception("시작 단과 끝 단, 두개의 점수를 입력해주세요.");
			}

			from = Integer.parseInt(args[0]);
			to = Integer.parseInt(args[1]);

			if (!(2 <= from && from <= 9 && 2 <= to && to <= 9)) {
				throw new Exception("단의 범위는 2와 9사이의 값이어야 합니다.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("USAGE : GugudanTest 3 6");
			System.exit(0);
			;
		}

		// 시작 단(from)이 긑 단(to)보다 작아야하니까
		// to보다 From의 값이 크면 두 값을 바꾼다.
		if (from > to) {
			int tmp = from;
			from = to;
			to = tmp;
		}

		// from단부터 to단까지 출력한다
		for (int i = from; i <= to; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.println(i + "*" + j + "=" + i * j);

			}
			System.out.println();
		}
	}
}
