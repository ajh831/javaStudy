
public class Ex14_0 {
	public static void main(String[] args) {
//		Object obj = (a, b) -> a > b ? a : b // ���ٽ�. �͸�ü
		// �� �Ʒ� ���� �� ��
		Object obj = new Object() {
			int max(int a, int b) {
				return a > b ? a : b;
			}
		};
		
//		int value = obj.max(3,5);	// ����. �������� obj�� Ÿ���� Object������ amx()��� ��ư�� �ƿ� ��� ȣ���� �� ����
		// �׷��� �ʿ��Ѱ� �Լ��� �������̽�
		
//		MyFunction_EX f = new MyFunction_EX() {
////			int max(int a, int b) {
////				return a > b ? a : b;
////			}
//			public int max(int a, int b) {	// �������̵� ��Ģ : ���������ڴ� ���� �� �ٲ۴�
//				return a > b ? a : b;
//			}
//		};
		
//		���� �ڵ带 ���ٽ����� ª�� ���̸� �Ʒ��� �ڵ尡 �ȴ�.
		// ���ٽ�(�͸� ��ü)�� �ٷ�� ���� ���������� Ÿ���� �Լ��� �������̽��� �Ѵ�.
		MyFunction_EX f = (a, b) -> a > b ? a : b; // ���ٽ�, �͸�ü
		
		int value = f.max(3, 5); // �Լ��� �������̽�
		System.out.println("value = " + value);
	}
}


@FunctionalInterface	// �Լ��� �������̽��� �� �ϳ��� �߻� �޼��常 ������ ��.
interface MyFunction_EX {
//	public abstract int max(int a, int b);
	// �Լ��� �������̽��� �޼��� max�� ���ٽİ� �����ؾ� ��(�Ű����� Ÿ��, ��� Ÿ��)
	int max(int a, int b);	// �������̽��� ��� �޼���� public�̸鼭 ���ÿ� abstract�̹Ƿ� ��������
}