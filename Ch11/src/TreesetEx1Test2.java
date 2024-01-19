import java.util.*;

public class TreesetEx1Test2 {
	public static void main(String[] args) {
//		Set set = new TreeSet();	// 범위 검색, 정렬.
									// 추가적으로 정렬 필요없음
		Set set = new TreeSet(new TestComp());	// 새로만든 비교기준 추가
		
//		for (int i = 0; set.size() < 6; i++) {
			set.add(new Test());
			set.add(new Test());
			set.add(new Test());
			set.add(new Test());
//		}
		
		System.out.println(set);
	}
}

class Test {}	// 비교기준이 없음

class TestComp implements Comparator{	// 비교기준
	@Override
	public int compare(Object o1, Object o2) {
//		return 0;	// 0으로하면 같은 객체라고 인식해서 main메서드에서 프린트할 때 1개만 나옴
		return -1;	// -1, 1은 객체를 다른거로 인식하게 되어 저장이 됨
	}
	
}
