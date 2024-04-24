package shop_service;

import java.util.ArrayList;
import java.util.Scanner;

import utils.Validator;

public class Shop1_Service extends Shop_Service {
	public Shop1_Service() {
		super.fileName = "Shop1.txt";
		
		super.voucherCredit = new ArrayList<Float>();
		super.voucherCredit.add((float) 1.5);
		super.voucherCredit.add((float) 0.5);
		super.voucherCredit.add((float) 4.2);

	}
	
	@Override
	public void welcomeMessage() {
		System.out.println("Welcome to Shop 1!");
	}

	@Override
	public int shippingSelection() {
		System.out.println();
		System.out.println("SHIPPING");
		System.out.println("1. Saving: $5");
		System.out.println("2. Basic:  $7");
		System.out.println("3. Fast    $10");
		System.out.print("Please select shipping/delivery option:");

		
		Scanner userInput = new Scanner(System.in);
		
		int selected = Validator.validChoice(userInput,1,3);
		
		switch (selected) {
		case 1:
			return 5;
		case 2:
			return 7;
		case 3:
			return 10;
		}
		
		return 0;
	}
	
	
}
