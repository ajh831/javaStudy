import java.util.*;
import static java.util.Collections.*;

public class CollectionsEx {
	public static void main(String[] args) {
		List list = new ArrayList();
		System.out.println("list = " + list);

		addAll(list, 1, 2, 3, 4, 5);
		System.out.println("addAll = " + list);

		rotate(list, 2); // 반시계 방향으로 두번 회전
		// 1,2,3,4,5 -1-> 5,1,2,3,4
		// 5,1,2,3,4 -2-> 4,5,1,2,3
		System.out.println("rotate = " + list);

		swap(list, 0, 2); // 첫번째와 세번째 교환
		System.out.println("swap = " + list);

		shuffle(list); // 저장된 요소의 위치를 임의로 변경
		System.out.println("shuffle = " + list);

		sort(list, reverseOrder()); // 역순 정렬 reverse(list);와 동일
		System.out.println("sort = " + list);

		reverse(list); // 역순 정렬
		System.out.println("reverse = " + list);
		reverse(list); // 다시 원래대로 돌림
		System.out.println("reverse = " + list);

		sort(list);
		System.out.println("sort = " + list); // 정렬

		int idx = binarySearch(list, 3); // 3이 저장된 위치(index)를 반환
		System.out.println("binarySearch = " + list);
		
		System.out.println();
		System.out.println("max = " + max(list));
		System.out.println("min = " + min(list));
		System.out.println("min = " + max(list, reverseOrder()));
		// 왜 maX 메서드를 이용하였는데 min을 구할 수 있는가?
		// ReverseOrder() 메서드를 이용해서 역순 정렬에서의 최대값을 구하였기 때문
		// list = 1,2,3,4,5
		// reverseOrder() = 5,4,3,2,1
		System.out.println();
		fill(list,9);
		System.out.println("fill = " + list);
		
		// list와 같은 크기의 새로운 list를 생성하고 2로 채움. 단, 결과는 변경불가능
		List newList = nCopies(list.size(), 2);
		System.out.println("newList = " + newList);
		
		System.out.println(disjoint(list, newList));	// 공통요소가 없으면 true
		
		copy(list, newList);
		System.out.println("newList = " + newList);
		System.out.println("list = " + list);
		
		replaceAll(list, 2, 1);
		System.out.println("list = " + list);
		
		Enumeration e = enumeration(list);	// iterator과 같음
		ArrayList list2 = list(e);
		
		System.out.println("list2 = " + list2);
	}
}
