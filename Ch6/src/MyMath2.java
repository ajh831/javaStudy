class MyMath2 {
	long a, b; // 인스턴스변수

//	인스턴스변수 a, b만을 이용해서 작업하므로 매개변수가 필요없다.
	long add() {
		return a + b;
	}

	long subtract() {
		return a - b;
	}

	long multiply() {
		return a * b;
	}

	double divide() {
		return a / b;
	}

//	인스턴스변수와 관계없이 매개변수만으로 작업이 가능하다.
	static long add(long a, long b) {
		return a + b;
	}

	static long subtract(long a, long b) {
		return a - b;
	}

	static long multiply(long a, long b) {
		return a * b;
	}

	static double divide(double a, double b) {
		return a / b;
	}
}

class MyMathTest2 {
	public static void main(String[] args) {
//		클래스메서드 호출. 인스턴스 생성 없이 호출 가능
		System.out.println("인스턴스 생성 X");
		System.out.println(MyMath2.add(200L, 100L));
		System.out.println(MyMath2.subtract(200L, 100L));
		System.out.println(MyMath2.multiply(200L, 100L));
		System.out.println(MyMath2.divide(200.0, 100.0));

		System.out.println();
		System.out.println("인스턴스 생성 O : MyMath2 mm = new MyMath2()");
		MyMath2 mm = new MyMath2(); // 인스턴스 생성
		mm.a = 200L;
		mm.b = 100L;
		System.out.println(mm.add());
		System.out.println(mm.subtract());
		System.out.println(mm.multiply());
		System.out.println(mm.divide());
	}
}