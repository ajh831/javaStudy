import java.util.*;

class Fruit12_3 implements Eatable12_3 {
	public String toString() {
		return "Fruit";
	}
}

class Apple12_3 extends Fruit12_3 {
	public String toString() {
		return "Apple";
	}
}

class Grape12_3 extends Fruit12_3 {
	public String toString() {
		return "Apple";
	}
}

class Toy12_3 {
	public String toString() {
		return "Toy";
	}
}

interface Eatable12_3 {
}

public class Ex12_3 {
	public static void main(String[] args) {
		Box12_3 b = null;
		Box12_3<String> bStr = null;
		
		b = (Box12_3)bStr;	// Box<String> -> Box 가능 but 경고
		bStr = (Box12_3<String>)b;	// Box -> Box<String> 가능 but 경고
		
		Box12_3 b2 = new Box12_3<String>();
		b2.add(new Integer(100)); // 참조변수가 원시타입이므로 가능. Box12_3 b2에 대입된 타입이 없기 때문에 가능한 것
		Box12_3<String> b3 = new Box12_3<String>();
//		b3.add(new Integer(100)); // 에러.
		
		
		FruitBox12_3<Fruit12_3> fruitBox = new FruitBox12_3<Fruit12_3>();
		FruitBox12_3<Apple12_3> appletBox = new FruitBox12_3<Apple12_3>();
		FruitBox12_3<Grape12_3> grapeBox = new FruitBox12_3<Grape12_3>();
//		FruitBox12_3<Grape12_3> grapeBox = new FruitBox12_3<Apple12_3>();	// 에러. 타입 불일치
//		FruitBox12_3<Toy12_3> toyBox = new FruitBox12_3<Toy12_3>();	// 에러
	}
}

class FruitBox12_3<T extends Fruit12_3 & Eatable12_3> extends Box12_3<T> {
}


class Box12_3<T> {
	ArrayList<T> list = new ArrayList<T>();

	void add(T item) {
		list.add(item);
	}

	T get(int i) {
		return list.get(i);
	}

	int size() {
		return list.size();
	}

	public String toStirng() {
		return list.toString();
	}
}