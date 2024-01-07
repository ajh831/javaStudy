
public class Exercise4_5 {
	public static void main(String[] args) {
		System.out.println("for문");
		for (int i = 0; i <= 10; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println("while문");
		int k = 0;
		while(k<11)  {
			int l = 0;
			while (l<=k) {
				System.out.print("*");
				l++;
			}
			System.out.println();
			k++;
		}
	}
}
