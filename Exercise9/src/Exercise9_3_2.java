import java.util.*;

public class Exercise9_3_2 {
	public static void main(String[] args) {
		String fullPath = "c:\\jdk1.8\\work\\PathSeparateTest.java";
		String path = "";
		String fileName = "";

		// split()메서드 사용시 \\ 문자가 분리가 되지 않음
		// 1. 문자를 char형식으로 변경
		// 1.1. \가 나오면
		// 1.1.1. 다른 문자로 변경한다.','
		// 2. 문자를 합친다
		// 3. ^을 기준으로 문자를 분리
		// 3.1. 인덱스-1 부분까지 join해서 path 참조변수에 담는다.
		// 3.2. 마지막 인덱스는 fileName 참조변수에 담는다.
		String str2 = "";
		for (int i = 0; i < fullPath.length(); i++) {
			String str = fullPath.substring(i, i + 1);
			if (!str.equals("\\")) {
				str2 += str;
			} else {
				str2 += ",";
			}
		}
//		System.out.println(str2);
		
		String[] arr = str2.split(",");
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < arr.length; i++) {
			if (i < arr.length-1) {
				path += (i==0)? "" + arr[i] : "\\" + arr[i];
			}else {
				fileName += arr[i];
			}
		}
		
		System.out.println("fullPath : " + fullPath);
		System.out.println("path : " + path);
		System.out.println("fileName : " + fileName);
	}
}
