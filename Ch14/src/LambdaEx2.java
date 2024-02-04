@FunctionalInterface
interface MyFunction2 {
	void myMethod();
}

public class LambdaEx2 {
	public static void main(String[] args) {
		MyFunction2 f = () -> {};
		Object obj = (MyFunction2) (() -> {});	// ObjectŸ������ ����ȯ ����
		String str = ((Object) (MyFunction2) (() -> {})).toString();
		
		System.out.println(f);
		System.out.println(obj);
		System.out.println(str);
		
//		System.out.println(() -> {}); // ����. ���ٽ��� ObjectŸ������ ����ȯ �Ұ���
		System.out.println((MyFunction2) (() -> {}));
//		System.out.println((MyFunction2) (() -> {}).toString()); // ����. The target type of this expression must be a functional interface
//		MyFunction2�� �������̽�(�߻� �޼��� ����)�̰� toString()�� run()�� ȣȯ���� ����
//		���ٽ��� �Լ��� �������̽��� �޼��忡 ���� �������μ��� ��ȿ��
		System.out.println(((Object)(MyFunction2) (() -> {})).toString());
	}
}

// ���� ���
//	LambdaEx2$$Lambda$23/0x0000000800c060f8@77f03bb1
//	LambdaEx2$$Lambda$24/0x0000000800c06310@326de728
//	LambdaEx2$$Lambda$25/0x0000000800c06528@21a06946
//	LambdaEx2$$Lambda$26/0x0000000800c06740@7a92922
//	LambdaEx2$$Lambda$27/0x0000000800c06958@2cfb4a64
//	LambdaEx2$$Lambda$28/0x0000000800c06b70@4b6995df

// �͸�ü : �ܺ�Ŭ�����̸�$��ȣ
// ���ٽ� : �ܺ�Ŭ�����̸�$$Lambda$��ȣ