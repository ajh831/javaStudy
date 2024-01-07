import java.util.Arrays;

public class Exercise5_6 {
	public static void main(String[] args) {
//		큰 금액의 동전을 우선적으로 거슬러 줘야한다
//		int[] coinUnit = {500, 100, 50, 10};
		int[] coinUnit = {50, 100, 500, 10, 1000, 5000};
		
		int money = 2680;
		System.out.println("money=" + money);
		
		for (int i = 0; i < coinUnit.length-1; i++) {
			for (int j = i+1; j < coinUnit.length; j++) {
				if (coinUnit[i] < coinUnit[j]) {
					int tmp = coinUnit[i];
					coinUnit[i] = coinUnit[j];
					coinUnit[j] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(coinUnit));
		
		for (int i = 0; i < coinUnit.length; i++) {
			int cnt=0;
			cnt = money/coinUnit[i];
			money -= coinUnit[i]*cnt;
			System.out.printf("%d원: %d\n", coinUnit[i],cnt);
		}
	}
}
