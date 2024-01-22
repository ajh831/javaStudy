// Properties에 저장된 데이터를 파일로 저장하기

import java.util.*;
import java.io.*;

public class PropertiesEx3 {
	public static void main(String[] args) {
		Properties prop = new Properties();
		
		prop.setProperty("timesout", "30");
		prop.setProperty("language", "한글");
		prop.setProperty("size", "10");
		prop.setProperty("capacity", "10");
		
		try {
//			prop.store(new FileOutputStream("output.txt"), "Properties Example");
//			prop.store(new FileOutputStream("output.xml"), "Properties Example");
			prop.storeToXML(new FileOutputStream("output.txt"), "Properties Example");	// 한글 문제 해결
			prop.storeToXML(new FileOutputStream("output.xml"), "Properties Example");	// 한글 문제 해결
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
