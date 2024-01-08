final class Singletion {
	private static Singletion s = new Singletion();
	
	private Singletion() {
		
	}
	
	public static Singletion getInstance() {	// 인스턴스 생성하지 않고 호출하기 위해서 static을 사용
		if (s==null) {
			s = new Singletion();	// 클래스 내부에서는 인스턴스가 생성가능함
		}
		return s;
	}
}

public class SingletonTest {
	public static void main(String[] args) {
//		Singletion s = new Singleton();	// 에러. Singleton 클래스는 private 생성자이므로
		Singletion s = Singletion.getInstance();	// 인스턴스를 생성하지 않아도 호출할 수 있어야 됨
	}
}
