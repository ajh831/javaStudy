// 실행결과
// 3
// 0

// 주어진 문자열(src)에 찾으려는 문자열(target)이 몇 번 나오는지 세어서 반환
public class Exercise9_5 {
	public static int count(String src, String target) {
		int count = 0;	// 찾은 횟수
		int pos = 0;	// 찾기 시작할 위치
		
		
//		// 내가 푼 거
////		(1) 반복문을 사용해서 아래의 과정을 반복한다.
////		1. src에서 target을 pos의 위치부터 찾는다.
////		2. 찾으면 count의 값을 1 증가 시키고,
////			pos의 값을 target.length만큼 증가시킨다.
////		3. indexOf의 결과가 -1이면 반복문을 빠져나가서 count를 반환한다.
//		
//		for (int i = 0; i < src.length()-1; i++) {
//			int targetLength = target.length();
//			// 1. pos 위치 찾기
//										// 0  2
//			String findSrc = src.substring(i,i+targetLength);
//			if (findSrc.equals(target)) {	// 찾으면 count 1증가
//				count++;
//				pos += targetLength;	// pos 값을 target.length만큼 증가
//			}
//			// indexOf의 결과가 -1이면 반복문 빠져나가고, count 반환
//		}
//		return count;
		
// -----------------------------------------------------------------------
		// 해설
		while(true) {
			// 1. src에서 target을 pos의 위치부터 찾는다.
			pos = src.indexOf(target, pos);	// 지정된 문자열을 찾아 위치를 알려줌
			
			// 2. 찾으면 count의 값을 1 증가, pos의 값을 target.length만큼 증가
			if(pos!=-1) {
				count++;
				pos += target.length();
			} else {
			// 3. indexOf의 결과가 -1이면 반복문 빠져나가 count 반환
				break;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(count("12345AB12AB345AB", "AB"));
		System.out.println(count("12345", "AB"));
	}
}
