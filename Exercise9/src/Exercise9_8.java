// 실행결과
// 3.1
// 3.14
// 3.142
// 3.1415
// 3.1415

public class Exercise9_8 {
	public static double round(double d, int n) {
//		1. n자리 수까지 값을 보여줘야 한다.
//		2. n자리 수는
//		3.1415 -> 314.15 -> (int) 314 -> 10으로 나눈 나머지 확인
//		5보다 작으면 값을 빼주고
//		5보다 크면 10의 자리를 1 증가
		
		double num = d * Math.pow(10, n+1);
		if (num % 10 < 5) {
			num -= (num % 10);
		} else {
			num = num + 10 - (num%10);
		}
		
		num = num / Math.pow(10, n+1);
		
		return num;
	}
	
	public static void main(String[] args) {
		System.out.println(round(3.1415, 1));
		System.out.println(round(3.1415, 2));
		System.out.println(round(3.1415, 3));
		System.out.println(round(3.1415, 4));
		System.out.println(round(3.1415, 5));
	}
}
