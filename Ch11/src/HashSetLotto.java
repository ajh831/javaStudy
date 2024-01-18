import java.util.*;

public class HashSetLotto {
	public static void main(String[] args) {
		Set set = new HashSet();
		
		for (int i = 0; i < 6; i++) {
			int num = (int) (Math.random() * 45) + 1;
			set.add(new Integer(num));
		}
		
		List list = new LinkedList(set);	// LinkedList(Collection c)
		System.out.println("정렬 전" + list);
		Collections.sort(list);				// Collections.sort(List list)
		System.out.println("정렬 후" + list);
	}
}
