
class Tv {
	boolean power; // 전원상태(on/off)
	int channel; // 채널

	void power() {
		power = !power;
	}

	void channelUp() {
		++channel;
	}

	void channelDown() {
		--channel;
	}

}

class CaptionTv extends Tv { // CaptionTv(자식), Tv(부모) : CaptionTv가 Tv를 상속 받음
	boolean caption; // 캡션상태(on/off)

	void displayCaption(String text) {
//			if문은 조건이 참일 때 실행됨
		if (caption) { // 캡션 상태가 on(true)일 때만 text를 보여줌
			System.out.println(text);
		}
//		else {
//			System.out.println(text);
//		}
	}
}

public class CaptionTvTest {
	public static void main(String[] args) {
		CaptionTv ctv = new CaptionTv();
		ctv.channel = 10;	// 부모(조상) 클래스로부터 상속 받은 멤버
		ctv.channelUp();	// 부모(조상) 클래스로부터 상속 받은 멤버
		System.out.println(ctv.channel);
		ctv.displayCaption("Hello, World - 1");
		ctv.caption = true;	// 캡션(자막) 기능을 켬
		ctv.displayCaption("Hello, World - 2");
	}
}
