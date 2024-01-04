import java.util.Arrays;

public class Exercise6_23 {
	static int max(int[] arr) {
		if (arr == null || arr.length == 0) {	// null or 크기가 0인 배열
//		if (arr.length == 0 || arr == null) {
			// 오류. 연산 방향(왼->오)인데 null인경우 arr.length를 확인할 수 없기 때문에 오류가 생겨서
			// main메서드에서 System.out.println("최대값:"+max(null)); 코드 오류 발생
			return -999999;
		}

//		배열 오름차순 정렬
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}

//		마지막 값(최대값) return
		return arr[arr.length - 1];
	}

	public static void main(String[] args) {
		int[] data = { 3, 2, 9, 4, 7 };
		System.out.println(Arrays.toString(data));
		System.out.println("1. 최대값 : " + max(data));
		System.out.println("2. 최대값 : " + max(null));
		System.out.println("3. 최대값 : " + max(new int[] {})); // 크기가 0인 배열
	}
}
