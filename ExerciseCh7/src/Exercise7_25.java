class Outer {
	class Inner {
		int iv=100;
	}
}

public class Exercise7_25 {
	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.Inner inner = new outer.Inner();
	}
}
