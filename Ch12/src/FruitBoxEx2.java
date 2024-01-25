import java.util.*;

class Fruit2 implements Eatable {
	public String toString() {
		return "Fruit";
	}
}
class Apple2 extends Fruit2{
	public String toString() {
		return "Apple";
	}
}
class Grape2 extends Fruit2{
	public String toString() {
		return "Grape";
	}
}
class Toy2 {
	public String toString() {
		return "Toy";
	}
}

interface Eatable{};

public class FruitBoxEx2 {
	public static void main(String[] args) {
		FruitBox2<Fruit2> fruitBox = new FruitBox2<Fruit2>();
		FruitBox2<Apple2> appleBox = new FruitBox2<Apple2>();
		FruitBox2<Grape2> grapeBox = new FruitBox2<Grape2>();
//		Fruit2<Grape2> grapeBox = new Fruit2<Apple2>();	// 에러. 지네릭스 타입 불일치
//		Fruit2<Toy2> grapeBox = new Fruit2<Toy2>();	// 에러. Toy2는 Fruit과 상속관계가 아님
		Box2<Toy2> toyBox = new Box2<Toy2>();	// Box2는 지네릭스 T를 사용하여 제약이 없으므로 Toy2 사용가능
		
		fruitBox.add(new Fruit2());
		fruitBox.add(new Apple2());
		fruitBox.add(new Grape2());
		appleBox.add(new Apple2());
//		appleBox.add(new Grape2());	// 에러. Grape2는 Apple2와 상속관계가 아님
		grapeBox.add(new Grape2());
		toyBox.add(new Toy2());
		
		System.out.println("fruitBox-" + fruitBox);
		System.out.println("appleBox-" + appleBox);
		System.out.println("grapeBox-" + grapeBox);
		System.out.println("toyBox-" + toyBox);
	}
}

class FruitBox2<T extends Fruit2 & Eatable> extends Box2<T> {
	// 인터페이스를 같이 쓸 때는 ,를 사용하지 않고 &를 사용함
}

class Box2<T> {
	ArrayList<T> list = new ArrayList<T>();	// item을 저장할 list
	void add(T item) {	// Box2에 item을 추가
		list.add(item);
	}
	T get(int i) {	// Box2에서 item을 꺼냄
		return list.get(i);
	}
	int size() {	// Box2의 크기를 반환
		return list.size();
	}
	public String toString() {
		return list.toString();
	}
}
