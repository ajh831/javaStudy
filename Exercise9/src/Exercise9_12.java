// Math.random(), Math.abs(int a), Math.min(int a, int b) 사용할 것

public class Exercise9_12 {
	public static int getRand(int from, int to) {
		
//		// 내가 푼 것(틀림)
//		// from과 to 중 무엇이 더 작은지 모르기 때문에 Math.min을 이용해서 자리 변경
//		int tmp =0;
//		Math.min(to, from);
//		tmp = to;
//		to = from;
//		from = tmp;
//		
//		int rand = (int) (Math.random() * 10) + 1;
//		
//		return rand;
// -----------------------------------------------------------------------
		
		// 해설
		return (int) (Math.random() * (Math.abs(to-from)+1)) + Math.min(from, to);
		
		// 1 ~ 10 사이 임의의 값 구하는 방법
		// (int) (Math.random() * 10) + 1
		// 곱해준 값 10은 범위에 포함된 정수의 개수
		
		// from~to 인경우 : (끝값-시작값) +1
		// (int) (Math.random() * (to-from+1)) + 1
		
		// from이 to보다 큰 경우 처리를 위해 절대값 다용
		// (int) (Math.random() * (Math.abs(to-from)+1)) + 1
		
		// Math.random()에 더해주는 값 : 범위의 시작값
		// from이 to보다 큰경우도 처리해야 하므로 Math.min을 사용하여 작은 값이 더해지도록 계산
		// (int) (Math.random() * (Math.abs(to-from)+1)) + Math.min(from, to)
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			System.out.print(getRand(1, -3) + ",");
		}
	}
}
