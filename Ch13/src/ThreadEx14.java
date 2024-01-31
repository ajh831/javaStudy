import javax.swing.JOptionPane;

// void interrupt() : 쓰레드의 interrupted상태를 false에서 true로 변경
// => 작업 중단(대기상태 : WAITING)인 쓰레드를 실행대기 상태(RUNNABLE)로 만듦
// boolean isInterrupted() : 쓰레드의 interrupted상태를 반환(초기화 X)
// static boolean interrupted() : 현재 쓰레드의 interuupted상태를 반환 후, false로 변경(초기화 O)
public class ThreadEx14 {
	public static void main(String[] args) {
		ThreadEx14_1 th1 = new ThreadEx14_1();
		th1.start();
		System.out.println("isInterrupted() : " + th1.isInterrupted()); // true
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
		System.out.println("입력하신 값은 " + input + "입니다.");
		th1.interrupt(); // interrupt()를 호출하면, interrupted상태가 true가 됨
		System.out.println("1. main isInterrupted() : " + th1.isInterrupted()); // true
		System.out.println("2. main isInterrupted() : " + th1.isInterrupted()); // false
		System.out.println("3. main interrupted() : " + Thread.interrupted()); // false
		System.out.println("4. main interrupted() : " + Thread.interrupted()); // false
	}
}

class ThreadEx14_1 extends Thread {
	public void run() {
		int i = 10;
		System.out.println(this.isDaemon());

		while (i != 0 && !isInterrupted()) { // i가 0, isInterrupted가 안된 경우(false)가 될때까지 while문 수행
			System.out.println(i--);
			try {
				Thread.sleep(1000); // 1초 지연
			} catch (InterruptedException e) {
//				interrupt();
			}
		}
		System.out.println("1. th1 isInterrupted() : " + this.isInterrupted()); // false
		System.out.println("2. th1 isInterrupted() : " + this.isInterrupted()); // false
		System.out.println("3. th1 interrupted() : " + Thread.interrupted()); // false
		System.out.println("4. th1 interrupted() : " + Thread.interrupted()); // false

		System.out.println("카운트가 종료되었습니다.");
	}
}

// 전부다 false로 나온이유
// Thread.sleep(1000)에서 InterruptedException이 발생했기 때문
// sleep()에 의해서 쓰레드가 잠시 멈춰있을 때, interrupt()를 호출하면 InterruptedException이 발생하고
// 쓰래드의 interrupted상태가 false로 자동 초기화 됨
// catch블럭에 interrupt()를 추가로 넣어준다면 입력이 완료되었을 때 카운트 다운이 중단 될 것
// interrupt()를 추가시 실행결과
//	1. main isInterrupted() : true
//	2. main isInterrupted() : false
//	3. main interrupted() : false
//	4. main interrupted() : false
//	1. th1 isInterrupted() : true
//	2. th1 isInterrupted() : true
//	3. th1 interrupted() : true
//	4. th1 interrupted() : false
