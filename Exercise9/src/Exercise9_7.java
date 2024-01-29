
public class Exercise9_7 {
	public static boolean contains(String src, String target) {
		
		if (src.indexOf(target) == -1) {
			return false;
		}
		
		return true;
		
		// 위의 코드들은 아래의 코드와 동일
		// return src.indexOf(target) != -1;
	}
	
	public static void main(String[] args) {
		System.out.println(contains("12345", "23"));
		System.out.println(contains("12345", "67"));
	}
}
