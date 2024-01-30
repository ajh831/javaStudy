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
class Student implements Comparable {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;

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

	public int compareTo(Object o) {
		if (o instanceof Student) {
			Student tmp = (Student) o;
			return name.compareTo(tmp.name);
		} else {
			return -1;
		}
	}
} // class Student

public class Exercise11_6 {
	// 평균점수 범위에 속하는 학생 수 반환
	static int getGroupCount(TreeSet tset, int from, int to) {
		Iterator it = tset.iterator();
		int cnt = 0;

		while (it.hasNext()) {
			Student st = (Student) it.next();
			int avg = (int) ((st.eng + st.kor + st.math) / (double) 3);

			if (from > to) {
				int tmp = from;
				to = from;
				from = tmp;
			}

			if (avg >= from && avg < to) {
				cnt++;
			}
		}

		return cnt;
	}

	public static void main(String[] args) {
		TreeSet set = new TreeSet(new Comparator() {
			// 평균 기준 정렬
			public int compare(Object o1, Object o2) {
				if (o1 instanceof Student & o1 instanceof Student) {
					Student s1 = (Student) o1;
					Student s2 = (Student) o2;

					Integer avg1 = (int) ((s1.eng + s1.kor + s1.math) / (double) 3);
					Integer avg2 = (int) ((s2.eng + s2.kor + s2.math) / (double) 3);
					Integer in = new Integer(10);
					return avg1.compareTo(avg2);
				}
				return -1;
			}
		});
		set.add(new Student("홍길동", 1, 1, 100, 100, 100));
		set.add(new Student("남궁성", 1, 2, 90, 70, 80));
		set.add(new Student("김자바", 1, 3, 80, 80, 90));
		set.add(new Student("이자바", 1, 4, 70, 90, 70));
		set.add(new Student("안자바", 1, 5, 60, 100, 80));
		Iterator it = set.iterator();
		while (it.hasNext())
			System.out.println(it.next());
		System.out.println("[60~69] :" + getGroupCount(set, 60, 70));
		System.out.println("[70~79] :" + getGroupCount(set, 70, 80));
		System.out.println("[80~89] :" + getGroupCount(set, 80, 90));
		System.out.println("[90~100] :" + getGroupCount(set, 90, 101));
	}
}