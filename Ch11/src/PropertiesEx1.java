import java.util.*;

public class PropertiesEx1 {
	public static void main(String[] args) {
		Properties prop = new Properties();
		
		// prop에 키와 값(key, value)을 저장
		prop.setProperty("timeout", "30");
		prop.setProperty("language", "kr");
		prop.setProperty("size", "10");
		prop.setProperty("capacity", "10");
		
		// prop에 저장된 요소들을 Enumeration을 이용해서 출력
		Enumeration e = prop.propertyNames();
		
		while(e.hasMoreElements()) {
			String element = (String)e.nextElement();
			System.out.println(element + "=" + prop.getProperty(element));
		}
		
		System.out.println();
		prop.setProperty("size", "20"); // size의 값을 20으로 변경
		System.out.println("size=" + prop.getProperty("size"));
		System.out.println("capacity=" + prop.getProperty("capacity", "20"));
		// getProperty()는 Properties에 저장된 값을 읽어오지만 읽어오려는 키가 존재하지 않으면 지정된 기본값을 반환
		// getProperty(String key)
		// getProperty(String key, String defaultValue)
		System.out.println("loadfactor=" + prop.getProperty("loadfactor", "0.75"));
		
		System.out.println();
		System.out.println(prop);

		System.out.println();
		prop.list(System.out);
	}
}
