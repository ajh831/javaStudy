import java.util.*;

public class HashMapEx4 {
	public static void main(String[] args) {
		String[] data = { "A", "K", "A", "K", "D", "K", "A", "K", "K", "K", "2", "D" };

		HashMap map = new HashMap();
		
		System.out.println(map.hashCode());
		
		for (int i = 0; i < data.length; i++) {
			if (map.containsKey(data[i])) {
				Integer value = (Integer) map.get(data[i]);
				map.put(data[i], new Integer(value.intValue() + 1));
			} else {
				map.put(data[i], new Integer(1));
			}
		}
		System.out.println(map.hashCode());

		Iterator it = map.entrySet().iterator();
		
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			int value = ((Integer)entry.getValue()).intValue();
			System.out.println(entry.getKey() + " : " + printBar('#', value) + " " + value);
		}
		
	}
	
	public static String printBar(char ch, int value) {
		char[] bar = new char[value];
		
		for (int i = 0; i < bar.length; i++) {
			bar[i] = ch;
		}
		// char 배열을 String 문자열로 변환해서 보여줌
		return new String(bar); // String(char[] chARr)
	}

}
