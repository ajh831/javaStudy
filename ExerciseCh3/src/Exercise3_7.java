
public class Exercise3_7 {
	public static void main(String[] args) {
//		화씨 -> 섭씨 변환 공싱 :	C = 5/9 * (F-32)
		int fahrenheit = 100;
		float celcius = ( 5/(float)9 * (fahrenheit-32));
		
		celcius = (int)((celcius * 100) + 0.5)/(float)100;
		
		System.out.println("Fahrenheit : " + fahrenheit);
		System.out.println("Celcius : " + celcius);
	}
}
