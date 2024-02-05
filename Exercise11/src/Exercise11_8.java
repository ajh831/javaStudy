import java.util.*;

class Student8 implements Comparable {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;

	int total; // 총점
	int schoolRank; // 전교등수

	Student8(String name, int ban, int no, int kor, int eng, int math) {
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
		if (o instanceof Student8) {
			int oTotal = ((Student8) o).total;
			return (oTotal - this.total);
		}
		return -1;
	}

	public String toString() {
		return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + getTotal() + "," + getAverage()
				+ "," + schoolRank // 새로추가
		;
	}
}

public class Exercise11_8 {
	public static void calculateSchoolRandk(List list) {
		Collections.sort(list); // 먼저 list를 총점기준 내림차순으로 정렬

		int prevRank = -1; // 이전 전교등수
		int prevTotal = -1; // 이전 총점
		int length = list.size();

		for (int i = 0; i < length; i++) {
			// 1.
			Student8 student = (Student8) list.get(i);
			// 총점이 이전총점과 같으면
			if (student.total == prevTotal) {
				// 이전 등수를 등수로 함
				student.schoolRank = prevRank;
			} else { // 총점이 서로 다르면
				// 등수의 값을 계산해서 저장
				// 이전에 동점자 였다면, 그 다음 등수는 동점자 수를 고려 -> 동점자 1, 1, 2등아니고 1, 1, 3 이런식
				student.schoolRank = i + 1; // 총점다르니까 하나씩 뒤로 밀리는 것임
			}
			// 현재 총점과 등수를 이전 총점과 이전 등수에 저장
			prevTotal = student.total;
			prevRank = student.schoolRank;
		}
	}

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student8("이자바", 2, 1, 70, 90, 70));
		list.add(new Student8("안자바", 2, 2, 60, 100, 80));
		list.add(new Student8("홍길동", 1, 3, 100, 100, 100));
		list.add(new Student8("남궁성", 1, 1, 90, 70, 80));
		list.add(new Student8("김자바", 1, 2, 80, 80, 90));

		calculateSchoolRandk(list);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
