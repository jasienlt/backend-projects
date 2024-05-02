package be6_day11;

public class FindNumber {
	
	public static int findNumber(int num, int[] arr) {
		
		// Concept: Binary Search
		// Time complexity: O(log(n))
		
		int index = -1;
		
		if (arr.length == 0) {
			return index;
		} else {
			int i = arr.length/2;
			while (i>=0 || i<arr.length) {
				if (arr[i] == num) {
					return i;
				} else if (arr[i] < num) {
					i = (0 + i)/2;
				} else {
					i = (arr.length - i)/2;
				}
			}
		}
		
		 
		return index;
	}
	
	public static void main(String[] args) {
		 int[] arr = { 4, 5, 11, 44, 56, 92, 100 }; // sorted array
		 int findNumber = 11;
		 System.out.println(findNumber(findNumber, arr));
	}
		 
}
