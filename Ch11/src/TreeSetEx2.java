import java.util.*;

public class TreeSetEx2 {
	public static void main(String[] args) {
		TreeSet set = new TreeSet();
		int[] score = {80, 95, 50, 35, 45, 65, 10, 100};
		
		for (int i = 0; i < score.length; i++) {
			set.add(score[i]);
		}
		
		System.out.println("50보다 작은 값 : " + set.headSet(50));	// to
		System.out.println("50보다 큰 값 : " + set.tailSet(50));	// from
		System.out.println("40보다 크고 80보다 작은 값 : " + set.subSet(40, 80)); // from ~ to
	}
}