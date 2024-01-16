import java.util.*;

public class ArrayListEx1 {
	public static void main(String[] args) {
		// 기본 길이(용량, capacity)가 10인 ArrayList를 생성
		ArrayList list1 = new ArrayList(10);
		
		// ArrayList에는 객체만 저장 가능함
		// 그러나, autoboxing에 의해 기본형이 참조형으로 자동 변환됨
		list1.add(new Integer(5));	// 기본형
		list1.add(4);				// 참조형
		list1.add(new Integer(2));
		list1.add(0);
		list1.add(new Integer(1));
		list1.add(3);
		
		// ArrayList(Collection c)를 사용한 것
		ArrayList list2 = new ArrayList(list1.subList(1, 4));
		// 풀어쓰면 아래의 두 줄과 같음
//		List sub = list1.subList(1,4);	// sub는 읽기만 가능 [4,2,0] -> 읽기 전용
//		ArrayList list2 = new ArrayList(sub);	/// sub와 같은 내용의 ArrayList 생성
		print(list1, list2);
		
		// Collection : 인터페이스
		// Collections : 유틸 클래스
		Collections.sort(list1);	// list1과 list2를 정렬
		Collections.sort(list2);	// Collectionssort(List l)
		print(list1, list2);
		
		// list1이 list2의 모든 요소를 포함하고 있는지 확인
		System.out.println("list1.containsAll(list):"+ list1.containsAll(list2));
		
		list2.add("B");
		list2.add("C");
		print(list1, list2);
		
		list2.add(3, "A");
		print(list1, list2);
		
		list2.set(3, "AA");	// 변경
		print(list1, list2);
		
		
////		--------------------------추가--------------------------
//		list1.add(0, "1");	// 문자 타입의 1 삽입
//		print(list1, list2);
//		
//		// indexOf()는 지정된 객체의 위치(인덱스)를 알려줌
//		System.out.println("숫자 1의 index=" + list1.indexOf("1"));
//		
//		System.out.println();
////		list1.remove(0);
//		System.out.println("list1:"+list1);
//		list1.remove(new Integer(1));	// 숫자를 삭제하려면 이처럼 정확하게 지정 후 진행해야됨
//		System.out.println("list1:"+list1);
//		list1.remove(5);	// index에 있는 객체를 삭제(숫자 5 삭제 아님)
//		System.out.println("list1:"+list1);
//		// boolean revome(Object obj) 호출 X
//		// Object remove(int index) 호출 O
////		-------------------------------------------------------
		
		// list1에서 list2와 겹치는 부분만 남기고 나머지는 삭제
		System.out.println("list1.retainAll(list2):" + list1.retainAll(list2));
		print(list1, list2);
		
		// list2에서 list1에 포함된 객체들을 삭제함
		for (int i = list2.size()-1; i >= 0; i--) {
			if (list1.contains(list2.get(i))) {
				list2.remove(i);
			}
		}
		print(list1, list2);
		// 1. get(i)로 list2에서 하나씩 꺼냄
		// 2. contains()로 꺼낸 객체가 lis1에 있는지 확인
		// 3. remove(i)로 해당 객체를 list2에서 삭제
	}
	
	static void print(ArrayList list1, ArrayList list2) {
		System.out.println("list1:" + list1);
		System.out.println("list2:" + list2);
		System.out.println();
	}
}
