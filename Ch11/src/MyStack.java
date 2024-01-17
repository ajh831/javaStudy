import java.util.*;

// Vector에 구현되어 있는 메서드를 이용하여 Mystack 구현
public class MyStack extends Vector {
	public Object push(Object item) {
		addElement(item);
		return item;
	}
	
	public Object pop() {
		Object obj = peek();	// Stack에 저장된 마지막 요소를 읽어옴
		// 만일 Stack이 비어있으면 peek()메서드가 EmptyStackException을 발생시킴
		// 마지막 요소를 삭제. 배열의 index가 0 부터 시작하므로 1을 빼준다.
		removeElementAt(size() - 1);	// Vector클래스의 메서드
		return obj;
	}

	public Object peek() {
		int len = size();

		if (len == 0) {
			throw new EmptyStackException();	// 예외 던지기
		}
		// 마지막 요소를 반환. 배열의 index가 0부터 시작하므로 1을 빼줌
		return elementAt(len - 1);	// Vector클래스의 메서드
	}

	public boolean empty() {
		return size() == 0;	// Vector클래스의 메서드
	}

	public int search(Object o) {
		int i = lastIndexOf(o);	// Vector클래스의 메서드
		// 끝에서부터 객체를 찾음
		// 반환값은 저장된 위ㅣ치(배열의 index)임
		
		if (i >= 0) {
			return size() - i;
			// Stack은 맨 위에 저장된 객체의 index를 1로 정의하기 때문에 계산을 통해 구함
		}

		return -1;	// 해당 객체를 찾지 못하면 -1을 반환
	}
}
