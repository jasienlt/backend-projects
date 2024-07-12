package be6_day12;

import java.util.Arrays;

public class SixDigit {
	
	
	public static String solution(int A, int B, int C, int D, int E, int F) {
		int[] arr = { A, B, C, D, E, F };

		Arrays.sort(arr);
		int temp = 0;
		
		if (arr[4] <  6) {
			if (arr[0] * 10 + arr[1] < 24) {
				return "" + arr[0] + arr[1] + ":" 
						+ arr[2] + arr[3] + ":"
						+ arr[4] + arr[5];
			} else {
				return "not possible";
			}

		} else if (arr[3] < 6) {
			if (arr[0] * 10 + arr[1] < 24) {
				return "" + arr[0] + arr[1] + ":" 
						+ arr[2] + arr[4] + ":"
						+ arr[3] + arr[5];
			} else {
				return "not possible";
			}
		}
		
		else if (arr[2] < 6) {
			if (arr[0] * 10 + arr[1] < 24) {
				return "" + arr[0] + arr[3] + ":" 
						+ arr[1] + arr[4] + ":"
						+ arr[2] + arr[5];
			} else {
				return "not possible";
			}
		} else {
			return "not possible";
		}
		
	}

	public static void main(String[] args) {
		int A1 = 0, B1 = 0, C1 = 0, D1 = 0, E1 = 0, F1 = 0;
		int A2 = 0, B2 = 0, C2 = 0, D2 = 7, E2 = 8, F2 = 9;
		int A3 = 2, B3 = 4, C3 = 5, D3 = 9, E3 = 5, F3 = 9;
		int A4 = 1, B4 = 8, C4 = 3, D4 = 2, E4 = 6, F4 = 4;
		System.out.println(solution(A4, B4, C4, D4, E4, F4));
	}
}
