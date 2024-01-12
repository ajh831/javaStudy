import java.util.StringJoiner;

public class StringEx4 {
	public static void main(String[] args) {
		String animals = "dog,cat,bear";
		String[] arr = animals.split(",");
		
		System.out.println("String.join : ");
		System.out.println(String.join("-", arr));
		
		System.out.println();
		System.out.println("StringJoiner : ");
		StringJoiner sj = new StringJoiner("/", "[","]");
		for(String s : arr)	// 향상된 for문
			sj.add(s);
		
		System.out.println(sj.toString());
		
	}
}
