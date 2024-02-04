import javax.swing.JOptionPane;

// 멀티 쓰레드
public class ThreadEx7 {
	public static void main(String[] args) {
		ThreadEx7_1 t1 = new ThreadEx7_1();
		t1.start();
		
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
		System.out.println("입력하신 값은 " + input + "입니다.");
		
		
	}
}


class ThreadEx7_1 extends Thread {
	public void run() {
		for (int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);	// 1초간 시간을 지연한다.
			} catch (Exception e) {
			}
		}
	}
}

// 쓰레드를 나누어 처리하여서 입력하지 않았어도 숫자가 출력됨