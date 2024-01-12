class Person2 {
	long id; // int는 9자리까지만 됨

	public boolean equlas(Object obj) {
		if (obj instanceof Person2) {
			return id == ((Person2) obj).id;
		} else {
			return false;
		}
	}
}

public class EqualsEx2 {
	public static void main(String[] args) {
		Person p1 = new Person(8011081111222L);
		Person p2 = new Person(8011081111222L);
		
		if (p1==p2) {	// 주소비교
			System.out.println("p1과 p2는 같은 사람입니다.");
		} else {
			System.out.println("p1과 p2는 다른 사람입니다.");
		}
		
		if (p1.equals(p2)) { // 오버라이딩 된 equals 활용하여 형변환 후 비교
			System.out.println("p1과 p2는 같은 사람입니다.");
		} else {
			System.out.println("p1과 p2는 다른 사람입니다.");
		}
	}
}
