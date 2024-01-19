import java.util.*;

public class HashMapEx3 {
	static HashMap phoneBook = new HashMap();

	public static void main(String[] args) {
		addPhoneNo("친구", "이자바", "010-111-1111");
		addPhoneNo("친구", "김자바", "010-222-2222");
		addPhoneNo("친구", "김자바", "010-333-3333");
		addPhoneNo("회사", "이과장", "010-444-4444");
		addPhoneNo("회사", "김대리", "010-444-3333");
		addPhoneNo("회사", "김대리", "010-555-5555");
		addPhoneNo("회사", "박대리", "010-666-6666");
		addPhoneNo("세탁", "010-888-8888");
		
		printList();
	}

	// 그룹에 전화번호 추가하는 메서드
	static void addPhoneNo(String groupName, String name, String tel) {
		addGroup(groupName);
		HashMap group = (HashMap) phoneBook.get(groupName);
		group.put(tel, name);

	}

	// 그룹을 추가하는 메서드
	static void addGroup(String groupName) {
		if (!phoneBook.containsKey(groupName)) {
			phoneBook.put(groupName, new HashMap());	// HashMap은 키, 값 모두 Object타입으로 저장
														// 그러므로 HshMap의 값으로 HashMap을 다시 저장할 수 있음
		}
	}

	static void addPhoneNo(String name, String tel) {
		addPhoneNo("기타", name, tel);
	}

	// 전화번호부 전체를 출력하는 메서드
	static void printList() {
		Set set = phoneBook.entrySet(); // HashMap에 들어있는 값들 전부 보여줌
		Iterator it = set.iterator();

		while (it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();

			Set subSet = ((HashMap) e.getValue()).entrySet(); // 그룹추가할때 grpupName이랑 HashMap()으로 들어가서
			System.out.println(" * " + e.getKey() + "[" + subSet.size() + "]");

			Iterator subIt = subSet.iterator();

			while (subIt.hasNext()) {
				Map.Entry subE = (Map.Entry) subIt.next();
				String telNo = (String)subE.getKey();
				String name = (String)subE.getValue();
				System.out.println(name + " " + telNo);
			}
			System.out.println();

		}

	}
}
