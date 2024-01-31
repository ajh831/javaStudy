import javax.swing.JOptionPane;

// void interrupt() : 쓰레드의 interrupted상태를 false에서 true로 변경
// => 작업 중단(대기상태 : WAITING)인 쓰레드를 실행대기 상태(RUNNABLE)로 만듦
// boolean isInterrupted() : 쓰레드의 interrupted상태를 반환(초기화 X)
// static boolean interrupted() : 현재 쓰레드의 interuupted상태를 반환 후, false로 변경(초기화 O)
public class ThreadEx13 {
	public static void main(String[] args) {
		ThreadEx13_1 th1 = new ThreadEx13_1();
		th1.start();
		System.out.println("isInterrupted() : " + th1.isInterrupted()); // true
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
		System.out.println("입력하신 값은 " + input + "입니다.");
		th1.interrupt(); // interrupt()를 호출하면, interrupted상태가 true가 됨
		System.out.println("main");
		System.out.println("	*isInterrupted() : " + th1.isInterrupted()); // true
		System.out.println("	isInterrupted() : " + th1.isInterrupted()); // true
		System.out.println("	interrupted() : " + Thread.interrupted()); // false
		System.out.println("	interrupted() : " + Thread.interrupted()); // false
	}
}

class ThreadEx13_1 extends Thread {
	public void run() {
		int i = 10;
		System.out.println(this.isDaemon());

		while (i != 0 && !isInterrupted()) { // i가 0, isInterrupted가 안된 경우(true)가 될때까지 while문 수행
			System.out.println(i--);
			for (long x = 0; x < 400000000000000000L; x++)
				; // 시간지연
		}
		System.out.println("th1");
		System.out.println("	isInterrupted() : " + this.isInterrupted()); // true
		System.out.println("	isInterrupted() : " + this.isInterrupted()); // true
		System.out.println("	interrupted() : " + Thread.interrupted()); // true
		System.out.println("	interrupted() : " + Thread.interrupted()); // false

		System.out.println("카운트가 종료되었습니다.");
	}
}
