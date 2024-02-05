import java.util.*;

class Student9 implements Comparable {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;

	int total;
	int schoolRank; // 전교등수
	int classRank; // 반등수

	Student9(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;

		total = kor + eng + math;
	}

	int getTotal() {
		return total;
	}

	float getAverage() {
		return (int) ((getTotal() / 3f) * 10 + 0.5) / 10f;
	}

	public int compareTo(Object o) {
		if (o instanceof Student9) {
			Student9 tmp = (Student9) o;
			return tmp.total - this.total;
		}
		return -1;
	}

	public String toString() {
		return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + getTotal() + "," + getAverage()
				+ "," + schoolRank + "," + classRank// 새로추가
		;
	}
}

class ClassTotalComparator implements Comparator {

	public int compare(Object o1, Object o2) {
		if (o1 instanceof Student9 & o2 instanceof Student9) {
			Student9 s1 = (Student9) o1;
			Student9 s2 = (Student9) o2;

			int comp = s1.ban - s2.ban; // 반별로 오름차순 정리

			if (comp == 0) {
				comp =  s2.total - s1.total; // 내림차순
			}
			return comp; // 반끼리는 오름차순
		}
		return -1;
	}
}

public class Exercise11_9 {
	public static void calculateClassRank(List list) {
		// 먼저 반별 총점기준 내림차순으로 정렬
		Collections.sort(list, new ClassTotalComparator());

		int prevBan = -1;
		int prevRank = -1;
		int prevTotal = -1;
		int length = list.size();

		int rank = 0;
		for (int i = 0; i < length; i++) {
			Student9 student = (Student9) list.get(i);
			if (student.ban != prevBan) {
				prevRank = -1;
				prevTotal = -1;
				rank = 0;
			}

			if (student.total == prevTotal) {
				student.classRank = prevRank;
			} else {
				student.classRank = rank + 1;
			}
			rank++;
			prevBan = student.ban;
			prevTotal = student.total;
			prevRank = student.classRank;
		}

	}

	public static void calculateSchoolRank(List list) {
		Collections.sort(list); // 먼저 list를 총점기준 내림차순으로 정렬

		int prevRank = -1;
		int prevTotal = -1;
		int length = list.size();

		for (int i = 0; i < length; i++) {
			// 1.
			Student9 student = (Student9) list.get(i);
			if (student.total == prevTotal) {
				student.schoolRank = prevRank;
			} else {
				student.schoolRank = i + 1;
			}
			prevTotal = student.total;
			prevRank = student.schoolRank;
		}

	}

	public static void main(String[] areg) {
		ArrayList list = new ArrayList();
		list.add(new Student9("이자바", 2, 1, 70, 90, 70));
		list.add(new Student9("안자바", 2, 2, 60, 100, 80));
		list.add(new Student9("홍길동", 1, 3, 100, 100, 100));
		list.add(new Student9("남궁성", 1, 1, 90, 70, 80));
		list.add(new Student9("김자바", 1, 2, 80, 80, 90));

		calculateSchoolRank(list);
		calculateClassRank(list);

		Iterator it = list.iterator();

		while (it.hasNext())
			System.out.println(it.next());
	}
}