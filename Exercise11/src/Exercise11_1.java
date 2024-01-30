// 실행 결과
// list2=[3, 4, 5, 6]
// kyo=[3, 4]
// cha=[1, 2]
// hap=[1, 2, 3, 4, 5, 6]

import java.util.*;

class Exercise11_1 {
	public static void main(String[] args) {
		ArrayList list1 = new ArrayList();
		ArrayList list2 = new ArrayList();
		ArrayList kyo = new ArrayList(); // 교집합
		ArrayList cha = new ArrayList(); // 차집합
		ArrayList hap = new ArrayList(); // 합집합
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list2.add(3);
		list2.add(4);
		list2.add(5);
		list2.add(6);

		// 합집합 : boolean addAll(Collection c)
		// 교집합 : boolean retainAll(Collection c)
		// 차집합 : boolean removeAll(Collection c)
		
		// 1. 교집합
		kyo = (ArrayList) list1.clone();
		kyo.retainAll(list2);

		// 2. 차집합
		cha = (ArrayList) list1.clone();
		cha.removeAll(list2);
		
		// 3. 합집합
		hap = (ArrayList) list1.clone();
		hap.addAll(list2);
		
		System.out.println("list1=" + list1);
		System.out.println("list2=" + list2);
		System.out.println("kyo=" + kyo);
		System.out.println("cha=" + cha);
		System.out.println("hap=" + hap);
	}
}