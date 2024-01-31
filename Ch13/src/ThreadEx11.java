import java.util.*;

public class ThreadEx11 {
	public static void main(String[] args) throws Exception {
		ThreadEx11_1 t1 = new ThreadEx11_1("Thread1");
		ThreadEx11_2 t2 = new ThreadEx11_2("Thread2");
		t1.start();
		t2.start();
	}
}

// 쓰레드 1
class ThreadEx11_1 extends Thread {
	ThreadEx11_1(String name) {
		super(name); // 쓰레드 이름 지정 생성자
	}

	public void run() {
		try {
			sleep(5 * 1000); // 5초 동안 기다림
		} catch (InterruptedException e) {
		}
	}
}

// 쓰레드 2
class ThreadEx11_2 extends Thread {
	ThreadEx11_2(String name) {
		super(name);
	}

	public void run() {
		Map map = getAllStackTraces(); // Map타입으로 모든 스레드에 대한 정보를 반환(작업이 완료되지 않은 모든 쓰레드의 호출스택 출력)
		Iterator it = map.keySet().iterator();

		int x = 0;
		while (it.hasNext()) {
			Object obj = it.next();
			Thread t = (Thread) obj;
			StackTraceElement[] ste = (StackTraceElement[]) (map.get(obj));

//			System.out.println("[" + ++x + "] name : " + t.getName()
//			+ ", group : " + t.getThreadGroup().getName()
//			+ ", daemon : " + t.isDaemon());
//
//			for(int i = 0; i < ste.length; i++) {
//				System.out.println(ste[i]);
//			}
//			System.out.println();

			try {
				System.out.println("[" + ++x + "] name : " + t.getName()
				+ ", group : " + t.getThreadGroup().getName()
				+ ", daemon : " + t.isDaemon());
			} catch (NullPointerException ne) {
				System.out.println(ne.getMessage() + " 발생!!!!");
			} catch (Exception e) {
			} finally {
				for (int i = 0; i < ste.length; i++) {
					System.out.println(ste[i]);
				}
				System.out.println();
			}
		}
	}
}

// 실행 결과
//	[1] name : Reference Handler, group : system, daemon : true
//	java.base@17.0.9/java.lang.ref.Reference.waitForReferencePendingList(Native Method)
//	java.base@17.0.9/java.lang.ref.Reference.processPendingReferences(Reference.java:253)
//	java.base@17.0.9/java.lang.ref.Reference$ReferenceHandler.run(Reference.java:215)
//	
//	[2] name : Common-Cleaner, group : InnocuousThreadGroup, daemon : true
//	java.base@17.0.9/java.lang.Object.wait(Native Method)
//	java.base@17.0.9/java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:155)
//	java.base@17.0.9/jdk.internal.ref.CleanerImpl.run(CleanerImpl.java:140)
//	java.base@17.0.9/java.lang.Thread.run(Thread.java:840)
//	java.base@17.0.9/jdk.internal.misc.InnocuousThread.run(InnocuousThread.java:162)
//	
//	[3] name : Thread1, group : main, daemon : false
//	java.base@17.0.9/java.lang.Thread.sleep(Native Method)
//	app//ThreadEx11_1.run(ThreadEx11.java:20)
//	
//	[4] name : Attach Listener, group : system, daemon : true
//	
//	[5] name : Signal Dispatcher, group : system, daemon : true
//	
//	[6] name : Finalizer, group : system, daemon : true
//	java.base@17.0.9/java.lang.Object.wait(Native Method)
//	java.base@17.0.9/java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:155)
//	java.base@17.0.9/java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:176)
//	java.base@17.0.9/java.lang.ref.Finalizer$FinalizerThread.run(Finalizer.java:172)
//	
//	[7] name : Notification Thread, group : system, daemon : true
//	Exception in thread "Thread2" java.lang.NullPointerException: Cannot invoke "java.lang.ThreadGroup.getName()" because the return value of "java.lang.Thread.getThreadGroup()" is null
//			at ThreadEx11_2.run(ThreadEx11.java:43)

// Thread2에서 try-catch문 사용 결과
//	java.base@17.0.9/java.util.IdentityHashMap$KeySet.iterator(IdentityHashMap.java:977)
//	java.base@17.0.9/java.util.Collections$SetFromMap.iterator(Collections.java:5686)
//	java.base@17.0.9/jdk.internal.misc.TerminatingThreadLocal.threadTerminated(TerminatingThreadLocal.java:69)
//	java.base@17.0.9/java.lang.Thread.exit(Thread.java:850)
//	
//	[2] name : Thread1, group : main, daemon : false
//	java.base@17.0.9/java.lang.Thread.sleep(Native Method)
//	app//ThreadEx11_1.run(ThreadEx11.java:20)
//	
//	[3] name : Reference Handler, group : system, daemon : true
//	java.base@17.0.9/java.lang.ref.Reference.waitForReferencePendingList(Native Method)
//	java.base@17.0.9/java.lang.ref.Reference.processPendingReferences(Reference.java:253)
//	java.base@17.0.9/java.lang.ref.Reference$ReferenceHandler.run(Reference.java:215)
//	
//	[4] name : Finalizer, group : system, daemon : true
//	java.base@17.0.9/java.lang.Object.wait(Native Method)
//	java.base@17.0.9/java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:155)
//	java.base@17.0.9/java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:176)
//	java.base@17.0.9/java.lang.ref.Finalizer$FinalizerThread.run(Finalizer.java:172)
//	
//	[5] name : Notification Thread, group : system, daemon : true
//	
//	[6] name : Signal Dispatcher, group : system, daemon : true
//	
//	[7] name : Thread2, group : main, daemon : false
//	java.base@17.0.9/java.lang.Thread.dumpThreads(Native Method)
//	java.base@17.0.9/java.lang.Thread.getAllStackTraces(Thread.java:1671)
//	app//ThreadEx11_2.run(ThreadEx11.java:33)
//	
//	[8] name : Attach Listener, group : system, daemon : true
//	
//	[9] name : Common-Cleaner, group : InnocuousThreadGroup, daemon : true
//	java.base@17.0.9/java.lang.Object.wait(Native Method)
//	java.base@17.0.9/java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:155)
//	java.base@17.0.9/jdk.internal.ref.CleanerImpl.run(CleanerImpl.java:140)
//	java.base@17.0.9/java.lang.Thread.run(Thread.java:840)
//	java.base@17.0.9/jdk.internal.misc.InnocuousThread.run(InnocuousThread.java:162)
