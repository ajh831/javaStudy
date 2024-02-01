
public class ThreadEx21 {
	public static void main(String[] args) {
		RunnableEx21 r = new RunnableEx21();
		new Thread(r).start(); // ThreadGroup에 의해 참조되므로 gc대상이 아님
		new Thread(r).start(); // ThreadGroup에 의해 참조되므로 gc대상이 아님
	}

}

class Account {
	private int balance = 1000; // 잔고

	public int getBalance() {
		return balance;
	}

	// 1. 그냥 withdraw
	public void withdraw(int money) {
	// 2. withdraw메서드에 synchronized키오드 분이기
//	public synchronized void withdraw(int money) {
		// 3. synchronized블럭 사용하기
//		synchronized (this) {
			if (balance >= money) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
				balance -= money;
			}
//		}
	}
}

class RunnableEx21 implements Runnable {
	Account acc = new Account();

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