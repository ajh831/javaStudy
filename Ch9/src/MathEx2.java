import static java.lang.Math.*;
import static java.lang.System.*;


public class MathEx2 {
	public static void main(String[] args) {
		int i = Integer.MIN_VALUE;
		
//		참고. 부호연산식 '-a'와 '~a+1'은 동등함
//		~a+1 : 부호를 반대로 바꾸는 식
//		~a의 결과가 int의 최대값인 경우, 여기에 1을 더하기 때문에 오버플로우가 발생할 수 있는 것
//		~연산은 0은 1로, 1은 0으로 변환시킴
//		10000000 00000000 00000000 00000000	: -2147483648 int 최소값
//		01111111 11111111 11111111 11111111	:  2147483647 int 최대값 +1 ejgkrl -> 오버플로우 발생
//		10000000 00000000 00000000 00000000 : -2147483648 int 최소값
		
		out.println("i =" + i);
		out.println("-i =" + (-i));

		//		negateExact : 부호를 변경해줌
		try {
			out.printf("try문 1 : negateExact(%d)= %d%n", 10, negateExact(10));
			out.printf("try문 2 : negateExact(%d)= %d%n", -10, negateExact(-10));
			out.printf("try문 3 : negateExact(%d)= %d%n", i, negateExact(i));	// 예외발생
//			-2147483648 -> 부호변경 -> 2147483648 but int의 최대값은 2147483647 이므로 예외가 발생하게 되는 것
		} catch (Exception e) {
			// i를 long타입으로 형변환한 다음에 negateExact(long a)를 호출
			out.printf("catch문 : negateExact(%d)= %d%n", (long)i, negateExact((long)i));
		}
	}
}
