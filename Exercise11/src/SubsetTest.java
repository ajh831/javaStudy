import java.util.TreeSet;

public class SubsetTest {
	public static void main(String[] args) {

		TreeSet set = new TreeSet();

		for (int i = 0; i < 10; i++) {
			set.add(i);
		}
		
		System.out.println(set);
		
		TreeSet setSub = new TreeSet();
		setSub.addAll(set.subSet(3, 6));
		System.out.println(setSub);
		System.out.println(setSub.size());
	}
}
