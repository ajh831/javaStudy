import java.util.*;

class NewClass3 {
	int newField;

	int getNewField() {
		return newField;
	}

	@Deprecated
	int oldField;

	@Deprecated
	int getOldField() {
		return oldField;
	}
}

public class AnnotationEx3 {
	@SuppressWarnings("deprecation") // deprecation관련 경고를 억제함. 이미 경고를 확인했으니까 경고메시지가 안나타나게 하는 것
	public static void main(String[] args) {
		NewClass3 nc = new NewClass3();
		
		nc.oldField = 10;
		System.out.println(nc.getOldField());
		
		@SuppressWarnings("unchecked")	// 지네릭스 관련 경고 억제
		ArrayList<NewClass3> list = new ArrayList();	// 타입 지정을 하지 않았음
		list.add(nc);
	}

}
