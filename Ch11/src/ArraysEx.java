import java.util.*;

public class ArraysEx {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 3, 4 };
		int[][] arr2D = { { 11, 12, 13 }, { 21, 22, 23 } };

		System.out.println("arr=" + Arrays.toString(arr));
		System.out.println("arr2D=" + Arrays.deepToString(arr2D));

//		copyOf : 배열 전체를 복사
//		copyOf(복사할 배열, 복사할 개수)
		int[] arr2 = Arrays.copyOf(arr, arr.length);
		// arr2 = arr 전체 복사 => 0,1,2,3,4
		int[] arr3 = Arrays.copyOf(arr, 3);
		// arr3 = arr 3개 복사 => 0,1,2
		int[] arr4 = Arrays.copyOf(arr, 7);
		// arr4 = arr 7개 복사 => 0,1,2,3,4,0,0 <- 없는 요소는 0으로 채워 넣음
		int[] arr5 = Arrays.copyOfRange(arr, 2, 4); // from ~ to
		// arr5 = arr 2부터 3까지 복사 => 2,3
		int[] arr6 = Arrays.copyOfRange(arr, 0, 7);
		// arr6 = arr 0부터 6까지 복사 => 0,1,2,3,4,0,0

		System.out.println("arr2=" + Arrays.toString(arr2));
		System.out.println("arr3=" + Arrays.toString(arr3));
		System.out.println("arr4=" + Arrays.toString(arr4));
		System.out.println("arr5=" + Arrays.toString(arr5));
		System.out.println("arr6=" + Arrays.toString(arr6));

		int[] arr7 = new int[5];
		Arrays.fill(arr7, 9); // arr=[9,9,9,9,9]
		System.out.println("arr7=" + Arrays.toString(arr7));

		Arrays.setAll(arr7, i -> (int) (Math.random() * 6) + 1); // 0~5 +1 -> 1~6
		System.out.println("arr7" + Arrays.toString(arr7));

		for (int i : arr7) {
			char[] graph = new char[i];
			Arrays.fill(graph, '*');
			System.out.println(new String(graph) + i);
		}

		String[][] str2D = new String[][] { { "aaa", "bbb" }, { "AAA", "BBB" } };
		String[][] str2D2 = new String[][] { { "aaa", "bbb" }, { "AAA", "BBB" } };

		// 2차원 배열은 deepEquals로 비교
		System.out.println(Arrays.equals(str2D, str2D2)); // false
		System.out.println(Arrays.deepEquals(str2D, str2D2)); // true
		System.out.println("= After sorting =");

		char[] chArr = { 'A', 'D', 'C', 'B', 'E' };

		System.out.println("chArr=" + Arrays.toString(chArr));
//		System.out.println("index of B=" + Arrays.binarySearch(chArr, 'B')); // 오류
		System.out.println("index of B=" + binarySearch(chArr, 'B')); // 오류
		System.out.println("index of B=" + search(chArr, 'B')); // 오류
		
		System.out.println();
		Arrays.sort(chArr);
		System.out.println("chArr=" + Arrays.toString(chArr));
//		System.out.println("index of B=" + Arrays.binarySearch(chArr, 'B'));
		System.out.println("index of B=" + binarySearch(chArr, 'B'));
		System.out.println("index of B=" + search(chArr, 'B')); // 오류
	}
	
	// binarySearch할때 걸리는 시간 파악
	public static int binarySearch(char[] arr, char ch) {
		long start = System.nanoTime();	// 나노세컨드(1/1000000000초)를 반환
		int num = Arrays.binarySearch(arr, ch);
		long end = System.nanoTime();
		long time = end - start;
		System.out.println("binarySearch 걸린 시간 : " + time);
		return num;
	};
	
	public static int search(char[] arr, char ch) {
		long start = System.nanoTime();	// 나노세컨드(1/1000000000초)를 반환
		int num = 0;
		for (int i = 0; i < arr.length; i++) {
			String str = String.valueOf(arr[i]);
			String chStr = String.valueOf(ch);
			if (str.equals(chStr)) {
				num = i;
				break;
			}else {
				num = -1;
			}
			
		}
		long end = System.nanoTime();
		long time = end - start;
		System.out.println("for문 Search 걸린 시간 : " + time);
		return num;
	}
}
