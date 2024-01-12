
public class StringBufferEx2 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("01");
		StringBuffer sb2 = sb.append(23);
		sb.append('4').append(56);
		
		StringBuffer sb3 = sb.append(78);
		sb3.append(9.0);
		
		System.out.println("sb = " + sb);
		System.out.println("sb2 = " + sb2);
		System.out.println("sb3 = " + sb3);
		
		System.out.println("sb = " + sb.deleteCharAt(10));	// 10번째 인덱스 문자 삭제
		System.out.println("sb = " + sb.delete(3, 6));	// from~to 삭제 3<=x<6 -> 3,4,5번째 인덱스 문자 삭제
		System.out.println("sb = " + sb.insert(3, "abc"));	// 3번째 인덱스에 문자 삽입
		System.out.println("sb = " + sb.replace(6, sb.length(), "END"));	// 6번째 인덱스부터 11번째인덱스까지 치환
		System.out.println("capacity = " + sb.capacity());
		System.out.println("length = " + sb.length());
	}
}
