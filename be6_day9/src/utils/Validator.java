package utils;

import java.util.Scanner;

public class Validator {
	
	public static int validChoice (Scanner sc, int minVal, int maxVal) {
		int selectedChoice;
		while (true) { // verify user input
			if (sc.hasNextInt()) {
				selectedChoice = sc.nextInt();
				while (selectedChoice < minVal || selectedChoice > maxVal) { // update EconomyService, selectedRoute now has 3
																	// options
					System.out.println("Invalid input.Please try again:");
					selectedChoice = sc.nextInt();
				}
				break;
			} else {
				System.out.println("Invalid input.Please try again:");
				sc.next();
			}
		}
		return selectedChoice;
	}
	
	public static int validInt(Scanner sc) {
		while (!sc.hasNextInt()) {
			System.out.println("Invalid integer.");
			System.out.print("Please re-enter: ");
			sc.next();
		}

		return sc.nextInt();
	}
	
	public static float validFloat(Scanner sc) {
		while (!sc.hasNextFloat()) {
			System.out.println("Invalid card number.");
			System.out.print("Please enter your Card No: ");
			sc.next();
		}

		return sc.nextFloat();
	}

}
