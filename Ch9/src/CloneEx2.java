import java.util.Arrays;

public class CloneEx2 {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		int[] arrClone = arr.clone();	// 배열 arr을 복제해서 같은 내용의 새로운 배열을 만든다
		arrClone[1] = 1000;
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arrClone));
		
		int[] arrClone2 = new int [arr.length];
//						복사할배열, 복사할배열 시작 인덱스, 담을배열, 담길 시작 인덱스, 복사할 개수
		System.arraycopy(arr, 0, arrClone2, 0, arr.length);
		System.out.println(Arrays.toString(arrClone2));
		
	}
}
