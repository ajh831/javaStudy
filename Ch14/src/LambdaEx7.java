import java.util.function.*;

public class LambdaEx7 {
	public static void main(String[] args) {
		// 입력 출력
		Function<String, Integer> f = (s) -> Integer.parseInt(s, 16);
		Function<Integer, String> g = (i) -> Integer.toBinaryString(i);

		Function<String, String> h = f.andThen(g);
		Function<Integer, Integer> h2 = f.compose(g); // g.andThen(f)와 동일

		System.out.println(h.apply("FF")); // "FF" -> 255 -> "11111111"
		System.out.println(h2.apply(2)); // 2 -> "10" -> 16

		Function<String, String> f2 = x -> x; // 항등함수(identity function)
		System.out.println(f2.apply("AAA")); // AAA 그대로 출력

		Predicate<Integer> p = i -> i < 100;
		Predicate<Integer> q = i -> i < 200;
		Predicate<Integer> r = i -> i % 2 == 0;
		Predicate<Integer> notP = p.negate(); // negate : ! (not)
		
		Predicate<Integer> all = notP.and(q.or(r));
		// (i>=100) && ( (i<200) || (i%2==0) )
		
		System.out.println(all.test(150));
		//  true && (true || true) => true
		
		String str1 = "abc";
		String str2 = "abc";
		
		// str1과 str2가 같은지 비교
		Predicate<String> p2 = Predicate.isEqual(str1);
		boolean result = p2.test(str2);
		// Predicate.isEqual(str1).test(str2) == str1.equals(str2)
		System.out.println(result);
	}
}
