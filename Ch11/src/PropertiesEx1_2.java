import java.util.*;
import java.util.*;

public class PropertiesEx1_2 {
	public static void main(String[] args) {
		Properties prop = new Properties();
		
		// prop에 키와 값(key, value)을 저장
		prop.setProperty("timeout", "30");
		prop.setProperty("language", "kr");
		prop.setProperty("size", "10");
		prop.setProperty("capacity", "10");
		
		// prop의 entrySet을 이용해서 Iterator로 출력
        Iterator it = prop.entrySet().iterator();

        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            System.out.println(entry.getKey() + "=" + entry.getValue());
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
