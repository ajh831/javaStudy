import java.io.File;
import java.util.stream.Stream;

public class StreamExPeek1 {
	public static void main(String[] args) {
		Stream<File> fileStream = Stream.of(
				new File("Ex1.java"),
				new File("Ex1"),
				new File("Ex1.bak"),
				new File("Ex2.java"),
				new File("Ex1.txt")
				);
		
//		Stream<String> filenameStream = fileStream.map(File::getName);
//		filenameStream.filter(s -> s.indexOf('.')!=-1)
//			.peek(s -> System.out.printf("filename=%s%n", s))	// 파일명을 출력
//			.map(s -> s.substring(s.indexOf('.')+1))	// 확장자만 추출
//			.peek(s -> System.out.printf("extension=%s%n", s))	// 확장자 출력
//			.forEach(System.out::println);
		
		Stream<String> filenameStream2 = fileStream.map(File::getName);
		filenameStream2.filter(s -> s.indexOf('.')!=-1)
			.map(s -> s.substring(0, s.indexOf('.'))) // 파일명만 추출
			.distinct()
//			.peek(s -> System.out.printf("filename=%s%n", s))	// 파일명을 출력
			.forEach(System.out::println);
	}
}
