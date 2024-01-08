import java.io.IOException;
import java.nio.CharBuffer;

public class RepairableTest {
	public static void main(String[] args) {
		Tank2 tank = new Tank2();
		Dropship2 dropship = new Dropship2();
		
		Marine2 marine = new Marine2();
		SCV scv = new SCV();
		
		scv.repair(tank);	// SCV기 Tank 수리하게 함
		scv.repair(dropship);
//		scv.repair(marine);	// 에러. Marine은 인터페이스로 Repairable를 구현하고 있지00 않음
	}
}

interface Repairable {}

class Unit3 {
	int hitPoint;
	final int MAX_HP;

	Unit3(int hp) {
		MAX_HP = hp;
	}
}

class GroundUnit extends Unit3 {
	GroundUnit(int hp) {
		super(hp);
	}
}

class AirUnit extends Unit3 {
	AirUnit(int hp) {
		super(hp);
	}
}

class Tank2 extends GroundUnit implements Repairable {
	Tank2() {
		super(150);	// Tank의 HP는 150
		hitPoint = MAX_HP;
	}
	
	public String toString() {
		return "Tank";
	}
}

class Dropship2 extends AirUnit implements Repairable {
	Dropship2() {
		super(125);	// Dropship의 HP는 125
		hitPoint = MAX_HP;
	}
	
	public String toString() {
		return "Dropship";
	}
}

class Marine2 extends GroundUnit {
	Marine2() {
		super(40);
		hitPoint = MAX_HP;
	}
}

class SCV extends GroundUnit implements Repairable {
	SCV() {
		super(60);
		hitPoint = MAX_HP;
	}
	void repair(Repairable r) {
		if (r instanceof Unit3) {	// instanceof 연산자를 이용하여 타입을 체크헸기 때문에
			Unit3 u = (Unit3)r;		// Unit3 클래스에 정의된 hitPoint와 MAX_HP 사용할 수 있음
			while(u.hitPoint!=u.MAX_HP) {
				/* Unit의 HP 증가 시킴 */
				u.hitPoint++;
			}
			System.out.println(u.toString() + "의 수리가 끝났습니다.");
		}
	}
}
