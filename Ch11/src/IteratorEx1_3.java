import java.util.*;

public class IteratorEx1_3 {
	public static void main(String[] args) {
		Collection list = new ArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");

		Iterator it = list.iterator();

		while (it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
		
		System.out.println("\niterator 다시 불러옴");
		// iterator는 1회용이므로 다 쓰고나면 다시 얻어와야 사용가능함
		it = list.iterator();	// 새로운 iterator 객체를 얻음
		
		while (it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
	}
}
