
public class EqualsEx1 {
	public static void main(String[] args) {
		Value1 v1 = new Value1(10);
		Value1 v2 = new Value1(10);
		
		if (v1.equals(v2)) {	// 주소 비교
			System.out.println("v1과 v2는 같습니다.");
		} else {
			System.out.println("v1과 v2는 다릅니다.");
		}
		
		v2 = v1;	// v2애 v1 주소값 저장
		
		if (v1.equals(v2)) {	// 주소 비교
			System.out.println("v1과 v2는 같습니다.");
		} else {
			System.out.println("v1과 v2는 다릅니다.");
		}

	}
}

class Value1 {
	int value;
	
	Value1(int value) {
		this.value = value;
	}
}
