// 주어진 문자열에서 금지된 문자들을 제거하여 반환한다.
public class Exercise9_9 {
	public static String delChar(String src, String delCh) {
		// 내가 푼 것
//		// 1. 하나씩 돌아가면서 비교한다.
//		// 2. 같은 문자가 나오면 중지
//		String result = "";
//		String oneString = "";
//		for (int i = 0; i < src.length(); i++) {
//			for (int j = 0; j < delCh.length(); j++) {
//				if (src.charAt(i) == delCh.charAt(j)) {
//					break;
//				} else {
//					// 돌아가면서 계속 그냥 result에 씌우면 결국 한가지 값이 들어가게 될 것
//					oneString = String.valueOf(src.charAt(i));
//				}
//			}
//			// for문이 끝난 뒤에 result += result를 통해서 문자열을 더해줄 것
//			result += oneString;
//		}
//
//		return result;
// -----------------------------------------------------------------------
		
		// 해설
		StringBuffer sb = new StringBuffer(src.length());
		
		for (int i = 0; i < src.length(); i++) {
			char ch = src.charAt(i);
			System.err.println(ch);
			
			if(delCh.indexOf(ch) == -1) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}
		
	
	public static void main(String[] args) {
		System.out.println("(1!2@3^4~5)" + " -> "
										+ delChar("(1!2@3^4~5)","~!@#$%^&*()"));
		System.out.println("(1 2   3  4\t5)" + " -> "
										+ delChar("(1 2   3  4\\t5)"," \t"));
	}
}
