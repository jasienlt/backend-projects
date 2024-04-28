package be6_day10;

import java.util.HashMap;

public class RomanNumber {
	public static int romanToInt(String roman) {
		
		// Time complexity: O(n) where n = roman.length()
		
		HashMap<Character,Integer> romanNum = new HashMap<>();
		romanNum.put('I', 1);
		romanNum.put('V', 5);
		romanNum.put('X', 10);
		romanNum.put('L', 50);
		romanNum.put('C', 100);
		romanNum.put('D', 500);
		romanNum.put('M', 1000);
		
		int output = romanNum.get(roman.charAt(roman.length()-1));
		for (int i = roman.length()-2; i>=0; i--) {
			if (romanNum.get(roman.charAt(i)) >= romanNum.get(roman.charAt(i+1))) {
				output = output + romanNum.get(roman.charAt(i));
			} else {
				output = output - romanNum.get(roman.charAt(i));
			}
		}
		return output;
	}
	
	public static void main(String[] args) {
		String i = "XXIX";
		System.out.println(romanToInt(i));
	}
	
}
