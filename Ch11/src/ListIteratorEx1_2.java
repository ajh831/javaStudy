import java.util.*;

public class ListIteratorEx1_2 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		
		Iterator it = list.iterator();
		
		while (it.hasNext()) {
			System.out.print(it.next());	// 순방향으로 진행하면서 읽음
		}
		System.out.println();
		
//		while (it.hasPrevious()) {	// iterator에는 양방향 조회기능이 없음
//			System.out.print(it.previous());
//		}
		System.out.println();
	}
}
