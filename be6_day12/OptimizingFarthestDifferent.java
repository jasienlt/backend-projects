package be6_day12;

import java.util.HashMap;

public class OptimizingFarthestDifferent {
	
	public static int solution2 (int[] arr) {
		int max_dist = Integer.MIN_VALUE;
		
		for (int i = 0; i<arr.length; i++) {
			if (arr[i] != arr[arr.length-1] || arr[0] != arr[arr.length -1 -i]) {
				max_dist = arr.length -1 -i;
				break;
			}
		}
		return max_dist;
	}
	
	public static int solution(int[] arr) {
		HashMap<Integer,Integer> map = new HashMap<>();
		
		int max_dist = Integer.MIN_VALUE;
		
		for (int i = 0; i<arr.length; i++) {
			
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], i);
			}
			
			else {
				max_dist = Math.max(max_dist, i - map.get(arr[i])-1);
				map.put(arr[i], i);
			}
		}
		
		return max_dist;
	}
	
	
	public static void main(String[] args) {
		 int[] arr1 = { 7,1,3,4,1,7 }; 
		 int[] arr = {4, 2, 2, 2, 6, 6, 2, 4};
		 System.out.println(solution(arr));
	}
}
