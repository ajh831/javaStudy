import java.util.*;

public class Ex12_2_2 {
	public static void main(String[] args) {
		HashMap<String, Student2> map = new HashMap<>();	// JDK1.7부터 생성자에 타입지정 생략가능
		map.put("자바왕", new Student2("자바왕", 1, 1, 100, 100, 100));
		
		
//		Student s = (Student)map.get("자바왕");	// 형변환 생략 가능
		Student2 s = map.get("자바왕");
		
		System.out.println(map);
		System.out.println(s.name);
	}
}

class Student2 {
	String name = "";
	int ban;	// 반
	int no;	// 번호
	int kor;
	int eng;
	int math;
	
	Student2(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
}
