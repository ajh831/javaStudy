import java.util.*;

public class TreeSetLotto {
	public static void main(String[] args) {
		Set set = new TreeSet();
//		Set set = new HashSet();
		System.out.println("size = " +set.size());
		
		System.out.print("num = [");
		for (int i = 0; set.size() < 6; i++) {
			int num = (int) (Math.random() * 45) + 1;
			System.out.print((i==0?""+num:", "+num));
			set.add(num);
		}
		System.out.println("]");
		System.out.println("size = " +set.size());
		System.out.println();
		
		System.out.println("Treeset = " + set);
	}
}
