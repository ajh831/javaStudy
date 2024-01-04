import java.util.Arrays;

public class Exercise6_20 {
	static int[] shuffle(int[] arr) {
//		1,2,3,4,5,6,7,8,9
//		1  2,3,4,5,5,6,7,8
//			8	2,3,4,5,6,7,1
//		8,2	 3,4,5,6,7,1
//			8,3  2,4,5,6,7,1
		int num=0;
		for (int i = 0; i < arr.length; i++) {
			num = (int)(Math.random()*10);
			if (i > num) {
				int tmp = arr[i];
				arr[i] = arr[num];
				arr[num] = tmp; 
			}
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		int[] original = {1,2,3,4,5,6,7,8,9};
		System.out.println(Arrays.toString(original));
		
		int[] result = shuffle(original);
		System.out.println(Arrays.toString(result));
	}

}
