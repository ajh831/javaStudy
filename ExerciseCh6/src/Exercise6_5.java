class Student6_5 {
	String name;
	int num1;
	int num2;
	int num3;
	int num4;
	int num5;
	float avg;
	String result;
	
	Student6_5() {
		
	}
	Student6_5(String str, int num1, int num2, int num3, int num4, int num5) {
		this.name = str;
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		this.num4 = num4;
		this.num5 = num5;
		
		float score = num3 + num4 + num5;
		this.avg = (float) ((int)(((score/3f)*10)+0.5)/10f);
	}
	
	String info() {
		this.result = this.name + "," + this.num1 + "," + this.num2 + "," + this.num3 + "," + this.num4
				 + "," + this.num5 + ", " + this.avg;
		return this.result;
	}
}

public class Exercise6_5 {
	public static void main(String[] args) {
		Student6_5 s = new Student6_5("홍길동",1,1,100,60,76);
		
		System.out.println(s.info());
	}
}
