class MyMath3 {
	int add(int a, int b) {
		System.out.print("int add(int a, int b) - ");
		return a + b;
	}

	long add(int a, long b) {
		System.out.print("long add(int a, long b) - ");
		return a + b;
	}

	long add(long a, int b) {
		System.out.print("long add(long a, int b) - ");
		return a + b;
	}

	long add(long a, long b) {
		System.out.print("long add(long a, long b) - ");
		return a + b;
	}
	
	int add(int[] a) {
		System.out.print("int add(int[] a) - ");
		int result = 0;
		for (int i = 0; i < a.length; i++) {
			result += a[i];
		}
		return result;
	}
}

public class OverloadingTest {
	public static void main(String[] args) {
		MyMath3 mm = new MyMath3();
		System.out.println("mm.add(3, 3) 결과 : " + mm.add(3,3));
//		int add(int a, int b) - mm.add(3, 3) 결과 : 6  이렇게 출력이 되는데 어떻게 add메서드가 println메서드보다 먼저 출력되는 이유는
//		println메서드가 결과를 출력하려면, add메서드의 결과가 먼저 계산이 되어야 하기 때문이다.
		System.out.println("mm.add(3L, 3) 결과 : " + mm.add(3L,3));
		System.out.println("mm.add(3, 3L) 결과 : " + mm.add(3,3L));
		System.out.println("mm.add(3L, 3L) 결과 : " + mm.add(3L,3L));
		
		int[] a = {100, 200, 300};
		System.out.println("mm.add(a) 결과 : " + mm.add(a));
	}
}
