import java.util.*;

public class IteratorEx1_5 {
	public static void main(String[] args) {
		HashSet list = new HashSet();
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
		
//		for (int i = 0; i < list.size(); i++) {
//			Object obj = list.get(i);	// HashSet에 get 메서드가 존재하지 않으므로 실행 X
//			System.out.println(obj);
//		}
	}
}
