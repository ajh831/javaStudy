import java.util.Random;
import java.util.stream.IntStream;

public class StreamMake3 {
	public static void main(String[] args) {
		IntStream intStream = new Random().ints();
		intStream.limit(5).forEach(System.out::println); // limit(5) : 5개만 자르기
//		intStream.forEach(System.out::println); // limit사용 하지 않으면 무한스트림이기 때문에 계속해서 숫자가 나옴
		
		// 개수를 처음에 지정해 줄 수 있음
		IntStream intStream2 = new Random().ints(5);
		intStream2.forEach(System.out::println);
		
		// 범위를 지정해 줄 수 있음
		IntStream intStream3 = new Random().ints(5, 10); // 5<=x<10
		intStream3.limit(10).forEach(System.out::print);
		
		System.out.println();
		IntStream intStream4 = new Random().ints(10, 5, 10); // 5<=x<10
		intStream4.forEach(System.out::print);
	}
}
