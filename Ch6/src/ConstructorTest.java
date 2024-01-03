class Data3 {
	int value;
}

class Data4 {
	int value;

	Data4(int x) { // 매개변수가 있는 생성자
		value = x;
	}
}

public class ConstructorTest {
	public static void main(String[] args) {
		Data3 d1 = new Data3();
//		Data4 d2 = new Data4();	// compile error qkftod
	}
}
