import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMake2 {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		Stream<Integer> intStream = list.stream(); // list를 Stream으로 변환
		intStream.forEach(System.out::print);	// forEach : 최종연산(Stream을 닫아줌)
//		intStream.forEach(System.out::print); // 에러. Stream도 Iterator처럼 일회용
		
		System.out.println();
		
		// Stream은 1회용.
		// Stream에 대해 최종연산을 수행하면 Stream이 닫힘
		intStream = list.stream();
		intStream.forEach(System.out::print);
		
		System.out.println();
		
		Stream<String> strStream = Stream.of("a", "b", "c"); // 가변인자
		strStream.forEach(System.out::print);
		
		System.out.println();
		
		String[] strArr = new String[] {"a", "b", "c", "d"};
		Stream<String> strStream2 = Stream.of(strArr);
		strStream2.forEach(System.out::print);

		System.out.println();
		
		Stream<String> strStream3 = Arrays.stream(strArr);
		strStream3.forEach(System.out::print);
		
		System.out.println();
		
		int[] intArr = {1,2,3,4,5};
		IntStream intStream2 = Arrays.stream(intArr);
//		intStream2.forEach(System.out::print); // 최종연산
//		System.out.println("count=" + intStream2.count()); // 최종연산
//		System.out.println("sum=" + intStream2.sum()); // 최종연산
		System.out.println("sum=" + intStream2.average());
		// 숫자 Stream을 다룰 때 기본형Stream을 사용하면 속도 향상되고
		// 추가적인 메서드(sum, average)를 사용할 수 있음
		System.out.println();

		Integer[] intArr2 = {1,2,3,4,5};
		Stream<Integer> intStream3 = Arrays.stream(intArr2);
//		intStream3.forEach(System.out::print);
		System.out.println("count=" + intStream3.count());
//		System.out.println("sum=" + intStream3.sum()); // Integer객체의 Stream은 객체 스트림이어서 count만 있고 sum은 없음.
		// 정확히는 Stream<T>는 숫자외에도 여러 타입의 스트림이 가능해야하므로
		// 숫자 스트림에만 사용할 수 있는 sum(), average()를 넣지 않음 것
	}
}
