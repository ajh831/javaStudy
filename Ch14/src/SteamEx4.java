import java.util.Arrays;
import java.util.stream.Stream;

public class SteamEx4 {
	public static void main(String[] args) {
		Stream<String[]> strArrStrm = Stream.of(
				new String[] {"abc", "def", "jkl"},
				new String[] {"ABC", "GHI", "JKL"}
				);
		
		Stream<String> strStrm = strArrStrm.flatMap(Arrays::stream);
		
		strStrm.map(String::toLowerCase) // 스트림의 요소를 모두 소문자로 변경
			.distinct()
			.sorted()
			.forEach(System.out::println);
		System.out.println();
		
		String[] lineArr = {
				"Believe   or not It is true",
				"Do or do not There is no try",
		};
		
		Stream<String> lineStream = Arrays.stream(lineArr);
		lineStream.flatMap(line -> Stream.of(line.split(" +"))) // 정규식 사용 " +" : 하나 이상의 공백
			.map(String::toLowerCase)
			.distinct()
			.sorted()
			.forEach(System.out::println);
		System.out.println();
		
		Stream<String> strStrm1 = Stream.of("AAA", "ABC", "bBb", "Dd");
		Stream<String> strStrm2 = Stream.of("bbb", "aaa", "ccc", "dd");
		
		Stream<Stream<String>> strStrmStrm = Stream.of(strStrm1, strStrm2);	// 스트림의 스트림을 하나의 요소로 합침
		Stream<String> strStream = strStrmStrm
									.map(s -> s.toArray(String[]::new))	// Stream<Stream<String>> -> Stream<String[]>
									.flatMap(Arrays::stream);			// Stream<String[]> -> Stream<String>
		strStream.map(String::toLowerCase)
			.distinct()
			.forEach(System.out::println);
	}
}
