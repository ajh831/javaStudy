// Math.random(), Math.abs(int a), Math.min(int a, int b) 사용할 것

public class Exercise9_12 {
	public static int getRand(int from, int to) {
		
		// from과 to 중 무엇이 더 작은지 모르기 때문에 Math.min을 이용해서 자리 변경
		int tmp =0;
		Math.min(to, from);
		tmp = to;
		to = from;
		from = tmp;
		
		int rand = (int) (Math.random() * 10) + 1;
		
		return rand;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			System.out.print(getRand(1, -3) + ",");
		}
	}
}
