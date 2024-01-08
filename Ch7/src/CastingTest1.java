
public class CastingTest1 {
	public static void main(String[] args) {
		Car car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;
		
		fe.water();
		car = fe;	// 자손타입 -> 조상타입 : 형변환 생략O
					// car = (Car) fe; 형변환 생략된 형태
//		car.water();	// 에러. Car타입의 참조변수이므로 FireEngine의 water()를 호출할 수 없음
		fe2 = (FireEngine)car;	// 자손타입 <- 조상타입 : 형변환 생략X
		fe2.water();
	}
}

class Car {	// 부모
	String color;
	int door;
	
	void drive() {	// 운전하는 기능
		System.out.println("drive, Brrrr~");
	}
	
	void stop() {	// 멈추는 기능
		System.out.println("stop!!!");
	}
}

// 소방차는 자동차이다. -> 상속관계
class FireEngine extends Car {	// 자식
	void water() {
		System.out.println("water!!!");
	}
}