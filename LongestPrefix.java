package be6_day10;

import java.util.Arrays;

public class LongestPrefix {

	public static String longestPrefix(String[] in) {
		Arrays.sort(in);
		
		// Sort the strings in array by lexicographical order
		// e.g: flow,flower,flight -> flight,flow,flower
		// Then, compare first and final string for common prefix
		String firstString = in[0];
		String lastString = in[in.length-1];
		
		int pointer = 0;
		while (pointer < firstString.length() && pointer < lastString.length()) {
			if (firstString.charAt(pointer) == lastString.charAt(pointer)) {
				pointer ++;
			} else {
				break;
			}
		}
		
		return firstString.substring(0,pointer);
	}
	public static void main(String[] args) {
		String[] i = {"flow","flower","flaw"};
		System.out.println(longestPrefix(i));
	}
}
