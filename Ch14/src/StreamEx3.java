import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx3 {
	public static void main(String[] args) {
		Student_StreamEx3[] studentArr = {
				new Student_StreamEx3("이자바", 3, 300),
				new Student_StreamEx3("김자바", 1, 200),
				new Student_StreamEx3("안자바", 2, 100),
				new Student_StreamEx3("박자바", 2, 150),
				new Student_StreamEx3("소자바", 1, 200),
				new Student_StreamEx3("나자바", 3, 290),
				new Student_StreamEx3("감자바", 3, 180)
		};
		
//		Stream<Student_StreamEx3> stuStream = Arrays.stream(studentArr);
		Stream<Student_StreamEx3> stuStream = Arrays.stream(studentArr, 0, 3);
		
		stuStream
			.sorted(Comparator.comparing(Student_StreamEx3::getBan)
			.thenComparing(Comparator.naturalOrder()))
			.forEach(System.out::println);
		
//		stuStream = Arrays.stream(studentArr);
		stuStream = Arrays.stream(studentArr, 0, 3);
		IntStream stuScoreStream = stuStream.mapToInt(Student_StreamEx3::getTotalScore);
		
		IntSummaryStatistics stat = stuScoreStream.summaryStatistics();
		System.out.println("count = " + stat.getCount());
		System.out.println("sum = " + stat.getSum());
		System.out.printf("average = %.2f%n", stat.getAverage());
		System.out.println("min = " + stat.getMin());
		System.out.println("max = " + stat.getMax());
		
	}
}

class Student_StreamEx3 implements Comparable<Student_StreamEx3> {
	String name;
	int ban;
	int totalScore;
	Student_StreamEx3(String name, int ban, int totalScore) {
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
	public int compareTo(Student_StreamEx3 s) {
		return s.totalScore - this.totalScore;
	}
	
}