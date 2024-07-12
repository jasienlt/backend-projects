package be6_day12;

public class CalculateTheSquare {
	public static int solution(int A, int B) {
		int output = 0;
		
		A = (int) Math.ceil(Math.sqrt(A));
		B = (int) Math.floor(Math.sqrt(B));
		
		while (A <= B) {
			A = (int) Math.ceil(Math.sqrt(A));
			B = (int) Math.floor(Math.sqrt(B));
			output ++;
		}
		
		return output;
	}
	
	
	public static void main(String[] args) {
		 
		 System.out.println(solution(6000,7000));
	}
}
