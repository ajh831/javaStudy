
public class ThreadEx22 {
	public static void main(String[] args) {
		RunnableEx22 r = new RunnableEx22();
		new Thread(r).start(); // ThreadGroup에 의해 참조되므로 gc대상이 아님
		new Thread(r).start(); // ThreadGroup에 의해 참조되므로 gc대상이 아님
	}

}

class Account22 {
	// private으로 지정하지 않으면 외부에서 직접 접근 가능하므로 주의가 필요함
	private int balance = 1000; // 잔고

	public int getBalance() {
		return balance;
	}

	public synchronized void withdraw(int money) {
		if (balance >= money) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			balance -= money;
		}
	}
}

class RunnableEx22 implements Runnable {
	Account22 acc = new Account22();

	public void run() {
		while (acc.getBalance() > 0) {
			// 100,200, 300 중 한 값을 임의로 선택해서 출금(withdraw)
			int money = (int) (Math.random() * 3 + 1) * 100;
			acc.withdraw(money);
			System.out.println("balance : " + acc.getBalance());
		}
	}
}

// 실행 결과
//	balance : 700
//	balance : 700
//	balance : 600
//	balance : 300
//	balance : -200
//	balance : -200

//	왜 음수나 나올까?
//	A쓰레드가 if문 조건식을 통과하고 출금하기 직전에 다른 B쓰레드가 끼어들어 출금을 먼저 했기 때문