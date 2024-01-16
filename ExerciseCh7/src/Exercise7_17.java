class Unit {
	int x, y;
	
	void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	void stop() {
		
	}
}

class Marine extends Unit {
	int x = super.x;
	int y = super.y;
	
	void move(int x, int y) {
		super.move(x, y);
	}
	
	void stop() {
		super.stop();
	}
	
	void stimPack() {
		
	}
	
}

public class Exercise7_17 {

}
