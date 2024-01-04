
public class Exercise3_3 {
	public static void main(String[] args) {
		int num = 10;
//		1. 양수인 경우 : 음수,0인 경우
//		2. 				0인 경우 : 음수인 경우
		System.out.println(num > 0 ? "양수" : (num == 0 ? "0" : "음수"));
	}
}
