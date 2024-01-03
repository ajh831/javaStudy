
class Car3 {
	String color; // 색상
	String gearType; // 변속기 종류 - auto(자동), manual(수동)
	int door; // 문의 개수

	Car3() { // 생성자
		this("white", "auto", 4); // Car3(String c, String g, int d)를 호출
	}

	Car3(Car3 c) { // 인스턴스의 복사를 위한 생성자
//		color = c.color;
//		gearType = c.gearType;
//		door = c.door;

		// 위의 코드보다 아래의 코드를 이용하여 생성자 호출하는 것이 바람직함
//		Car3(c.color, c.gearType, c.door);
		this(c.color, c.gearType, c.door);
	}

	Car3(String c, String g, int d) {
		this.color = c;
		this.gearType = g;
		this.door = d;
	}
}

class CarTest3 {
	public static void main(String[] args) {
		Car3 c1 = new Car3();
		Car3 c2 = new Car3(c1); // c1의 복사본 c2를 생성

		System.out.println("c1의 color=" + c1.color + ", gearType=" + c1.gearType + ", door=" + c1.door);
		System.out.println("c2의 color=" + c2.color + ", gearType=" + c2.gearType + ", door=" + c2.door);

		c1.door = 100; // c1의 인스턴스변수 door의 값을 변경
		System.out.println("c1의 color=" + c1.color + ", gearType=" + c1.gearType + ", door=" + c1.door);
		System.out.println("c2의 color=" + c2.color + ", gearType=" + c2.gearType + ", door=" + c2.door);
	}
}