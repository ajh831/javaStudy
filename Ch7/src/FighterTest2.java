abstract class UnitTest {
	int x, y;
	abstract void move(int x, int y);
	void stop() { System.out.println("멈춥니다."); }
}

interface Fightable2 { // 인터페이스의 모든 메서드는 public abstract. 예외없이
	void move(int x, int y);	// public abstract가 생략됨
	void attack(Fightable2 f);	// public abstract가 생략됨
}


class Fighter2 extends UnitTest implements Fightable2 {
	// 오버라이딩 규칙 : 조상(public)보다 접근제어자가 범위가 좁으면 안됨
	public void move(int x, int y) {
		System.out.println("[" + x + "," + y + "]로 이동");
	}
	public void attack(Fightable2 f) {
		System.out.println(f + "를 공격");
	}
	
	// 싸울 수 있는 상대를 불러온다
	Fightable2 getFightable() {
		Fighter2 f = new Fighter2(); // Fighter2를 생성해서 반환
		return f;
	}
}


public class FighterTest2 {
	public static void main(String[] args) {
//		1. 
		Fighter2 f = new Fighter2();
		f.move(100,200);
//		Fighter2 f2 = new Fighter2();
//		f.attack(f2);
		f.attack(new Fighter2()); // 위와 동일 

//		2. 
		UnitTest u = new Fighter2();
//		u.attack(f); // UnitTest에는 attack메서드가 없으므로 실행 불가능 
		u.move(10, 10);
		
//		3. 
		Fightable2 ft = new Fighter2();
		ft.move(30, 30);
		ft.attack(f);
//		ft.stop(); // Fightable2에 선언된 멤버가 아니므로 사용 불가능
		
//		4.
		UnitTest u2 = new Fighter2();
		Fightable2 f2 = new Fighter2();
		u2.move(10, 200);
//		u2.attack(new Figther2()); // UnitTest에는 attack이 없어서 호출 불가
		u2.stop();
		
		f2.move(100, 20);
		f2.attack(new Fighter2());
//		f2.stop();	// Fightable에는 stop()이 없어서 호출 불가
		
//		5.
		Fighter2 f3 = new Fighter2();
		Fightable2 f4 = f3.getFightable();
//		싸울 수 있는 상대를 불로오는 getFightable의 Fightable2 인터페이스 타입과 return 타입이 일치해야하며
//		참조변수 f4의 타입과도 동일해야 한다.

	}
}

