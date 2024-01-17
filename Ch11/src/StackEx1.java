import java.util.*;

public class StackEx1 {
	public static Stack back = new Stack();	// 뒤로 stack
	public static Stack forward = new Stack();	// 앞으로 stack

	public static void main(String[] args) {
		goURL("1. 네이트"); // URL로 이동하는 메서드
		goURL("2. 야후"); // URL로 이동하는 메서드
		goURL("3. 네이버"); // URL로 이동하는 메서드
		goURL("4. 다음"); // URL로 이동하는 메서드

		printStatus(); // 현재화면 출력하는 메서드

		goBack(); // 뒤로가는 메서드
		System.out.println("= '뒤로' 버튼을 누른 후 =");
		printStatus();
		
		goBack();
		System.out.println("= '뒤로' 버튼을 누른 후 =");
		
		goForward();
		System.out.println("= '앞으로' 버튼을 누른 후 =");
		printStatus();
		
		goURL("codechobo.com");
		System.out.println("= 새로운 주소로 이동 후 =");
		printStatus();
	}

	public static void printStatus() {
		System.out.println("back:" + back);
		System.out.println("forward:" + forward);
		System.out.println("현재화면은 '" + back.peek() + "' 입니다.");
		System.out.println();
	}

	public static void goURL(String url) {
		back.push(url);	// back에 url을 추가
		if (!forward.empty()) {	// 앞으로 버튼이 비어있지 않은 경우
			forward.clear();	// 앞으로 stack을 비우기
		}
	}

	public static void goForward() {
		if (!forward.empty()) {	// 앞으로 버튼이 비어있지 않은 경우
			back.push(forward.pop()); // forward의 맨 위에 있는 값을 꺼내서 back에 담기
		}
	}

	public static void goBack() {
		if (!back.empty()) {	// back이 비어있지 않은 경우
			forward.push(back.pop());	// back의 맨 위에 있는 값을 하나 꺼내서 forward에 담기
		}
	}
}
