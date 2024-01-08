
public class FighterTest {
	public static void main(String[] args) {
		Fighter f = new Fighter();
		
		if (f instanceof Unit2) {
			System.out.println("f는 Unit클래스의 자손입니다.");
		}
		if (f instanceof Fightable) {
			System.out.println("f는 Fightable인터페이스를 구현했습니다.");
		}
		if (f instanceof Movable) {
			System.out.println("f는 Movable인터페이스를 구현했습니다.");
		}
		if (f instanceof Attackable) {
			System.out.println("f는 Attackable인터페이스를 구현했습니다.");
		}
		if (f instanceof Object) {
			System.out.println("f는 Object클래스의 자손입니다.");
		} 
		

	}
}

class Fighter extends Unit2 implements Fightable {
	public void move(int x, int y) {	// Movable인터페이스에서 public abstract이 생략된 것이기 때문에
										// 조상의 메서드보다 넓은 범위의 접근 제어자를 지정해야 하므로
										// 접근 제어자를 반드시 public으로 사용해야 함
	}
	public void attack(Unit2 u) {
		
	}
}

class Unit2 {
	int currentHP;	// 유닛 체력
	int x;	// 유닛 위치(x좌표)
	int y;	// 유닛 위치(y좌표)
}

interface Fightable extends Movable, Attackable { }

interface Movable {	void move(int x, int y); }	// public abstract void move(int x, int y)에서 public abstract가 생략된 것
interface Attackable {	void attack(Unit2 u); }

