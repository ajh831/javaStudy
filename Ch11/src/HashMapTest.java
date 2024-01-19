import java.util.*;

public class HashMapTest {

//		[자바 학원]
//		1. 동명이인, 생년월일이 같을 수 있음 -> 주민번호를 key로 설정
//		2. 입력받는 값은 이름, 나이, 주민번호
//		3. 입력받은 주민번호로 성별을 나누거 그룹

	static HashMap students = new HashMap();

	public static void main(String[] args) {

	}

	// 모든 학생 정보
	static void student(String name, String phone, String jumin) {
		gender(jumin);
		HashMap group = (HashMap) students.get(jumin);
		group.put(name, phone);
	}

	// 그룹

	// 학생 성별 정보 그룹
	static void genderGroup(String jumin) {
		if (!(students.containsKey(jumin))) {
			
			students.put(jumin, new HashMap());
		}
	}
	
	// 성별 함수
	static void gender(String jumin) {
		// 000000-1111111;
		String[] arr = jumin.split("-");		
		String group = arr[1].substring(0, 1);
		// 1, 3 -> 남자
		// 2, 4 -> 여자
		if (Integer.parseInt(group)%2 == 0) {
			group = "여자";
		} else {
			group = "남자";
		}
	}
}
