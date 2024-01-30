import javax.swing.JOptionPane;

public class ThreadEx6 {
	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
		System.out.println("입력하신 값은 " + input + "입니다.");
		
		for (int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);	// 1초간 시간을 지연한다.
			} catch (Exception e) {
			}
		}
	}
}

// 입력을 마치기 쩐까지 숫자 출력이 되지 않다가 입력한 후에 숫자가 출력됨
