import java.util.*;

class Fruit5 {
	String name;
	int weight;

	Fruit5(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

	public String toString() {
		return name + "(" + weight + ")";
	}
}

class Apple5 extends Fruit5 {
	Apple5(String name, int weight) {
		super(name, weight);
	}
}

class Grape5 extends Fruit5 {
	Grape5(String name, int weight) {
		super(name, weight);
	}
}

class Fruit5Comp implements Comparator<Fruit5> {
	public int compare(Fruit5 t1, Fruit5 t2) {
		return t2.weight - t1.weight;
	}
}

public class FruitBoxEx5 {
	public static void main(String[] args) {
		FruitBox5<Apple5> appleBox = new FruitBox5<Apple5>();
		FruitBox5<Grape5> grapeBox = new FruitBox5<Grape5>();
		
		appleBox.add(new Apple5("GreenApple", 300));
		appleBox.add(new Apple5("GreenApple", 100));
		appleBox.add(new Apple5("GreenApple", 200));

		grapeBox.add(new Grape5("GreenGrape", 500));
		grapeBox.add(new Grape5("GreenGrape", 300));
		grapeBox.add(new Grape5("GreenGrape", 200));
		
		// Collections.sort(정렬할 객체, 정렬 기준)
		Collections.sort(appleBox.getList(), new Fruit5Comp());	// 비교의 대상이되는 weight는 Apple과 Grape의 조상인
		Collections.sort(grapeBox.getList(), new Fruit5Comp());	// Fruit에 모두 정의되어 있기 때문에 가능
		System.out.println("appleBox : " + appleBox);
		System.out.println("grapeBox : " + grapeBox);
		
// 		Colletions 클래스에 정의된 sort()메서드
//		public static <T> void sort(List<T> list, Comparator<? super T> c) {
//	        list.sort(c);
//	    }
		
//		? super T : T와 그 조상 가능 -> 공통부분이 들어갈 수 있게되므로 자동으로 T자리에 들어갈 타입의 자손도 들어갈 수 있게 되는 것
	}
}

class FruitBox5<T extends Fruit5> extends Box5<T> {
	
}

class Box5<T> {
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
