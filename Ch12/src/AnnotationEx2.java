class NewClass {
	int newField;

	int getNewField() {
		return newField;
	}

	@Deprecated
	int oldField; // 사용을 권장하지 않기 때문에 가운데 선으로 쭉 그어져있음

	@Deprecated
	int getOldField() {
		return oldField;
	}
}

public class AnnotationEx2 {
	public static void main(String[] args) {
		NewClass nc = new NewClass();
		
		nc.oldField = 10;    // @Depreacted가 붙은 대상을 사용
		System.out.println(nc.getOldField());    // @Depreacted가 붙은 대상을 사용
	}

//	실행 결과
//	C:\Users\Home\javaStudy\javaStudy\Ch12\src>javac AnnotationEx2.java -encoding utf-8
//	Note: AnnotationEx2.java uses or overrides a deprecated API.
//	Note: Recompile with -Xlint:deprecation for details.
	
//	-Xlint:deprecation 사용시 : deprecated된 대상인데 사용했다고 알려주는 경고를 볼 수 있음
//	C:\Users\Home\javaStudy\javaStudy\Ch12\src>javac -Xlint:deprecation AnnotationEx2.java -encoding utf-8
//	AnnotationEx2.java:21: warning: [deprecation] oldField in NewClass has been deprecated
//	                nc.oldField = 10;    // @Depreacted가 붙은 대상을 사용
//	                  ^
//	AnnotationEx2.java:22: warning: [deprecation] getOldField() in NewClass has been deprecated
//	                System.out.println(nc.getOldField());    // @Depreacted가 붙은 대상을 사용
//	                                     ^
//	2 warnings
}
