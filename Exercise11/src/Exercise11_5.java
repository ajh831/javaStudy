// 실행 결과
// 남궁성,1,2,90,70,80,240,80.0
// 안자바,1,5,60,100,80,240,80.0
// 이자바,1,4,70,90,70,230,76.7
// 홍길동,1,1,100,100,100,300,100.0

import java.util.*;

// Comparable인터페이스를 구현하도록 변경해서 이름(name)이 기본 정렬기준이 되도록 하시오
class Student implements Comparable{
	String name;
	int ban;
	int no;
	int kor, eng, math;

	Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	int getTotal() {
		return kor + eng + math;
	}

	float getAverage() {
		return (int) ((getTotal() / 3f) * 10 + 0.5) / 10f;
	}

	public String toString() {
		return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + getTotal() + "," + getAverage();
	}

	public int compareTo(Object o1) {	// Stiring클래스의 compareTo 메서드?
		if (o1 instanceof Student) {
			Student s1 = (Student) o1;
			
			return name.compareTo(s1.name);
		}
		return -1;
	}
}

public class Exercise11_5 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student("홍길동", 1, 1, 100, 100, 100));
		list.add(new Student("남궁성", 1, 2, 90, 70, 80));
		list.add(new Student("김자바", 1, 3, 80, 80, 90));
		list.add(new Student("이자바", 1, 4, 70, 90, 70));
		list.add(new Student("안자바", 1, 5, 60, 100, 80));
		list.add(new Student("박자바", 1, 6, 50, 100, 100));
		Collections.sort(list);
		Iterator it = list.iterator();
		while (it.hasNext())
			System.out.println(it.next());
	}
}
