// 실행결과
// 가나다
//  가나다
//   가나다

// String str : 변환할 문자열
// int length : 변환된 문자열의 길이
// int alignment : 변환된 문자열의 정렬조건
//	(0:왼쪽정렬, 1:가운데정렬, 2:오른쪽정렬)

public class Exercise9_10 {
//	(1) format메서드를 작성하시오
//	1. length의 값이 str의 길이보다 작으면 length만큼만 잘라서 반환
//	2. 1의 경우가 아니면, length크기의 char배열을 생성하고 공백으로 채움
//	3. 정렬조건 (alignment)의 값에 따라 문자열(str)을 복사할 위치를 결정
//		(System.arraycopy() 사용)
//	4. 2에서 생성한 char배열을 문자열로 만들어서 반환
	public static String format(String str, int length, int alignment) {
		char[] chr = new char[length];
		if (str.length() > length) {
			return str.substring(0, length);
		} else {
			for (int i = 0; i < chr.length; i++) {
				chr[i] = '_'; // 원래 문제는 공백이지만 시각적으로 확인하기 위하여 '_'로 변경하였음
			}

			char[] strChar = str.toCharArray();

			int startIdx = 0;
			if (alignment == 0) {
				System.arraycopy(strChar, 0, chr, startIdx, str.length());
			} else if (alignment == 1) {
				startIdx = (int) (length / (double) 2) - (int) (str.length() / (double) 2); // 7/2=3, 3/2
				System.arraycopy(strChar, 0, chr, startIdx, str.length());
			} else {
				startIdx = length - str.length();
				System.arraycopy(strChar, 0, chr, startIdx, str.length());
			}
		}

		return String.valueOf(chr);
	}

	public static void main(String[] args) {
		String str = "가나다";

		System.out.println(format(str, 9, 0)); // 왼쪽 정렬
		System.out.println(format(str, 9, 1)); // 가운데 정렬
		System.out.println(format(str, 9, 2)); // 오른쪽 정렬
		System.out.println();

		String str2 = "가나다라마";
		System.out.println(format(str2, 15, 0)); // 왼쪽 정렬
		System.out.println(format(str2, 15, 1)); // 가운데 정렬
		System.out.println(format(str2, 15, 2)); // 오른쪽 정렬
	}
}
