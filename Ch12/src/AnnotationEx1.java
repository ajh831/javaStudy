class Parent {
	void parentMethod1() {
		
	}
	void parentMethod2() {
		
	}
	void parentMethod3() {
		
	}
}

class Child extends Parent {
	void parentmethod1() {	// 오버라이드한 메서드가 아닌 다른 메서드로 인식
		
	}
	
//	@Override
//	void parentmethod2() {	// 애노테이션 사용하여서 컴파일 에러
//		
//	}

	@Override
	void parentMethod3() {	// OK.
		
	}
}