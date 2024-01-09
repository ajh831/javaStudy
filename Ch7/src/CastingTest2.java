
public class CastingTest2 {
	public static void main(String[] args) {
		Car car = new Car();
//		Car car = new FireEngine();
		Car car2 = null;
		FireEngine fe = null;	// 실제 인스턴스가 무엇인지가 중요
		
		car.drive();
		fe = (FireEngine)car;	// 형변환 실행 에러. (컴파일은 됨)
		fe.water();	// 컴파일 오케이(리모컨에 water가 있으니까) 하지만 실제 Car에는 water가 없음
//					 실제 가르키는 객체가 뭔지가 중요함
		fe.drive();
		car2 = fe;
		car2.drive();
		
//		fe = (FireEngine)car; 문장이 에러나는 이유?
//		에러코드
//		Exception in thread "main" java.lang.ClassCastException:
//		class Car cannot be cast to class FireEngine (Car and FireEngine are in unnamed module of loader 'app')
//		at CastingTest2.main(CastingTest2.java:9)
//		오류나지 않으려면 Car car = new Car(); -> Car car = new FireEngine();으로 변경하면 실행가능
		
//		조상 -> 자손으로 형변환을 했기 때문에 문제가 없어 보이지만
//		참조변수 car이 참조하고 있는 인스턴스가 Car타입의 인스턴스이기 때문에 문제가 발생한다.
//		* 조상타입의 인스턴스를 자손타입의 참조변수로 참조하는 것은 허용되지 않는다.
		
//		서로 상속관계에 있는 타입간의 형변환은 양방향으로 자유롭게 수행될 수 있으나
//		참조변수가 가리키는 인스턴스의 자손타입으로 형변환 XXX
//		참조변수가 가리키는 인스턴스의 타입이 무엇인지 확인 하는 것이 중요!!!
	}
}
