
public class OperatorEx27 {
	public static void main(String[] args) {
		boolean b = true;
		char ch = 'C';

		System.out.printf("b=%b\n", b); // true
		System.out.printf("!b=%b\n", !b); // false
		System.out.printf("!!b=%b\n", !!b); // true
		System.out.printf("!!!b=%b\n", !!!b); // false
		System.out.println();

		System.out.printf("ch=%c\n", ch); // C (=67)
		System.out.printf("ch < 'a' || ch > 'z'=%b\n", ch < 'a' || ch > 'z');
		// C(67) < a(97) || C(67) > z(122) => true || false => true
		System.out.printf("!('a'<=ch && ch<='z')=%b\n", !('a' <= ch && ch <= 'z'));
		// a(97) <= C(67) && C(67) <= z(122) => false && ture => false
		// !false => true
		System.out.printf("  'a'<=ch && ch<='z' =%b\n", 'a' <= ch && ch <= 'z');
		// a(97) <= C(67) && C(67) <= z(122) => false && ture => false
	}
}
