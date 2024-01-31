// 실행 결과
// 김자바,1,2,80,80,90,250,83.3
// 홍길동,1,3,100,100,100,300,100.0
// 이자바,2,1,70,90,70,230,76.7
// 안자바,2,2,60,100,80,240,80.0

import java.util.*;

// 해설

// ArrayList에 담긴 Student인스턴스들이 반과 번호로 오름차순 정렬되도록
class Student11_7_2 {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;

	Student11_7_2(String name, int ban, int no, int kor, int eng, int math) {
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
} // class Student11_7_2

class BanNoAscending2 implements Comparator {
	public int compare(Object o1, Object o2) {
		if (o1 instanceof Student11_7_2 & o2 instanceof Student11_7_2) {
			Student11_7_2 s1 = (Student11_7_2) o1;
			Student11_7_2 s2 = (Student11_7_2) o2;
			
			int result = s1.ban - s2.ban;
			
			if (result == 0) {	// 반이 같으면, 번호를 비교
				return s1.no - s2.no;
			}
			return result;
		}
		return -1;
	}
}

class Exercise11_7_2 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student11_7_2("이자바", 2, 1, 70, 90, 70));
		list.add(new Student11_7_2("홍길동", 1, 3, 100, 100, 100));
		list.add(new Student11_7_2("남궁성", 1, 1, 90, 70, 80));
		list.add(new Student11_7_2("김자바", 1, 2, 80, 80, 90));
		Collections.sort(list, new BanNoAscending2());
		Iterator it = list.iterator();
		while (it.hasNext())
			System.out.println(it.next());
	}
}