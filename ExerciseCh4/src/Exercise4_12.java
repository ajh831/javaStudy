
public class Exercise4_12 {
	public static void main(String[] args) {
		int num = 0;
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 4; j++) {
				int x = j+1+num ;
				if (x==10) {
					break;
				}
				int y = i%3;
				if (y==0) {
					y=3;
				}
				System.out.printf("%d*%d=%d\t",x,y,x*y);
			}
			System.out.println();
			if (i%3==0) {
				System.out.println();
				num += 3;
			}
		}
	}
}
