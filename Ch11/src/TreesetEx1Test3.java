import java.util.*;

public class TreesetEx1Test3 {
	public static void main(String[] args) {
//		Set set = new TreeSet();	// 범위 검색, 정렬.
									// 추가적으로 정렬 필요없음
//		Set set = new TreeSet(new TestComp());	// 새로만든 비교기준 추가
		Set set = new TreeSet();	// Test3클래스에 Comparable구현한 경우 안넣어도 됨
		
//		for (int i = 0; set.size() < 6; i++) {
			set.add(new Test3());
			set.add(new Test3());
			set.add(new Test3());
			set.add(new Test3());
//		}
		
		System.out.println(set);
	}
}

class Test3 implements Comparable {
	// 만약 Test3클래스가 Comparable을 구현한다면 Comparator 안넣어도 됨

	@Override
	public int compareTo(Object o) {
		return -1;
	}
	
}
// 1. 객체가 비교기준을 가지고 있s던지 -> class Test impolements Comparable

class TestComp3 implements Comparator{	// 비교기준
	@Override
	public int compare(Object o1, Object o2) {
//		return 0;	// 0으로하면 같은 객체라고 인식해서 main메서드에서 프린트할 때 1개만 나옴
		return -1;	// -1, 1은 객체를 다른거로 인식하게 되어 저장이 됨
	}
	
}
// 2. TreeSet이 비교기준을 가지고 있던지 -> new TreeSet(new TestComp());
// => 1번과 2번 둘 중에 하나를 해야됨. 어디서 제공하던지간에 비교기준이 꼭 필요
