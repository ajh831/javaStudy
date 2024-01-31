// 실행결과
// 이자바,1,4,70,90,70,230,76.7
// 남궁성,1,2,90,70,80,240,80.0
// 김자바,1,3,80,80,90,250,83.3
// 홍길동,1,1,100,100,100,300,100.0
// [60~69] :0
// [70~79] :1
// [80~89] :2
// [90~100] :1

import java.util.*;

// TreeSet이 학생들의 평균을 기준으로 정렬하도록 compare(Object o1, Object o2)와 평균점수의 점위를 주면
// 해당 범위에 속한 학생의 수를 반환하는 getGroupCount()를 환성
class Student6_2 implements Comparable {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;

	Student6_2(String name, int ban, int no, int kor, int eng, int math) {
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

	public int compareTo(Object o) {
		if (o instanceof Student6_2) {
			Student6_2 tmp = (Student6_2) o;
			return name.compareTo(tmp.name);
		} else {
			return -1;
		}
	}
} // class Student6_2

public class Exercise11_6_2 {
	// 평균점수 범위에 속하는 학생 수 반환
	static int getGroupCount(TreeSet tset, int from, int to) {
		Student6_2 s1 = new Student6_2("", 0, 0,from, from, from);
		Student6_2 s2 = new Student6_2("", 0, 0,to, to, to);

		return tset.subSet(s1, s2).size();	//  from, to 사이 값 반환
	}

	public static void main(String[] args) {
		TreeSet set = new TreeSet(new Comparator() {
			public int compare(Object o1, Object o2) {
				if (o1 instanceof Student6_2 & o1 instanceof Student6_2) {
					Student6_2 s1 = (Student6_2) o1;
					Student6_2 s2 = (Student6_2) o2;
					return (int) (s1.getAverage() - s2.getAverage());
				}
				return -1;
			}
		});
		set.add(new Student6_2("홍길동", 1, 1, 100, 100, 100));
		set.add(new Student6_2("남궁성", 1, 2, 90, 70, 80));
		set.add(new Student6_2("김자바", 1, 3, 80, 80, 90));
		set.add(new Student6_2("이자바", 1, 4, 70, 90, 70));
		set.add(new Student6_2("안자바", 1, 5, 60, 100, 80));
		Iterator it = set.iterator();
		while (it.hasNext())
			System.out.println(it.next());
		System.out.println("[60~69] :" + getGroupCount(set, 60, 70));
		System.out.println("[70~79] :" + getGroupCount(set, 70, 80));
		System.out.println("[80~89] :" + getGroupCount(set, 80, 90));
		System.out.println("[90~100] :" + getGroupCount(set, 90, 101));
	}
}