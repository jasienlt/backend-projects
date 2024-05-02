package be6_day11;

public class TheFeast {
	
	public static int chocolateFeast(int n, int c, int m) {

		int bars = n/c;
		int wrappers = n%c + bars;
		
		while (wrappers >= m) {
			bars = bars + wrappers/m;
			wrappers = wrappers/m + wrappers%m;
		}
		
		return bars;
	}
	
	
	public static void main(String[] args) {
		  int n = 15, c = 3, m = 2; // 9
		 // int n = 10, c = 2, m = 5; // 6
		 // int n = 12, c = 4, m = 4; // 3
		 // int n = 6, c = 2, m = 2; // 5
		 System.out.println(chocolateFeast( n,  c,  m));
	}
}
