@FunctionalInterface
interface MyFunction2 {
	void myMethod();
}

public class LambdaEx2 {
	public static void main(String[] args) {
		MyFunction2 f = () -> {};
		Object obj = (MyFunction2) (() -> {});	// Object타입으로 형변환 생략
		String str = ((Object) (MyFunction2) (() -> {})).toString();
		
		System.out.println(f);
		System.out.println(obj);
		System.out.println(str);
		
//		System.out.println(() -> {}); // 에러. 람다식은 Object타입으로 형변환 불가능
		System.out.println((MyFunction2) (() -> {}));
//		System.out.println((MyFunction2) (() -> {}).toString()); // 에러. The target type of this expression must be a functional interface
//		MyFunction2는 인터페이스(추상 메서드 집합)이고 toString()이 run()과 호환되지 않음
//		람다식은 함수형 인터페이스의 메서드에 대한 구현으로서만 유효함
		System.out.println(((Object)(MyFunction2) (() -> {})).toString());
	}
}

// 실행 결과
//	LambdaEx2$$Lambda$23/0x0000000800c060f8@77f03bb1
//	LambdaEx2$$Lambda$24/0x0000000800c06310@326de728
//	LambdaEx2$$Lambda$25/0x0000000800c06528@21a06946
//	LambdaEx2$$Lambda$26/0x0000000800c06740@7a92922
//	LambdaEx2$$Lambda$27/0x0000000800c06958@2cfb4a64
//	LambdaEx2$$Lambda$28/0x0000000800c06b70@4b6995df

// 익명객체 : 외부클래스이름$번호
// 람다식 : 외부클래스이름$$Lambda$번호