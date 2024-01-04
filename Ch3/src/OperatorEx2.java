
public class OperatorEx2 {
	public static void main(String[] args) {
		int i=5, j=0;
		
		j = i++;	// 후위형
		System.out.println("j=i++; 실행 후, i=" + i + ", j=" + j);
//		1. j = i		-> j = 5
//		2. i = i + 1	-> i = 5+1
		
		i=5;
		j=0;
		
		j = ++i;	// 전위형
		System.out.println("j=i++; 실행 후, i=" + i + ", j=" + j);
//		1. i = i + 1	-> i = 5+1
//		2. j = i		-> j = 6
	}
}
