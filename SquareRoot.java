package be6_day10;

import java.util.Formatter;

public class SquareRoot {
	public static Formatter squareRoot(int n) {
		
		// Time Complexity: O(log(n))
		
		Formatter fm = new Formatter();
		
		// Base case: where n=0,1 then return itself
		if (n<2) {
			return fm.format("%.2f", n);
		} else {
		
			// Use concept of binary search
			int low = 1, high = n;
			while (low <= high) {
				float mid = (low+high)/2;
				if (mid*mid == n) {
					return fm.format("%.2f", mid);
				} else if (mid*mid > n) {
					high --;
				} else if(mid*mid < n) {
					low ++;
				}
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		int i = 4;
		System.out.println(squareRoot(i));
	}
}
