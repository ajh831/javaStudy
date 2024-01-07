
public class Exercise5_9 {
	public static void main(String[] args) {
		char[][] star = {
				{'*','*',' ',' ',' '},
				{'*','*',' ',' ',' '},
				{'*','*','*','*','*'},
				{'*','*','*','*','*'}
		};
		char[][] result = new char[star[0].length][star.length];
		for(int i=0; i < star.length;i++) {
			for(int j=0; j < star[i].length;j++) {
				System.out.print(star[i][j]);
			}
			System.out.println();
		}
		
//		[0,0][0,1][0,2][0,3][0,4]
//		[1,0][1,1][1,2][1,3][1,4]
//		[2,0][2,1][2,2][2,3][2,4]
//		[3,0][3,1][3,2][3,3][3,4]


//		[3,0][2,0][1,0][0,0]
//		[3,1][2,1][1,1][0,1]
//		[3,2][2,2][1,2][0,2]
//		[3,3][2,3][1,3][0,3]
//		[3,4][2,4][1,4][0,4]
		
		
//		star.length = 4;
//		star[0].length = 5;
		System.out.println();
		for(int i=0; i < star.length;i++) {
			for(int j=0; j < star[i].length;j++) {
				result[j][star.length-1-i] = star[i][j];
				}
		}
		for(int i=0; i < result.length;i++) {
			for(int j=0; j < result[i].length;j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
	}
}
