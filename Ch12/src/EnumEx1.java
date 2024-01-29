enum Direction {
	EAST, SOUTH, WEST, NORTH
}

public class EnumEx1 {
	public static void main(String[] args) {
		Direction d1 = Direction.EAST; // 열거형타입.상수이름
		Direction d2 = Direction.valueOf("WEST");
		Direction d3 = Enum.valueOf(Direction.class, "EAST"); // .class : Class 객체를 얻기위해서 사용하는 키워드
																// Direction.class는 Enum 클래스의 valueOf 메서드에 전달되는 인수로 사용

		System.out.println("d1 = " + d1);
		System.out.println("d2 = " + d2);
		System.out.println("d3 = " + d3);
		System.out.println(Direction.class);

		System.out.println("d1==d2 ? " + (d1 == d2));
		System.out.println("d1==d3 ? " + (d1 == d3));
		System.out.println("d1.equals(d3) ? " + d1.equals(d3));
//		System.out.println("d1 > d3 ? " +(d1 > d3));	// 에러. 열거형에서는 비교연산자 사용 불가
		System.out.println("d1.compareTo(d3)" + (d1.compareTo(d3)));
		System.out.println("d1.compareTo(d2)" + (d1.compareTo(d2)));

		switch (d1) {
		case EAST: // Direction.EAST라고 쓸 수 없음
			System.out.println("The direction is EAST.");
			break;
		case SOUTH: // Direction.EAST라고 쓸 수 없음
			System.out.println("The direction is SOUTH.");
			break;
		case WEST: // Direction.EAST라고 쓸 수 없음
			System.out.println("The direction is WEST.");
			break;
		case NORTH: // Direction.EAST라고 쓸 수 없음
			System.out.println("The direction is NORTH.");
			break;
		}
	}
}
