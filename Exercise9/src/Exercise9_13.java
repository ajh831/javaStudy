
public class Exercise9_13 {
	public static void main(String[] args) {
//		String src = "aabbccAABBCCaa";
//		String src = "aabbccAABBaaaCCaa";
		String src = "aabbccAAaaBBCCaabbccaaeeaeaa";
		System.out.println(src);
		System.out.println("aa를 " + stringCount(src, "aa") + "개 찾았습니다.");

	}
	
	static int stringCount(String src, String key) {
		return stringCount(src, key, 0);
	}
	
	static int stringCount(String src, String key, int pos) {
		int count = 0;
		int index = 0;
		
		if (key == null || key.length() == 0) {
			return 0;
		}
		
		// 내가 푼 것
		for (int i = 0; i < src.length()-key.length()+1; i=index) {
			String str = src.substring(i, i+key.length());
			if (str.equals(key)) {
				count++;
				index = i+key.length();
			} else {
				index++;
			}
		}
		
		return count;
		
// -----------------------------------------------------------------------
//		// 해설
//		while((index = src.indexOf(key, pos)) != -1) {	// inndexOf(찾으려는 문자열, 문자열 시작 위치)
//			count++;
//			pos = index + key.length();
//		}
//		
//		return count;
		
	}
}
