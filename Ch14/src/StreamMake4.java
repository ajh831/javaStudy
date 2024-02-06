import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMake4 {
	public static void main(String[] args) {
		//                    단항연산자
		// iterate(T seed, UnaryOperator f)
		Stream<Integer> intStream = Stream.iterate(0, n -> n + 2);
		intStream.limit(10).forEach(System.out::println);
		
		// generagte(Supplier s) : 주기만 하는것. 입력X, 출력O
		Stream<Integer> oneStream = Stream.generate(()->1);
		oneStream
		.limit(10)
		.forEach(System.out::print);
	}
}
  