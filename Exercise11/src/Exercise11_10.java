import java.util.*;

// 숫자들의 위치가 잘 섞이지 않는 문제가 있음
// 문제가 발생하는 이유화 개선하기 위한 방법을 설명하고, 새로운 코드를 작성

// 이유 : HashSet은 비슷한 값이 비슷한 주소를 갖게 하기 때문에 숫자들의 위치가 잘 섞이지 않는다.
// 이를 개선하기 위해서 HashSet()으로 객체생성을 하지 않고
// List를 활용하여 코드를 개선한다.

public class Exercise11_10 {
	public static void main(String[] args) {
		Set set = new HashSet();
		int[][] board = new int[5][5];
		
		for(int i=0; set.size() < 25; i++) {
			set.add((int) (Math.random() * 30) + 1 + "");
		}
		ArrayList list = new ArrayList(set);

		ArrayList tmp = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			int rand = (int)(Math.random() * list.size());
			tmp.add(list.get(rand));
			list.set(rand, list.get(0));
			list.set(0, tmp.get(tmp.size()-1));
		}
		
		Iterator it = list.iterator();
		
		for(int i=0; i<board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = Integer.parseInt((String)it.next());
				System.out.print((board[i][j] < 10 ? " " : " ") + board[i][j]);
			}
			System.out.println();
		}
	}
}
