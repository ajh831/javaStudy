import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Objects;
import java.util.Vector;

import org.hamcrest.core.IsNull;
import org.junit.Test;

class MyVectorModify {
	Object[] objArr;
	int capacity = 0;
	private int size = 0; // 값을 추가해줄 때마다 size값을 증가 시킴
							// 같은 클래스 내에서만 접근할 수 있도록 private 접근 제어자 붙임

	MyVectorModify() {
		this(16);
	}

	MyVectorModify(int capacity) {
		this.capacity = capacity;
		this.objArr = new Object[capacity];
	}

//	size() : 저장된 객체의 개수를 반환한다
	// ※ null 도 저장이 가능함 ※
	// 내가 null을 저장했을 때 size가 null도 개수를 계산 해줘야됨
	// null을 문자열로 바꿔주면 될까?? XXXXXXX NO!!!!!!!!!!!
	// => add와 remove로 숫자를 카운팅하는 것으로 문제 해결
	// add하지 않는 경우에는 카운팅이 되지 않을 것이므로 size는 0일 것임
	// add를 하면 숫자를 증가시키는 코드를 넣어서 개수가 증가하게 될 것이고 그 숫자가 배열에 저장된 객체의 개수일 것
	// remove를 하면 숫자를 감소시켜서 size의 수를 줄일 것
	public int size() {
		return size;
	}

//	capacity() : 배열의 크기를 반환한다.(담을 수 있는 용량)
	public int capacity() {
		return this.capacity;
	}

//	isEmpty() : 배열이 비어있는지 비어있지 않을지를 반환한다.
	public boolean isEmpty() {
		return this.size == 0;
	}

//	add() : 배열에 객체를 추가한다.
	// 1. 저장 공간이 있는지 확인
	// 1-1. 없으면
	// 1-2. 저장공간 늘리기
	// 2.2 저장
	// 3. size를 1 증가
	public void add(Object obj) {
		if (this.size == this.capacity) { // 저장된 객체 개수가 용량과 같은 경우
			this.capacity = this.capacity * 2; // 용량을 2배로 늘려준다.
			Object[] objCp = new Object[this.capacity];
			for (int i = 0; i < objArr.length; i++) {
				objCp[i] = objArr[i];
			}
			objArr = objCp;
		}
		objArr[this.size] = obj;
		this.size++; // add()메서드를 실행할 때마다 size 수를 증가시켜준다.
	}

//	get() : 매개변수로 인덱스를 입력받아서 해당하는 인덱스의 객체를 반환해준다.
	public Object get(int index) {
		return objArr[index];
	}

//	toString() : 배열에 담긴 객체를 출력하기 위하여 문자열로 반환해준다.
	public String toString() {
		String str = "[";
		for (int i = 0; i < this.size; i++) {
			str += (i == 0) ? "" + objArr[i] : ", " + objArr[i]; // 맨 앞은 ,가 안나오도록
		}
		str += "]";

		return str;
	}

//	indexOf() : 매개변수로 객체를 받아서 배열에서 해당하는 곳의 인덱스를 반환해준다.
	// 1. 입력받은 값이 null인 경우
	// 1-1. 값 반환
	// 2. 입력받은 값이 null이 아닌 경우
	// 2-1. 값 반환
	// 3. 값이 없는 경우 -1 반환
	public int indexOf(Object obj) {
		for (int i = 0; i < this.size; i++) {
			if (Objects.isNull(objArr[i])) {
				return i;
			}

			if (objArr[i].equals(obj)) { // equals로 비교할것!!!!!!!!!!!
				return i;
			}
		}
		return -1;
	}

//	remove() : 매개변수로 객체를 받아서 배열에서 객체와 일치하는 구간의 객체를 삭제해서 true/false로 반환해준다.
	// indexOf를 활용해서 삭제를 진행한다.
	// idx가 -1인 경우는 값이 존재 하지 않으니까 false를 반환한다.
	// 아니라면 용량과 크기가 같고 다른 경우를 비교해서 진행한다.
	// 용량과 크기가 같을때는 값을 한가지 지웠을 때 맨위에 비어있는 null이 없기 때문에
	// 마지막 값을 제외하고 앞으로 당겨온 뒤 마지막 값에 따로 null을 채워준다.

