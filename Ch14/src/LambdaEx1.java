@FunctionalInterface
interface MyFunction {	// 추상 메서드 집합
	void run();	// 접근제어자 public abstract 생략됨
}


public class LambdaEx1 {
	static void execute(MyFunction f) { // 매개변수의 타입이 MyFunction인 메서드
		f.run();
	}	
	
	static MyFunction getMyFunction() {	// 반환 타입이 MyFunction인 메서드
		MyFunction f = () -> System.out.println("f3.run()");
		return f;
		// return () -> System.out.println("f3.run()");과 동일
	}
	
	public static void main(String[] args) {
		// 람다식으로 MyFunction의 run() 구현
		MyFunction f1 = () -> System.out.println("f1.run()");
		
		MyFunction f2 = new MyFunction() {	// 익명 클래스(클래스를 정의하면서 동시에 객체를 생성)로 run()을 구현
			public void run() {	// public을 반드시 붙여야 함
				System.out.println("f2.run()");
			}
		};
		
		MyFunction f3 = getMyFunction();
		
		f1.run();
		f2.run();
		f3.run();
		
		execute(f1);
		execute( () -> System.out.println("run()"));
	}
}