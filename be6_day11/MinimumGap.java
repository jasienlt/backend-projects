package be6_day11;

import java.util.HashMap;

public class MinimumGap {
	
	public static int minimumGap(int[] arr) {
		HashMap<Integer,Integer> map = new HashMap<>();
		
		int min_dist = Integer.MAX_VALUE;
		
		for (int i = 0; i<arr.length; i++) {
			
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], i);
			}
			
			else {
				min_dist = Math.min(min_dist, i - map.get(arr[i]));
			}
		}
		
		return min_dist;
	}
	
	
	public static void main(String[] args) {
		 int[] arr = { 7,1,3,4,1,7 }; // sorted array
		 System.out.println(minimumGap(arr));
	}
}
