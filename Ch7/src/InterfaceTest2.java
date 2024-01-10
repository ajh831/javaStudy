class A2 {
//	void autoPlay(B2 b) {
	void autoPlay(I i) {
		i.play();
	}
}

// B클래스의 선언과 구현을 분리
interface I {
	public abstract void play();
}

class B2 implements I {
	public void play() {
		System.out.println("play in B class");
	}
}

class C implements I {
	public void play() {
		System.out.println("play in C class");
	}
}

public class InterfaceTest2 {
	public static void main(String[] args) {
		A2 a = new A2();
		a.autoPlay(new B2());
		a.autoPlay(new C());
	}
}
