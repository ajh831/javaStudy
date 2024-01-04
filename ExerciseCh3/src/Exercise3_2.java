
public class Exercise3_2 {
	public static void main(String[] args) {
//		방법1
//		int numOfApples = 123;	// 사과의 개수
//		int sizeOfBucket = 10;	// 바구니의 크기(바구니에 담을 수 있는 사과의 개수)
//		int numOfBucket = numOfApples/sizeOfBucket;
//		
////		나머지가 존재하는 경우 바구니 수 +1을 해줘야 됨
//		if (numOfApples%sizeOfBucket > 0) {
//			numOfBucket++;
//		}
//		
//		System.out.println("필요한 바구니의 수 : " + numOfBucket);

		// 방법2
		int numOfApples = 123; // 사과의 개수
		int sizeOfBucket = 10; // 바구니의 크기(바구니에 담을 수 있는 사과의 개수)
		int numOfBucket = (numOfApples/sizeOfBucket) + (numOfApples%sizeOfBucket > 0 ? 1 : 0);

		System.out.println("필요한 바구니의 수 : " + numOfBucket);
	}
}
