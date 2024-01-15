
public class WrapperEx1 {
	public static void main(String[] args) {
		Integer i = new Integer(100);	// i와 i2는 서로 다른 객체임
		Integer i2 = new Integer(100);
		
		System.out.println("i==i2 ? " + (i==2));
		System.out.println("i.equals(i2) ? " + i.equals(i2));
		System.out.println("i.compareTo(i2) = " + i.compareTo(i2));
		// compareTo?
		// 1. 같으면 = 0
		// 다르면 -> 2. 오른쪽이 작은 경우 = 양수 
		// 다르면 -> 3. 오른쪽이 큰 경우 = 음수 
		System.out.println("i.toString() = " + i.toString());
		
		System.out.println("MAX_VALUE = " + Integer.MAX_VALUE);
		System.out.println("MIN_VALUE = " + Integer.MIN_VALUE);
		System.out.println("SIZE = " + Integer.SIZE + " bits");
		System.out.println("BYTES = " + Integer.BYTES + " bytes");
		System.out.println("TYPE = " + Integer.TYPE);
	}
}
