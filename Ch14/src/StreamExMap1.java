import java.io.File;
import java.util.stream.Stream;

public class StreamExMap1 {
	public static void main(String[] args) {
		Stream<File> fileStream = Stream.of(
				new File("Ex1.java"),
				new File("Ex1"),
				new File("Ex1.bak"),
				new File("Ex2.java"),
				new File("Ex1.txt")
				);
		
//		Stream<String> filenameStream = fileStream.map(File::getName);
//		filenameStream.forEach(System.out::println);
		
		Stream<String> fileName = fileStream.map(File::getName);
		fileName.filter(s -> s.indexOf('.')!=-1) // 확장자 없는 것 제외
				.map(s -> s.substring(s.indexOf('.')+1)) // Stream<String> -> Stream<String>
				.map(String::toUpperCase) // 모두 대문자 변환
				.distinct() // 중복 제거
				.forEach(System.out::println)
				;
		
		
	}
}
