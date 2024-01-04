class Marine {
	int x = 0, y = 0;	// Marine의 위치좌표(x, y)
	int hp = 60;	// 현재 체력
	int weapon = 6;	// 공격력
	int armor = 0;	//방어력
	
	void weaponUp() {
		
	}
	
	void armorUp() {
		armor++;
	}
	
	void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Exercise6_9 {
//	Q) 이 클래스의 멤버 중 static을 붙여야 하는 것은 어떤 것들이고 그 이유는?
//		(단, 모든 병사의 공격력과 방어력은 같아야 한다.)
//	A) 모든 병사의 공격력과 방어력은 같아야하므로 인스턴스변수로 사용하고,
//		매개변수를 통해서 수정할 수 있는 x, y를 static으로 설정해야 하므로
//		void move() {} 메서드를 static 메서드로 설정해야 한다.
}
