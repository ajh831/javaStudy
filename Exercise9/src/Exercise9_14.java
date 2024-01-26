import java.util.*;
import java.util.regex.*;

public class Exercise9_14 {
	public static void main(String[] args) {
		String[] phoneNumArr = {
				"012-3456-7890",
				"099-2456-7980",
				"088-2346-9870",
				"013-3456-7890"
		};
		
		ArrayList list = new ArrayList();
		Scanner s = new Scanner(System.in);
		
		while(true) {
			System.out.print(">>");
			String input = s.nextLine().trim();
			
			if (input.equals("")) {
				continue;
			} else if(input.equalsIgnoreCase("Q")) {
				System.exit(0);
			}
			
			// 코드 작성할 곳
			// 전화번호의 일부를 입력받아 일치하는 전화번호를 주어진 문자열 배열에서 찾아서 출력하는 프로그램
			
			// 1. phoneNumArr을 한번씩 돌아가면서 전화번호를 확인
			// 2. 각 전화번호 내에서 입력받은 문자와 비교
			//	2.1. - 부호 없애고 하나의 문자열로 변경
			// 		2.1. 동일한 문자 있음
			//			2.1.2 list에 저장
			//		2.2. 동일한 문자 없음
			//			2.2.2 넘어감
			for (int i = 0; i < phoneNumArr.length; i++) {
				String[] numArr = phoneNumArr[i].split("-");
				String phoneNum = "";
				for (int j = 0; j < numArr.length; j++) {
					phoneNum += numArr[j];
				}
//				System.out.println(phoneNum);
				
				int inputLength = input.length();
				int idx=0;
				for (int j = 0; j < numArr.length-inputLength+1; j=idx) {
					String str = phoneNum.substring(j,j+inputLength);
					if (str.equals(input)) {
						list.add(phoneNumArr[i]);
						idx = idx + inputLength;
						break;
					} else {
						idx++;
					}
				}
			}
			
			if(list.size() > 0) {
				System.out.println(list);
				list.clear();
			} else {
				System.out.println("일치하는 번호가 없습니다.");
			}
		}
		
	}
}
