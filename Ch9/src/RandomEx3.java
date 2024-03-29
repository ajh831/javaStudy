import java.util.*;


public class RandomEx3 {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.print(getRand(5, 10)+ ", ");
		}
		System.out.println();
		
		int[] result = fillRand(new int[10], new int[] {2,3,7,5});
		
		System.out.println(Arrays.toString(result));
	}
	
	public static int[] fillRand(int[] arr, int from , int to) {	// : 배열 arr을 fromm과 to 범위의 값들로 채워서 반환
		for (int i = 0; i < arr.length; i++) {
			arr[i] = getRand(from, to);
		}
		return arr;
	}
	
	public static int[] fillRand(int[] arr, int[] data) {	// 배열 arr을 배역 data에 있는 값들로 채워서 반환
		for (int i = 0; i < data.length; i++) {
			arr[i] = data[getRand(0, data.length-1)];
		}
		return arr;
	}
	
	
	public static int getRand(int from, int to) {	// from과 to범위의 정수(int)값을 반환. from과 to 모두 범위에 포함됨
		return (int) (Math.random() * (Math.abs(to-from) + 1)) + Math.min(from, to);
	}
}
