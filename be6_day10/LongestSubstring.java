package be6_day10;

import java.util.Arrays;

public class LongestSubstring {

	public static String compareString(String a, String b) {
		// Time complexity: O(m*n) where m = a.length() and n = b.length()
		
		// Initialise matrix to keep track of length of longest Common substring
		// at each corresponding index of a and b
		int[][] SubstrMatrix = new int[a.length()+1][b.length()+1];
		
		// Initialise variable to keep track of index pos holding longest common substring
		int a_idx = 0;
		int maxLen = 0;
		
		for (int i = 0; i< a.length(); i++) {
			for (int j = 0; j< b.length(); j++) {
				if (i==0 || j==0) {
					SubstrMatrix[i][j] = 0;
				}
				
				else if (a.charAt(i) == b.charAt(j)) {
					SubstrMatrix[i][j] = SubstrMatrix[i-1][j-1] + 1;
					
					// Update on location where longest common substring exists
					if (maxLen < SubstrMatrix[i][j]) {
						maxLen = SubstrMatrix[i][j];
						a_idx = i;
					}
				}
				
				else {
					SubstrMatrix[i][j] = 0;
				}
			}
		}
		
		if (maxLen == 0) {
			return "";
		}
		
		else {
			return a.substring(maxLen-a_idx,a_idx+1);
		}
		
	}
	
	public static String longestSubstring(String[] in) {
		
		// Time complexity: O(n * O(m*n))) where n = in.length and O(m*n) from compareString methods
		// Hence, time complexity: O(n^2 * m)
		
		String commonSbstr = compareString(in[0],in[1]);
		for (int i = 2; i<in.length; i++) {
			commonSbstr = compareString(commonSbstr, in[i]);
		}
		
		return commonSbstr;
	}
	
	public static void main(String[] args) {
		String[] i = {"flaw","flawer","flawsome"};
		System.out.println(longestSubstring(i));
	}
}
