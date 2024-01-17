import java.util.*;

public class IteratorEx2 {
	public static void main(String[] args) {
		ArrayList original = new ArrayList(10);
		ArrayList copy1 = new ArrayList(10);
		ArrayList copy2 = new ArrayList(10);
		
		for (int i = 0; i < 10; i++) {
			original.add(i+"");
		}
		
		Iterator it = original.iterator();
		
		// 현재 위치가 첫번째 글자 바로 앞에 있다고 한다.
		// 그래서 it.next()를 하는경우 0부터 가져올 수 있다.
		while(it.hasNext()) {	// 읽어올 다음 요소가 있는지 확인
//			System.out.println(it.next());
			copy1.add(it.next());
		}
		
		System.out.println("= Original에서 copy1로 복사(copy) =");
		System.out.println("original:\t" + original);
		System.out.println("copy1:\t\t"+copy1);
		System.out.println();
		
		it = original.iterator();	// Iterator는 재사용이 안되므로, 다시 얻어와야 한다.
		
		while (it.hasNext()) {
			copy2.add(it.next());
			it.remove();	// remove는 단독으로 쓰일 수 없고 next와 함께 쓰여야 함
							// 특정위치의 요소를 삭제하는 것이 아닌 읽어 온 것을 삭제하는 것
		}
		
		System.out.println("= Original에서 copy2로 이동(move) =");
		System.out.println("original:\t" + original);
		System.out.println("copy2:\t\t" + copy2);
	}
}
