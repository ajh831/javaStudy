class Student6_4 {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	float avg;
	
	int getTotal() {
		return this.kor + this.eng + this.math;
	}
	
	float getAverage() {
		float num = (this.kor + this.eng + this.math)/(float)3;
//		소수점 둘째자리에서 반올림
//		1. 곱하기 100
//		2. Math.round()로 반올림 -> 안될경우 +0.5
//		3. int로 변경
//		3. float 나누기 100

//		123.456 * 10
//		1234.56 + 0.5
//		1235.06 -> int : 1235
//		1235/10 -> 123.5
		this.avg = (float)((int)((num * 10f)+0.5)/10f);
		return this.avg;
	}
}

public class Exercise6_4 {
	public static void main(String[] args) {
		Student6_4 s = new Student6_4();
		s.name = "홍길동";
		s.ban = 1;
		s.no = 1;
		s.kor = 100;
		s.eng = 60;
		s.math = 76;
		
		System.out.println("이름 : " + s.name);
		System.out.println("총점 : " + s.getTotal());
		System.out.println("평균 : " + s.getAverage());
	}
}
