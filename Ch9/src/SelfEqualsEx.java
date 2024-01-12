class PersonTest {
	long id; // int는 9자리까지만 됨
	
	// equals 오버라이딩을 하지 않는 경우
	PersonTest(long id) {
		this.id = id;
	}
}

public class SelfEqualsEx {
	public static void main(String[] args) {
		PersonTest p1 = new PersonTest(8011081111222L);
		PersonTest p2 = new PersonTest(8011081111222L);
		
		if (p1==p2) {	// 주소비교
			System.out.println("p1과 p2는 같은 사람입니다.");
		} else {
			System.out.println("p1과 p2는 다른 사람입니다.");
		}
		
		if (p1.equals(p2)) { // Object 클래스의 equals 사용
			System.out.println("p1과 p2는 같은 사람입니다.");
		} else {
			System.out.println("p1과 p2는 다른 사람입니다.");
		}
	}
}
