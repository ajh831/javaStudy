import java.util.*;

public class ArrayListEx2 {
	public static void main(String[] args) {
		final int LIMIT = 10; // 자르고자 하는 글자의 개수를 지정함
		String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ";
		int length = source.length();
//		System.out.println(length); // 43글자

		List list = new ArrayList(length / LIMIT + 10); // 크기를 약간 여유있게 잡는다

		for (int i = 0; i < length; i += LIMIT) {
			if (i + LIMIT < length) {
				list.add(source.substring(i, i + LIMIT));
				// i=0 : 0<=x<10 -> 0123456789
				// i=i+LIMIT = 0+10 : 10<=x<20 -> abcdefghij
				// i=i+LIMIT = 20 : 20<=x<30 -> ABCDEFGHIJ
				// i=i+LIMIT = 30 : 30<=x<40 -> !@#$%^&*()
				// i=i+LIMIT = 40 : 30<=x<50 -> ZZZ
			} else {
				list.add(source.substring(i));
			}
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
