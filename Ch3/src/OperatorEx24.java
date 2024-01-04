
public class OperatorEx24 {
	public static void main(String args[]) { 
		int  x = 0;
		char ch = ' ';

		x = 15;
		System.out.printf("x=%2d, 10 < x && x < 20 =%b\n", x, 10 < x && x < 20);
//		10 < x -> true
//		x < 20 -> true
//		=> && : true

		x = 6;
		System.out.printf("x=%2d,  x%%2==0 || x%%3==0  && x%%6!=0 =%b\n", x, x%2==0||x%3==0&&x%6!=0);
//		x%3 == 0 -> true
//		x%6 != 0 -> false
//		=> && : false
//		x%2 == 0 -> true
//		=> || : true
		System.out.printf("x=%2d, (x%%2==0 || x%%3==0) && x%%6!=0 =%b\n", x,(x%2==0||x%3==0)&&x%6!=0);
//		x%2 == 0 -> true
//		x%3 == 0 -> true
//		=> || : true
//		x%6 != 0 -> false
//		=> && : false
		
		ch='1';
		System.out.printf("ch='%c', '0' <= ch && ch <= '9' =%b\n", ch, '0' <= ch && ch <='9');
//		'0' <= ch -> true
//		ch <= '9' -> true
//		&& : true
		
		ch='a';
		System.out.printf("ch='%c', 'a' <= ch && ch <= 'z' =%b\n", ch, 'a' <= ch && ch <='z');
//		'a' <= ch -> true
//		ch <= 'z' -> true
//		&& : true

		ch='A';
		System.out.printf("ch='%c', 'A' <= ch && ch <= 'Z' =%b\n", ch, 'A' <= ch && ch <='Z');
//		'A' <= ch -> true
//		ch <= 'z' -> true
//		&& : true

		ch='q';
		System.out.printf("ch='%c', ch=='q' || ch=='Q' =%b\n", ch, ch=='q' || ch=='Q');
//		'q' == ch -> true
//		ch == 'Q' -> false
//		|| : true
	}
}
