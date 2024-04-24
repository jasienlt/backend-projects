package shop_service;

import java.util.ArrayList;
import java.util.Scanner;

import utils.Validator;

public class Shop3_Service extends Shop_Service{
	
	@Override
	public void welcomeMessage() {
		System.out.println("Welcome to Shop 3!");
	}
	
	public Shop3_Service() {
		super.fileName = "Shop3.txt";
		
		super.voucherCredit = new ArrayList<Float>();
		super.voucherCredit.add((float) 1.7);
		super.voucherCredit.add((float) 0.8);
		super.voucherCredit.add((float) 4.2);
	}

	@Override
	public int shippingSelection() {
		System.out.println();
		System.out.println("SHIPPING");
		System.out.println("1. Saving: $15");
		System.out.println("2. Basic:  $17");
		System.out.println("3. Fast    $20");
		System.out.print("Please select shipping/delivery option:");

		
		Scanner userInput = new Scanner(System.in);
		
		int selected = Validator.validChoice(userInput,1,3);
		
		switch (selected) {
		case 1:
			return 15;
		case 2:
			return 17;
		case 3:
			return 20;
		}
		
		return 0;
	}
}
