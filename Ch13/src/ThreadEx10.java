
public class ThreadEx10 implements Runnable {
	static boolean autoSave = false;

	// 일반 쓰레드(주 쓰레드)
	public static void main(String[] args) {
		Thread t = new Thread(new ThreadEx10());	// Thread(Runnable r)
		// setDaemon() : 쓰레드를 데몬 쓰레드 or 사용자쓰레드로 변경(true : 데몬)
		t.setDaemon(true); // 이 부분이 없으면 종료되지 않음
		t.start();
		
		for (int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {}
			System.out.println(i);
			
			if(i==5) {
				autoSave = true;
			}
		}
		System.out.println("프로그램을 종료합니다.");
	}
	
	// 데몬 쓰레드(보조 쓰레드)
	public void run() {
		while(true) {
			try {
				Thread.sleep(3 * 1000); // 3초마다
				System.out.println("*");
			} catch(InterruptedException e) {}
			
			// autoSave의 값이 true이면 autoSave()를 호출
			if(autoSave) {
				autoSave();
			}
		}
	}
	
	public void autoSave() {
		System.out.println("작업파일이 자동저장되었습니다.");
	}
}
