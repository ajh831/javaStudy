import java.util.Iterator;

public class Exercise4_3 {
	public static void main(String[] args) {
//		1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+2+3+...+10)
		int sum = 0;
		int answer = 0;
		
		for (int i = 1; i <= 10; i++) {
			sum += i;
//			i = 1 -> sum = 0 + 1
//			i = 2 -> sum = 1 + 2
//			i = 3 -> sum = (1 + 2) + 3
//			i = 4 -> sum = (1 + 2 + 3) + 4
			answer += sum;
		}
		System.out.println(answer);
	}
}
