// 실행결과
// 0000012345
//
// 123

// String src : 변환할 문자열
// int length : 변환할 문자열의 길이

public class Exercise9_6 {
	public static String fillZero(String src, int length) {
//		(1) fillZero메서드를 작성하시오
//		1. src가 널이거나 src.length()가 length와 같으면 src를 그대로 반환
//		2. length의 값이 0보다 같거나 작으면 빈 문자열("")을 반환)
//		3. src의 길이가 length의 값보다 크면 src를 length만큼 잘라서 반환
//		4. 길이가 legnth인 char배열을 생성
//		5. 4에서 생성한 char배열을 '0'으로 채움
//		6. src에서 문자배열을 뽑아내서 4에서 생성한 배열에 복사
//		7. 4에서 생성한 배열로 String을 생성해서 반환
		
		if (src == null || src.length() == length) {
			return src;
		} else if(length <= 0) {
			return "";
		} else {
			char[] chr = new char[length];
			if (chr.length-src.length() > 0) {
				for (int i = 0; i < chr.length-src.length(); i++) {
					chr[i] = '0';
				}
				int idx=0;
				for (int i = src.length(); i < length; i++) {
					chr[i] = src.charAt(idx);
					idx++;
				}
			} else {
				for (int i =0; i< length; i++) {
					chr[i] = src.charAt(i);
				}
			}
			
			src = String.valueOf(chr);
			
			return src;
		}
		
	}
	
	public static void main(String[] args) {
		String src = "12345";
		System.out.println(fillZero(src, 10));
		System.out.println(fillZero(src, -1));
		System.out.println(fillZero(src, 3));
	}
}
