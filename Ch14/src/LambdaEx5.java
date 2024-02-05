import java.util.function.*;
import java.util.*;

public class LambdaEx5 {
	public static void main(String[] args) {
		// 공급자 : 입력-X 출력-1~100까지 랜덤 숫자
		Supplier<Integer> s = () -> (int) (Math.random() * 100) + 1;
		// 소비자 : 입력-i 출력-X 프린트문만 출력
		Consumer<Integer> c = i -> System.out.print(i + ", ");
		// 조건식 : 입력-i 출력-2의 배수
		Predicate<Integer> p = i -> i%2 == 0;
		// 함수 : 입력-i 출력-i의 일의 자리 제거
		Function<Integer, Integer> f = i -> i/10*10; // i의 일의 자리를 없앰
		
		List<Integer> list = new ArrayList<>();
		makeRandomList(s, list);
		System.out.println(list);
		printEvenNum(p, c, list);
		List<Integer> newList = doSomething(f, list);
		System.out.println(newList);
		
	}
	
	// List<T>타입의 newList 참조변수에 ArrayList객체를 생성 후 주소값 저장 
	static <T> List<T> doSomething(Function<T, T> f, List<T> list) {
		List<T> newList = new ArrayList<T>(list.size());
		
		for(T i : list) {	// 향상된 for문
			newList.add(f.apply(i));
		}
		
		return newList;
	}
	
	// 조건식, 소비자, List를 매개변수로 받음
	static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
		System.out.print("[");
		// list의 값들을 향상된 for문 이용해서 i에 저장하고
		for(T i : list) {
			// 짝수인지 검사(true/false)
			if(p.test(i)) {
				// i값을 받아서 System.print.out(i+",") 화면에 출력
				c.accept(i);
			}
		}
		System.out.println("]");
	}
	
	static <T> void makeRandomList (Predicate<T> p, Supplier<T> s, List<T> list) {
		for(int i=0; i<10; i++) {
			list.add(s.get());
		}
	}
	
	static <T> void makeRandomList(Supplier<T> s, List<T> list) {
		for(int i=0; i<10; i++) {
			list.add(s.get());
		}
	}

}



