import java.util.*;

public class TreesetEx1Test4 {
	public static void main(String[] args) {
		TreeSet set = new TreeSet(); // 범위 검색, 정렬.
									// 추가적으로 정렬 필요없음

		set.add(new Integer(1));
		set.add(new Integer(5));
		set.add(new Integer(4));
		set.add(new Integer(2));
		set.add(new Integer(3));
		
		
		NavigableSet descedning = set.descendingSet();
		SortedSet head = set.headSet(5);

		System.out.println(set);
		System.out.println(head);
	}
}
