import java.util.function.*;

public class Ex14_2 {
	public static void main(String[] args) {
	// Suppliers는 입력X, 출력O
//	Supplier<MyClass> s = () -> new MyClass();
	Supplier<MyClass> s = MyClass::new;
	Function<Integer, MyClass2> f = MyClass2::new;
//	System.out.println(s.get());
	MyClass mc1 = s.get();
	System.out.println(mc1);
	System.out.println(s.get());	// 또 다른 객체 생성

	MyClass2 mc2 = f.apply(100);
	System.out.println(mc2.iv);
	
	System.out.println(f.apply(200).iv);
	
	// 배열을 생성하는 경우
	// input에 int값이 들어가 줘야됨(배열 길이)
	// output으로는 배열이 나옴
	// 따라서 배열을 생성하려면 Function을 사용
	
	// Function f = (i) -> new int[i];
	Function<Integer, int[]> f2 = (i) -> new int[i];
	int[] arr = f2.apply(100);
	System.out.println("arr.length = " + arr.length);

	Function<Integer, int[]> f3 = int[]::new; // 메서드 참조
	int[] arr2 = f3.apply(100);
	System.out.println("arr2.length = " + arr2.length);
	} 
}

class MyClass {
}

class MyClass2 {
	int iv;
	
	MyClass2(int iv) {
		this.iv = iv;
	}
}
