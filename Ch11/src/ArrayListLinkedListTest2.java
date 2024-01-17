import java.util.*;

public class ArrayListLinkedListTest2 {
	public static void main(String[] args) {
		ArrayList a1 = new ArrayList(1000000);
		LinkedList l1 = new LinkedList();
		add(a1);
		add(l1);
		
		System.out.println("= 순차적으로 추가하기 접근시간테스트 =");
		System.out.println("ArrayList : " + access(a1));
		System.out.println("LinkedList : " + access(l1));
	}
	
	public static void add(List list) {
		for(int i=0; i<100000; i++) list.add(i+"");
	}
	
	public static long access(List list) {
		long start = System.currentTimeMillis();
		for(int i=0; i<100000; i++) list.get(i);
		long end = System.currentTimeMillis();
		return end - start;
	}
}
