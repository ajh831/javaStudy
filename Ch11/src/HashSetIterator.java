import java.util.*;

public class HashSetIterator {
	public static void main(String[] args) {
		Object[] objArr = {"1", new Integer(1), "2", "3", "3", "4", "4", "5"};
		Set set = new HashSet();
		
		for (int i = 0; i < objArr.length; i++) {
			System.out.println(objArr[i] + "=" + set.add(objArr[i]));
			set.add(objArr[i]);	// HashSet에 objArr의 요소들을 저장
		}
		
		// HashSet에 저장된 요소들을 출력
		System.out.println(set);
		
		// HashSet에 저장된 요소들을 출력(Iterator 이용)
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
