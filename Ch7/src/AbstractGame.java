abstract class Unit {
	int x, y;

	// 캐릭터에 맞는 move를 만들어줘야됨
	abstract void move(int x, int y);

	void stop() {
		/* 현재 위치에 정지 */
	}
}

class Marin extends Unit {
	void move(int x, int y) {
		/* 지정된 위치로 이동 */
		super.x = x;
		super.y = y;
	}

	void stimPack() {
		/* 스팀팩을 사용 */
	}
}

class Tank extends Unit {
	void move(int x, int y) {
		/* 지정된 위치로 이동 */
		super.x = x;
		super.y = y;
	}

	void changeMode() {
		/* 공격모드를 변환 */
	}
}

class Dropship extends Unit {
	void move(int x, int y) {
		/* 지정된 위치로 이동 */
		super.x = x;
		super.y = y;
	}

	void load() {
		/* 선택된 대상을 태움 */
	}

	void unload() {
		/* 선택된 대상을 내림 */
	}
}

public class AbstractGame {
	public static void main(String[] args) {
		Unit[] group = new Unit[4];
//		Object[] group = new Object[4];	// 에러. Object클래스는 move 메서드 정의 XXX
		group[0] = new Marin();
		group[1] = new Tank();
		group[2] = new Marin();
		group[3] = new Dropship();
		
		for (int i = 0; i < group.length; i++) {
			group[i].move(100, 200);	// 좌표 이동
		}
	}
}
