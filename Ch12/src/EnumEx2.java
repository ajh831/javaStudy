enum Direction2 {
	EAST(1, ">"), SOUTH(2, "V"), WEST(3, "<"), NORTH(4, "^");

	private static final Direction2[] DIR_ARR = Direction2.values();
	private final int value;
	private final String symbol;

	Direction2(int value, String symbol) { // 접근제어자 private 생략됨
		this.value = value;
		this.symbol = symbol;
	}

	public int getValues() {
		return value;
	}

	public String getSymbol() {
		return symbol;
	}

	public static Direction2 of(int dir) {
		if (dir < 1 || dir > 4) {
			throw new IllegalArgumentException("Invalid value : " + dir);	// 런타임에러. 사용자가 값을 잘못 입력한 경우에 발생
		}
		return DIR_ARR[dir - 1];
	}

	// 방향을 회전시키는 메서드, num의 값만큼 90도씩 시계방향으로 회전
	public Direction2 rotate(int num) {
		num = num % 4;

		if (num < 0)
			num += 4; // num이 음수일 때는 시계반대 방향으로 회전
						// -1인 경우 시계방향으로 3번 도는 것과 동일함

		return DIR_ARR[(value - 1 + num) % 4];
	}

	public String toString() {
		return name() + getSymbol();
	}
}

public class EnumEx2 {
	public static void main(String[] args) {
		for (Direction2 d : Direction2.values())
			System.out.printf("%s=%d%n", d.name(), d.getValues());
		
		Direction2 d1 = Direction2.EAST;
		Direction2 d2 = Direction2.of(1);
//		Direction2 d3 = Direction2.of(-1);
		System.out.printf("d1=%s, %d%n", d1.name(), d1.getValues());
		System.out.printf("d2=%s, %d%n", d2.name(), d2.getValues());
		
		System.out.println("EAST rotate 1 : " + Direction2.EAST.rotate(1));
		System.out.println("EAST rotate 2 : " + Direction2.EAST.rotate(2));
		System.out.println("EAST rotate -1 : " + Direction2.EAST.rotate(-1));
		System.out.println("EAST rotate -2 : " + Direction2.EAST.rotate(-2));
		
	}
}
