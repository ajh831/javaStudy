import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.Test;

class MyVector {
	Object[] objArr;
	int capacity = 0;
	int cnt = 0;

	MyVector() {
		this(16);
	}

	MyVector(int capacity) {
		this.capacity = capacity;
		this.objArr = new Object[capacity];
	}

	MyVector(int num, int num1, int num2, int num3) {
		this.capacity = num;
		objArr = new Object[num];
		objArr[0] = num1;
		objArr[1] = num2;
		objArr[2] = num3;
	}

	public int size() {
		if (objArr.length == 0) {
			return 0;
		}
		if (objArr[0] == null) {
			return 0;
		} else {
			cnt = 0;
			for (int i = 0; i < objArr.length; i++) {
				if (objArr[i] != null) {
					cnt++;
				} else {
					break;
				}
			}
		}
		return cnt;
	}

	public int capacity() {
//		System.out.println(objArr.length);
		if (objArr.length == 0) {
			return 0;
		} else {
			return this.capacity;
		}
	}

	public boolean isEmpty() {
		if (objArr[0] == null) {
			return true;
		}
		return false;
	}

	public void add(Object obj) {
		this.cnt = size();
		objArr[this.cnt] = obj;
	}

	public Object get(int index) {
		Object getObj = objArr[index];
		return getObj;
	}
	
	public String toString() {
		this.cnt = size();
		String str = "";
		for (int i = 0; i < cnt; i++) {
			str += String.valueOf(objArr[i]);
		}
		return str;
	}
	
	public int indexOf(Object obj) {
		this.cnt = size();
		
		if (obj != null) { // null이 아닐때
			for (int i = 0; i < cnt; i++) {
				if (objArr[i].equals(obj)) {
					return i;
				}
			}
		} else { // obj가 null인 경우
			for (int i = 0; i < cnt; i++) {
				if (objArr[i] == obj) {
					return i;
				}
			}
		}
		
		return -1;
	}
	
	public boolean remove(Object obj) {
		this.cnt = size();
		int idx = indexOf(obj);
		
		if (idx == -1) {
			return false;
		} else {
			// 1, 2, 3, 4, 5
			// 1, 2, null, 4, 5
			// null = 4 / 4 = 5 / 5 = null
			objArr[idx] = null;
			for (int i = idx; i < cnt; i++) {
				Object tmp = objArr[i]; 
				objArr[i] = objArr[i+1];
				objArr[i+1] = tmp;
			}
			
			return true;
		}
		
	}
}

public class MyVectorTest1 {
	Vector v = new Vector();

	MyVector myVec = new MyVector();

	@Test
	public void test() {
		v.clear();
		assertTrue(v.size() == 0);
		v.add("1");
		assertTrue(v.size() == 1);
	}

	@Test
	public void test1() {
		v.clear();
		assertTrue(v.size() == 0);
		v.add("1");
		v.add("2");
		v.add("3");
		assertTrue(v.size() == 3);
	}

	@Test
	public void test2() {
		assertTrue(myVec.capacity == 16);
	}

	@Test
	public void test3() {
		MyVector myVec2 = new MyVector(1);
		assertTrue(myVec2.capacity == 1);
	}

	@Test
	public void test4() {
		int capacity = 3;
		Vector v2 = new Vector(capacity);
		assertTrue(v2.capacity() == 3);
	}

	@Test
	public void test5() {
		assertTrue(myVec.capacity() == 16);
	}

	@Test
	public void test6() {
		int capacity = 3;
		MyVector myVec3 = new MyVector(capacity);
		assertTrue(myVec3.capacity() == 3);
	}

	@Test
	public void test7() {
		MyVector myVec4 = new MyVector();
		assertTrue(myVec4.size() == 0);
	}

	@Test
	public void test8() {
		assertTrue(myVec.size() == 0);
	}

	@Test
	public void test9() {
		assertTrue(myVec.isEmpty() == true);
	}

	MyVector myVec5 = new MyVector(4, 1, 2, 3);

	@Test
	public void test10() {
		assertTrue(myVec5.size() == 3);
	}

	@Test
	public void test11() {
		assertTrue(myVec5.capacity() == 4);
	}

	@Test
	public void test12() {
		assertTrue(myVec5.isEmpty() == false);
	}

	@Test
	public void test13() {
		assertTrue(myVec.isEmpty() == true);
	}

	@Test
	public void test14() {
		myVec.add("1");
		assertTrue(myVec.size() == 1);
		myVec.add(1);
		myVec.add("1");
		assertTrue(myVec.size() == 3);
		assertTrue(myVec.capacity() == 16);
		myVec.add(2);
		assertTrue(myVec.isEmpty() == false);
//		System.out.println(myVec.size());
	}

	@Test
	public void test15() {
		myVec.add(5);
		assertTrue(myVec.size() == 1);
		myVec.add(1);
		myVec.add("1");
		assertTrue(myVec.size() == 3);
		assertTrue(myVec.capacity() == 16);
		myVec.add(2);
		assertTrue(myVec.isEmpty() == false);
//		System.out.println(myVec.size());
		assertTrue(myVec.get(0).equals((Object)5));
	}

	@Test
	public void test16() {
		myVec.add(5);
		myVec.add(1);
		myVec.add("1");
		myVec.add(3);
		assertTrue(myVec.get(1).equals((Object)1));
	}

	@Test
	public void test17() {
		myVec.add(3);
		myVec.add("4");
		myVec.add("82");
		myVec.add(0);
		assertTrue(myVec.get(2).equals((Object)"82"));
		System.out.println("test17 : " + myVec.toString());
		assertTrue(myVec.toString().equals("34820"));
	}

	@Test
	public void test18() {
		myVec.add("hi");
		myVec.add("4");
		myVec.add("an");
		myVec.add(0);
		assertTrue(myVec.indexOf("hi") == 0);
		myVec.add("add");
		myVec.add(100);
		System.out.println(myVec.size());
		assertTrue(myVec.get(5).equals((Object)100));
		System.out.println(myVec.indexOf("an"));
		assertTrue(myVec.indexOf(100) == (myVec.size()-1));
	}

	@Test
	public void test19() {
		myVec.add(1);
		myVec.add(2);
		myVec.add(3);
		myVec.add(4);
		myVec.add(5);
		assertTrue(myVec.remove(3) == true);
		System.out.println(myVec.toString());
	}

	@Test
	public void test20() {
		myVec.add(1);
		myVec.add(2);
		myVec.add(3);
		myVec.add(4);
		myVec.add(5);
		assertTrue(myVec.remove(6) == false);
		System.out.println(myVec.toString());
		assertTrue(myVec.toString().equals("12345"));
	}
	
	@Test
	public void test21() {
		assertTrue(myVec.remove("hi") == false);
		System.out.println(myVec.toString());
	}
	
	@Test
	public void test22() {
		myVec.add(1);
		assertTrue(myVec.remove(1) == true);
		System.out.println(myVec.toString());
	}
}
