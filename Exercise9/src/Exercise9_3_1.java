import java.util.Arrays;

public class Exercise9_3_1 {
	public static void main(String[] args) {
		String fullPath = "c:\\jdk1.8\\work\\PathSeparateTest.java";
		String path = "";
		String fileName = "";
		
		// 1. \\ 문잘르 기준으로 분리한다.
		// 2. 인덱스-1 부분까지 join해서 path 참조변수에 담는다.
		// 3. 마지막 인덱스는 fileName 참조변수에 담는다.
		
		String[] arr = fullPath.split("\\");
		// 배열 copy하는 메서드가 생각이 안남
		
		String[] pathArr = new String[arr.length-1];
		for (int i = 0; i < pathArr.length; i++) {
			pathArr[i] = arr[i];
		}
		
		System.out.println(Arrays.toString(arr));
		
		
		System.out.println("fullPath : " + fullPath);
		System.out.println("path : " + path);
		System.out.println("fileName : " + fileName);
	}
}
