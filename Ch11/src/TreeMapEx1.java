import java.util.*;

public class TreeMapEx1 {
	public static void main(String[] args) {

		String[] data = { "A", "K", "A", "K", "D", "K", "A", "K", "K", "K", "Z", "D" };

		TreeMap map = new TreeMap();

		for (int i = 0; i < data.length; i++) {
			if (map.containsKey(data[i])) {
				Integer value = (Integer) map.get(data[i]); // get(key)
				map.put(data[i], new Integer(value.intValue() + 1));
			} else {
				map.put(data[i], new Integer(1));
			}
		}

		Iterator it = map.entrySet().iterator();

		System.out.println("= 기본정렬 =");
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			int value = ((Integer) entry.getValue()).intValue();
			System.out.println(entry.getKey() + " : " + printBar('#', value) + " " + value);
		}
		System.out.println();
		
		// map을 ArrayList로 변환한 다음 Collections.sort()로 정렬
		Set set = map.entrySet();
		List list = new ArrayList(set);	// ArrayList(Collection c)
		
		// static void sort(List list, Comparator c)
		Collections.sort(list, new ValueComparator());
		
		it = list.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			int value = ((Integer) entry.getValue()).intValue();
			System.out.println(entry.getKey() + " : " + printBar('#', value) + " " + value);
		}
		
	}

	static class ValueComparator implements Comparator {
		public int compare(Object o1, Object o2) {
			if (o1 instanceof Map.Entry && o2 instanceof Map.Entry) {
				Map.Entry e1 = (Map.Entry) o1;
				Map.Entry e2 = (Map.Entry) o2;

				int v1 = ((Integer) e1.getValue()).intValue();
				int v2 = ((Integer) e2.getValue()).intValue();

//				return v2 - v1;	// 내림차순
				return v1 - v2;	// 오름차순
//				결과가 음수인 경우
//				첫 번째 객체(o1 또는 여기서는 v1)가 두 번째 객체(o2 또는 v2)보다 "작다"고 간주
//				v1이 v2보다 앞에 위치하게 됨
				
//				결과가 양수인 경우
//				첫 번째 객체가 두 번째 객체보다 "크다"고 간주
//				오름차순 정렬에서는 v1이 v2보다 뒤에 위치하게 됨

//				결과가 0인 경우
//				두 객체가 같다고 간주되며, 순서 변경되지 않음
			}
			return -1;
		}
	}

	public static String printBar(char ch, int value) {
		char[] bar = new char[value];

		for (int i = 0; i < bar.length; i++) {
			bar[i] = ch;
		}
		return new String(bar);
	}
}
