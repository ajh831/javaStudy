import java.util.*;

public class TreeSetEx1 {
	public static void main(String[] args) {
		TreeSet set = new TreeSet();	// TreeSet은 범위 검색에 유리(from to)
		
		String from = "b";
		String to = "d";
		
		set.add("abc");				set.add("alien");			set.add("bat");
		set.add("car");				set.add("Car");				set.add("disc");
		set.add("dance");			set.add("dZZZZ");			set.add("dzzzz");
		set.add("elephant");		set.add("elevator");		set.add("fan");
		set.add("flower");
		
		System.out.println(set);
		System.out.println("range search : from " + from + " to " + to);
//		b <= x < d -> b,c
		System.out.println("result1 : " + set.subSet(from, to));
//		끝범위도 포함하고 싶은경우 끝 범위에 "zzz" 추가
//		d로 시작하는 단어 중 dzzz 다음에 오는 단어는 없을 것이므로 d로 시작하는 단어들이 포함 될 것이며
//		dance, disc 보다 dZZZZ이 앞에 있는 것을 확인한 결과 정렬할때 대문자가 소문자보다 우선임을 알 수 있다
//		b <= x <= d -> b,c,d
		System.out.println("result2 : " + set.subSet(from, to + "zzz"));
	}
}
