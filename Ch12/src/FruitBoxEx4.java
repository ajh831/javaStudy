import java.util.*;

class Fruit4 {
	String name;
	int weight;

	Fruit4(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

	public String toString() {
		return name + "(" + weight + ")";
	}
}

class Apple4 extends Fruit4 {
	Apple4(String name, int weight) {
		super(name, weight);
	}
}

class Grape4 extends Fruit4 {
	Grape4(String name, int weight) {
		super(name, weight);
	}
}

class Apple4Comp implements Comparator<Apple4> {
	public int compare(Apple4 t1, Apple4 t2) {
		return t2.weight - t1.weight;	// 내림차순 정렬
	}
}

class Grape4Comp implements Comparator<Grape4> {
	public int compare(Grape4 t1, Grape4 t2) {
//		return t2.weight - t1.weight;	// 내림차순 정렬
		return t1.weight - t2.weight;	// 오름차순 정렬
	}
}

class Fruit4Comp implements Comparator<Fruit4> {
	public int compare(Fruit4 t1, Fruit4 t2) {
		return t2.weight - t1.weight;
	}
}

public class FruitBoxEx4 {
	public static void main(String[] args) {
		FruitBox4<Apple4> appleBox = new FruitBox4<Apple4>();
		FruitBox4<Grape4> grapeBox = new FruitBox4<Grape4>();
		
		appleBox.add(new Apple4("GreenApple", 300));
		appleBox.add(new Apple4("GreenApple", 100));
		appleBox.add(new Apple4("GreenApple", 200));

		grapeBox.add(new Grape4("GreenGrape", 400));
		grapeBox.add(new Grape4("GreenGrape", 300));
		grapeBox.add(new Grape4("GreenGrape", 200));
		
		// Collections.sort(정렬할 객체, 정렬 기준)
		Collections.sort(appleBox.getList(), new Apple4Comp());
		Collections.sort(grapeBox.getList(), new Grape4Comp());
		System.out.println("appleBox : " + appleBox);
		System.out.println("grapeBox : " + grapeBox);
		System.out.println();
		Collections.sort(appleBox.getList(), new Fruit4Comp());	// 비교의 대상이되는 weight는 Apple과 Grape의 조상인
		Collections.sort(grapeBox.getList(), new Fruit4Comp());	// Fruit에 모두 정의되어 있기 때문에 가능
		System.out.println("appleBox : " + appleBox);
		System.out.println("grapeBox : " + grapeBox);
		
// 		Colletions 클래스에 정의된 sort()메서드
//		public static <T> void sort(List<T> list, Comparator<? super T> c) {
//	        list.sort(c);
//	    }
	}
}

class FruitBox4<T extends Fruit4> extends Box4<T> {
	
}

class Box4<T> {
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
