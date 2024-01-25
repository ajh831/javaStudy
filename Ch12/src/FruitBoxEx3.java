import java.util.*;

class Fruit3 {
	public String toString() {
		return "Fruit";
	}
}

class Apple3 extends Fruit3 {
	public String toString() {
		return "Apple";
	}
}

class Grape3 extends Fruit3 {
	public String toString() {
		return "Grape";
	}
}

class Juice {
	String name;
	
	Juice(String name) {
		this.name = name + "Juice";
	}
	
	public String toString() {
		return name;
	}
}

class Juicer {
	static Juice makeJuice(FruitBox3<? extends Fruit3> box) {	// Fruit3와 그 자손 다 가능(Fruit3, Apple3, Grape3)
		String tmp = "";
		
		for(Fruit3 f : box.getList())
			tmp += f + " ";
		
		return new Juice(tmp);
	}
}

public class FruitBoxEx3 {
	public static void main(String[] args) {
		FruitBox3<Fruit3> fruitBox = new FruitBox3<Fruit3>();
		FruitBox3<Apple3> appleBox = new FruitBox3<Apple3>();
		FruitBox3<Grape3> grapeBox = new FruitBox3<Grape3>();
		
		fruitBox.add(new Fruit3());
		fruitBox.add(new Apple3());
		fruitBox.add(new Grape3());
		appleBox.add(new Apple3());
		appleBox.add(new Apple3());
		
		FruitBox3<? extends Fruit3> fruitBox2 = new FruitBox3<Grape3>();	// Fruit3와 그 자손 다 가능
//		fruitBox2.add(new Fruit3());	// 컴파일 오류. 와일드카드 타입 사용시 자바 컴파일러가 해당 박스의 정확한 타입을 알 수 없음
//		fruitBox2.add(new Grape3());	// 			fruitBox2는 Grape3 객체만 받을 수 있지만 컴파일러가 확인 불가능 
//		fruitBox2.add(new Apple3());	// 			fruitBox2의 타입을 구체적으로 지정 또는 와일드카드 사용하지 않는 방식으로 수정할 필요 있음
		// extends를 사용한 와일드 카드는 요소 추가가 불가능함
		// 타입이 정해진 참조 변수가 아니기 때문에 컴파일러가 Fruit3인지 Apple3인지 Grape3인지 구분할 수 없음

		FruitBox3<? super Fruit3> fruitBox3 = new FruitBox3<Fruit3>();	// Fruit3와 그 조상
		fruitBox3.add(new Fruit3());
		fruitBox3.add(new Grape3());
		fruitBox3.add(new Apple3());
		// super를 사용한 와일드 카드는 가능
		// Fruit3와 그 조상들만 가능하기 때문에 Fruit3이 제일 하한이므로
		// 최소한의 타입이 Fruit3인 것을 알 수 있으므로 자식인 Apple3, Grape3를 추가할 수 있는 것
		
		// ** 그러나 변수 선언에서 와일드 카드를 사용하는 것은 권장하지 않음

		System.out.println(Juicer.makeJuice(fruitBox));
		System.out.println(Juicer.makeJuice(appleBox));
	}
}

class FruitBox3<T extends Fruit3> extends Box3<T> {
	
}

class Box3<T> {
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) {
		list.add(item);
	}
	T get(int i) {
		return list.get(i);
	}
	ArrayList<T> getList() {
		return list;
	}
	int size() {
		return list.size();
	}
	public String toString() {
		return list.toString();
	}
}