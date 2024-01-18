import java.util.*;

public class Bingo {
	public static void main(String[] args) {
//		Set set = new HashSet();
		Set set = new LinkedHashSet();
//		HashSet을 사용하면 같은 숫자가 비슷한 위치에 나오는 것을 알 수 있음
//		-> 저장된 순서를 보장하지 않고 자체적인 저장방식에 따라 순서가 결정되기 때문
//		이런 경우 HashSet보다 LinkedHashSet을 사용하는 것이 더 좋음
		
		int[][] board = new int[5][5];
		
		for (int i = 0; set.size() < 25; i++) {
			set.add((int) (Math.random() * 50) + 1 + "");
		}
		
		Iterator it = set.iterator();
		// 개념 다시 생각
		// Iterator : 컬렉션에 저장된 요소들을 읽어오는데 사용
		// iterator() : Collection인터페이스에 정의된 메서드
		// boolean hasNext() : 읽어올 요소가 남아있는지 확인
		// Object next() : 다음 요소 읽어오기. 단, 호출전에 hasNext로 먼저 읽을 요소 있는지 확인
		// void remove() : next()로 읽어온 요소를 삭제함. 반드시 next() 호출 후에 remove()호출해야 됨
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = Integer.parseInt((String)it.next());
				// next()는 반환타입이 Object타입이므로 형변환해서 원래의 타입으로 되돌려 놓아야 함
				System.out.print((board[i][j] < 10 ? "  " : " ") + board[i][j]);
			}
			System.out.println();
		}
	}
}
