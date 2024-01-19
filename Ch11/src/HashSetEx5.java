import java.util.*;

public class HashSetEx5 {
	public static void main(String[] args) {
		HashSet setA = new HashSet();
		HashSet setB = new HashSet();
		HashSet setHab = new HashSet();
		HashSet setKyo = new HashSet();
		HashSet setCha = new HashSet();

		setA.add("1");
		setA.add("2");
		setA.add("3");
		setA.add("4");
		setA.add("5");

		System.out.println("A = " + setA);

		setB.add("4");
		setB.add("5");
		setB.add("6");
		setB.add("7");
		setB.add("8");
		
		System.out.println("B = " + setB);
		
		Iterator it = setB.iterator();
		while(it.hasNext()) {
			Object tmp = it.next();
			if (setA.contains(tmp)) {
				setKyo.add(tmp);
			}
		}
		System.out.println("A ∩ B = " + setKyo);
		
		it = setA.iterator();
		while(it.hasNext()) {
			Object tmp = it.next();
			if(!setB.contains(tmp)) {
				setCha.add(tmp);
			}
		}
		System.out.println("A - B = " + setCha);
		
		it = setA.iterator();
		while(it.hasNext()) {
			setHab.add(it.next());
		}

		it = setB.iterator();
		while(it.hasNext()) {
			setHab.add(it.next());
		}
		
		System.out.println("A U B = " + setHab);
		
		System.out.println();
		System.out.println("retainAll, addAll, removeAll");
		setA.retainAll(setB);	// 교집합
		System.out.println("A ∩ B = " + setA);
		
		HashSet setA2 = new HashSet();
		setA2.add("1");
		setA2.add("2");
		setA2.add("3");
		setA2.add("4");
		setA2.add("5");
		
		setA2.addAll(setB);	// 합집합
		System.out.println("A U B = " + setA2);
		
		setA2.removeAll(setB); // 차집합
		System.out.println("A - B = " + setA2);
	}
}
