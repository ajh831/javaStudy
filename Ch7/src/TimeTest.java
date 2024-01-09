
public class TimeTest {
	public static void main(String[] args) {
		Time t = new Time(26, 35, 30);
		System.out.println(t);
//		t.hour = 13;	// private 접근 제어자를 사용하기 때문에 직접적인 접근 불가능
						//		메서드를 통한 접근만 가능함
		t.setHour(t.getHour()+1);	// 현재시간보다 1시간 후로 변경
		System.out.println(t);
	}
}

class Time {
	private int hour, minute, second; // 외부에서 접근할 수 없으며 멤버변수의 값의 범위를 지정해주기 위해서 private 제어자 사용

//				같은 클래스 같은 패키지 자손 클래스 전체
//	public			o		o	 	 o		o
//	protected		o		o		 o		x
//	(default)		o		o		 x		x
//	private			o		x		 x		x
	
	Time() {

	}

	Time(int hour, int minute, int second) {
		setHour(hour);
		setMinute(minute);
		setSecond(second);
	}

//	읽는 메서드 : get
//	변경하는 메서드 : set
	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		if (isNotValidHour(hour)) {
			return;
		}
		this.hour = hour;
	}

	// 매개변수로 넘겨진 hour가 유효한지 확인해서 알려주는 메서드(메서드 생성 단축키 alt+shift+m)
	private boolean isNotValidHour(int hour) {
		return hour < 0 || hour > 23;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		if (minute < 0 || minute > 59) {
			return;
		}
		this.minute = minute;

	}
	
	public int getSecond() {
		return second;
	}
	
	public void setSecond(int second) {
		if (second < 0 || second > 59) {
			return;
		}
		this.second = second;
	}
	
	public String toString() {
		return hour + ":" + minute + ":" + second;
	}

}
