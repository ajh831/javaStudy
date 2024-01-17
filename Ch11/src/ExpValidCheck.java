import java.util.*;

public class ExpValidCheck {
	public static void main(String[] args) {
//		if(args.length!=1) {
//			System.out.println("Usage : java ExpValidCheck \"EXPRESSION\"");
//			System.out.println("Example : java ExpValidCheck \"((2+3)*1+3)\"");
//			System.exit(0);
//		}
		
		Stack st = new Stack();
//		String expression = args[0];
		String expression = "((2+3)*1+3)";
		
		System.out.println("expression:" + expression);
		
		try {
			for (int i = 0; i < expression.length(); i++) {
				char ch = expression.charAt(i);
				
				if (ch=='(') {	// 여는 괄호가 나오면
					st.push(ch+"");	// st에 여는 괄호를 담음
				} else if (ch==')') {	// 닫는 괄호가 나오면
					st.pop();	// st의 가장 위에 있는 여는 괄호를 제거
				}
			}
			
			if (st.isEmpty()) {
				System.out.println("괄호가 일치합니다.");
			} else {
				System.out.println("괄호가 일치하지 않습니다.");
			}
		} catch (EmptyStackException e) {
			System.out.println("괄호가 일치하지 않습니다.");
		}
	}
}