	// 1. index아래의 요소드을 위로 이동
	// 2. 마지막 요소에 null저장
	// 3. size를 1 감소
	public boolean remove(Object obj) {
		int idx = indexOf(obj); // indexOf를 이용해서 해당하는 객체 존재여부를 확인

		if (idx == -1) { // -1 : 해당객체 존재하지 않는 경우 remove할 수 없음으로 반환
			return false;
		}
		for (int i = idx; i < size - 1; i++) {
			objArr[i] = objArr[i + 1];
		}
		objArr[size - 1] = null;
		this.size--;

		return true;
	}
}

public class MyVectorTest2 {
	Vector v = new Vector();
	Vector v2 = new Vector(2);

	MyVectorModify myVec = new MyVectorModify();

	@Test
	public void Addtest() {
		v.clear();
		assertTrue(v.size() == 0);
		v.add("1");
		assertTrue(v.size() == 1);
	}

	@Test
	public void capacityTest() {
		assertTrue(myVec.capacity() == 16);
		for (int i = 0; i < 20; i++) {
			myVec.add(i);
		}
		assertTrue(myVec.capacity() == 32);
		System.out.println(myVec);
	}

	@Test
	public void removeFalseTest() {
		for (int i = 0; i < 20; i++) {
			myVec.add(i);
		}
		assertTrue(myVec.remove(20) == false);
	}

	@Test
	public void removeTest() {
		for (int i = 0; i < 20; i++) {
			myVec.add(i);
		}
		assertTrue(myVec.remove(5) == true);
	}

	@Test
	public void indexOfTest() {
		for (int i = 0; i < 20; i++) {
			myVec.add(i);
		}
		assertTrue(myVec.indexOf(5) == 5);
//		assertTrue(myVec.remove(5) == true);
	}

	@Test
	public void indexOfTest2() {
		for (int i = 0; i < 20; i++) {
			myVec.add(i);
		}
		assertTrue(myVec.indexOf(5) == 5);
		assertTrue(myVec.remove(5) == true);
		System.out.println(myVec);
		assertFalse(myVec.get(5).equals(5));
	}

	@Test
	public void indexOfTestNullData() {
		for (int i = 0; i < 20; i++) {
			myVec.add(i);
		}
		assertTrue(myVec.indexOf(100) == -1);
	}

	@Test
	public void indexOfNullTest() {
		myVec.add(1);
		myVec.add(null);
		myVec.add(2);
		assertTrue(myVec.indexOf(null) == 1);
	}

	@Test
	public void sameValueTest_v() {
		v.add(1);
		v.add(null);
		v.add(2);
		v.add(1);
		assertTrue(v.indexOf(1) == 0);
	}

	@Test
	public void sameValueTest() {
		myVec.add(1);
		myVec.add(null);
		myVec.add(2);
		myVec.add(1);
		assertTrue(myVec.indexOf(1) == 0);
	}

	@Test
	public void removeTest_v() {
		v.clear();
		for (int i = 0; i < 20; i++) {
			v.add(i);
		}
		assertTrue(v.remove((Object)100) == false);
	}

	@Test
	public void removeManyTest() {
		for (int i = 0; i < 100; i++) {
			myVec.add(i);
		}
		assertTrue(myVec.size() == 100);

		for (int i = 0; i < 100; i += 2) {
			myVec.remove(i);
		}
		assertTrue(myVec.size() == 50);
	}
	
	// 1. 만개 추가했을 때
	// 2. 기본 용량(16)이 담을 수 있는 크기로 늘려졌는지 확인
	@Test
	public void capExtendTest() {
		int num = 10000;
		for (int i = 0; i < num; i++) {
			myVec.add(i);
		}
		
		int defaultCap = 16;
		int extendCap = 0;
		int n = num/defaultCap;
		System.out.println(n);
		for (int i = 1; i <= num; extendCap = defaultCap*2) {
			extendCap = defaultCap * 2;
			defaultCap = extendCap;
		}
		System.out.println(extendCap);
		System.out.println(myVec.capacity());
	}

}
