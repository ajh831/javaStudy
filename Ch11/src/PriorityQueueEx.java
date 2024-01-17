import java.util.*;

public class PriorityQueueEx {
	public static void main(String[] args) {
		Queue pq = new PriorityQueue();	// 우선순위가 높은 것부터 꺼냄
		pq.offer(3);	// pq.offer(new Integer(3)); 오토박싱
		pq.offer(1);
		pq.offer(5);
		pq.offer(2);
		pq.offer(4);
		System.out.println(pq);	// pq의 내부 배열을 출력
		
		Object obj = null;
		
		// PriorityQueue에 저장된 요소를 하나씩 꺼냄
		while((obj = pq.poll()) != null) {
			System.out.println(obj);
		}
	}
}
