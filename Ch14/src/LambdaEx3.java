// 람다식도 익명 객체. 즉, 익명 클래스의 인스턴스
@FunctionalInterface
interface MyFunction3 {
	void myMethod();
}

class Outer {
	int val = 10; // Outer.this.val

	class Inner {
		int val = 20; // this.val
		
		// 내부 클래스의 메서드 내부에 사용되는 지역변수 -> final
		void method(int i) { // void method(final int i)
			int val = 30; // final int val = 30;
//			i = 10;	// 에러. 상수값은 변경할 수 없음

			MyFunction2 f = () -> {
				System.out.println("             i : " + i);
				System.out.println("           val : " + val);
				System.out.println("      this.val : " + ++this.val);
				System.out.println("Outer.this.val : " + ++Outer.this.val);
			};

			f.myMethod();
		}
	}
}

public class LambdaEx3 {
	public static void main(String[] args) {
		Outer outer = new Outer();
		Outer.Inner innter = outer.new Inner();
		innter.method(100);
	}
}