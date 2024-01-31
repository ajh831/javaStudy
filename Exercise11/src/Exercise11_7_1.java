// 실행 결과
// 김자바,1,2,80,80,90,250,83.3
// 홍길동,1,3,100,100,100,300,100.0
// 이자바,2,1,70,90,70,230,76.7
// 안자바,2,2,60,100,80,240,80.0

import java.util.*;

// 내가 푼 것

// ArrayList에 담긴 Student인스턴스들이 반과 번호로 오름차순 정렬되도록
class Student11_7_1 {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;

	Student11_7_1(String name, int ban, int no, int kor, int eng, int math) {
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
} // class Student11_7_1

class BanNoAscending implements Comparator {
	public int compare(Object o1, Object o2) {
		if (o1 instanceof Student11_7_1 & o2 instanceof Student11_7_1) {
			Student11_7_1 s1 = (Student11_7_1) o1;
			Student11_7_1 s2 = (Student11_7_1) o2;

			Integer ban1 = s1.ban;
			Integer ban2 = s2.ban;

			// 양수 => 오름차순
			// 음수 => 내림차순

			// 반, 번호로 오름차순 할 것
			// 반이 같은경우 번호를 비교
			Integer no1 = s1.no;
			Integer no2 = s2.no;

			if (ban1 - ban2 == 0) {
				return no1.compareTo(no2);
			}
			return ban1.compareTo(ban2);
		}
		return -1;
	}
}

class Exercise11_7_1 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student11_7_1("이자바", 2, 1, 70, 90, 70));
		list.add(new Student11_7_1("홍길동", 1, 3, 100, 100, 100));
		list.add(new Student11_7_1("남궁성", 1, 1, 90, 70, 80));
		list.add(new Student11_7_1("김자바", 1, 2, 80, 80, 90));
		Collections.sort(list, new BanNoAscending());
		Iterator it = list.iterator();
		while (it.hasNext())
			System.out.println(it.next());
	}
}