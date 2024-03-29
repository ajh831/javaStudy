import java.util.*;

public class Ex12_2 {
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student("자바왕", 1, 1));
		list.add(new Student("자바짱", 1, 2));
		list.add(new Student("홍길동", 2, 1));

		Iterator<Student> it = list.iterator();
		while (it.hasNext()) {
		//  Student s = (Student)it.next(); // 지네릭스를 사용하지 않았을 때는 형변환이 필요함
//			Student s = it.next();
//			System.out.println(s.name);
			System.out.println(it.next().name);
		}
	} // main
}

class Student {
	String name = "";
	int ban;
	int no;

	Student(String name, int ban, int no) {
		this.name = name;
		this.ban = ban;
		this.no = no;
	}
}