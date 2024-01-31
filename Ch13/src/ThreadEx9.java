
public class ThreadEx9 {
	public static void main(String[] args) {
		// getThreadGroup() : 쓰레드 자신이 속한 쓰레드 그룹 반환
		ThreadGroup main = Thread.currentThread().getThreadGroup();
		// Thread를 그룹에 포함시키려면 Thread의 생성자를 이용해야 됨
		// ThreadGroup(String name) : 지정된 이름의 새로운 쓰레드 그룹 생성
		ThreadGroup grp1 = new ThreadGroup("Group1");
		ThreadGroup grp2 = new ThreadGroup("Group2");
		
		// ThreadGroup(ThreadGroup parent, String name)
		ThreadGroup subGrp1 = new ThreadGroup(grp1, "SubGroup1");
		
		grp1.setMaxPriority(3);	// 쓰레드 그룹 grp1의 최대우선순위를 3으로 변경
		
		Runnable r = new Runnable() {
			public void run() {
				try {
					Thread.sleep(1000); // 쓰레드를 1초간 멈추게 함
				} catch(InterruptedException e) {}
			}
		};
		
		// Thread(ThreadGroup tg, Runnable r, String name)
		new Thread(grp1,    r, "th1").start();
		new Thread(subGrp1, r, "th2").start();
		new Thread(grp2,    r, "th3").start();
		// 참고] 쓰레드 그룹을 지정하지 않은 쓰레드는 자동으로 main쓰레드 그룹에 속하게 됨
		
		System.out.println(">>List of ThreadGroup : " + main.getName()
		// activeGroupCount() : 쓰레드 그룹에 포함된 활성상태(작업을 다 마치지 않은 상태)에 있는 쓰레드 그룹의 수를 반환
		+ ", Active ThreadGroup : " + main.activeGroupCount()
		// activeCount() : 쓰레드 그룹에 포함된 활성상태(작업을 다 마치지 않은 상태)에 있는 쓰레드의 수를 반환
		+ ", Active Thread : " + main.activeCount());
		
		main.list();	// main쓰레드 그룹의 정보 출력
	}
}
