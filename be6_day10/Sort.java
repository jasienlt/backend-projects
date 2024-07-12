package be6_day10;

import java.util.ArrayList;
import java.util.HashMap;

public class Sort {

	// Time complexity: O(n) where n = total frequency of 0s,1s,2s = in.length

	public static ArrayList<Integer> pSort(int[] input) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		HashMap<Integer,Integer> freq = new HashMap<>();
		freq.put(0, 0);
		freq.put(1, 0);
		freq.put(2, 0);

		for (int i:input) {
			freq.put(i, freq.get(i)+1);
		}
		
		for (int i = 0; i<3; i++) {
			int frequency = freq.get(i);
			while (frequency >= 0) {
				result.add(i);
				frequency --;
			}
		}
		
		return result;
	}
	public static void main(String[] args) {
		int[] i = { 0, 1, 1, 0, 1, 2, 1, 2 };
		System.out.println(pSort(i));
	}
}
