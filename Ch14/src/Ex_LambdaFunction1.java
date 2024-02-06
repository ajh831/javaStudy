import java.util.*;
import java.util.function.*;


public class Ex_LambdaFunction1 {
	public static void main(String[] args) {
		// (String s) -> Integer.parseInt(s)
		// Function<T, R> f = (String s) -> Integer.parseInt(s)
		// Function<String, Integer> f = (String s) -> Integer.parseInt(s)
		
		Function<String, Integer> f = (s) -> Integer.parseInt(s);
		
		System.out.println("100" + 200);
		System.out.println(f.apply("100") + 200);
		
		Function<String, Integer> f2 = Integer::parseInt;	// 메서드 참조
		
		System.out.println(f2.apply("100") + 200);
	}
}