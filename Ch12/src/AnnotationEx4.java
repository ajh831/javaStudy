import java.util.*;

class MyArrayList<T> {
	T[] arr;

	@SafeVarargs // 가변인자 타입이 non-reifiable인 경우 발생하는 unchecked경고 억제
	@SuppressWarnings("varargs") // 컴파일러의 경고메시지가 나타나지 않게 억제
	MyArrayList(T... arr) { // T...에서 ...은 여러 개의 T 타입의 인자를 가변적으로 받을 수 있음을 나타냄
		this.arr = arr;
	}

	@SafeVarargs
	@SuppressWarnings("varargs") // 컴파일러의 경고메시지가 나타나지 않게 억제
//	@SuppressWarnings("unchecked")
	public static <T> MyArrayList<T> asList(T... a) {
		return new MyArrayList<>(a);
	}

	public String toString() {
		return Arrays.toString(arr);
	}
}

public class AnnotationEx4 {
//	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		MyArrayList<String> list = MyArrayList.asList("1","2","3");
		
		System.out.println(list);
	}
}
