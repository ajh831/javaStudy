import java.util.*;
import java.util.stream.*;

public class StreamEx1 {
	public static void main(String[] args) {
		/* 배열 추가
		*	Stream<T> Stream.of(T... value) // 가변인자
		*	Stream<T> Stream.of(T[])
		*	Stream<T> Arrays.stream(T[])
		*	Stream<T> Arrays.stream(T[] array, int startInclusive, int endExclusive)
		*/
		Stream<Student_StreamEx1> studentStream = Stream.of(
				new Student_StreamEx1("이자바", 3, 300),
				new Student_StreamEx1("김자바", 1, 200),
				new Student_StreamEx1("안자바", 2, 100),
				new Student_StreamEx1("박자바", 2, 150),
				new Student_StreamEx1("소자바", 1, 200),
				new Student_StreamEx1("나자바", 3, 290),
				new Student_StreamEx1("감자바", 3, 180)
				);
		
		// 메서드 참조
//		studentStream.sorted(Comparator.comparing(Student_StreamEx1::getBan)	// 반별 정렬
//			.thenComparing(Comparator.naturalOrder()))							// 기본 정렬
//			.forEach(System.out::println);
		
		// 람다식
		studentStream.sorted(Comparator.comparing((Student_StreamEx1 s) -> s.getBan())
			.thenComparing(Comparator.naturalOrder()))
			.forEach((s) -> System.out.println(s));
	}
}

class Student_StreamEx1 implements Comparable<Student_StreamEx1> {
	String name;
	int ban;
	int totalScore;
	Student_StreamEx1(String name, int ban, int totalScore) {
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
	}
	
	public String toString() {
		return String.format("[%s, %d, %d]", name, ban, totalScore);
	}
	
	String getName() {
		return name;
	}
	
	int getBan() {
		return ban;
	}
	
	int getTotalScore() {
		return totalScore;
	}
	
	// 총점 내림차순을 기본 정렬로 한다.
	public int compareTo(Student_StreamEx1 s) {
		return s.totalScore - this.totalScore;
	}
	
}
