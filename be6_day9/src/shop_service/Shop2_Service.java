package shop_service;

import java.util.ArrayList;

public class Shop2_Service extends Shop_Service {
	
	@Override
	public void welcomeMessage() {
		System.out.println("Welcome to Shop 2!");
	}
	
	public Shop2_Service() {
		super.fileName = "Shop2.txt";
		
		super.voucherCredit = new ArrayList<Float>();
		super.voucherCredit.add((float) 1.3);
		super.voucherCredit.add((float) 0.7);
		super.voucherCredit.add((float) 4.2);
	}
	
	public int shippingSelection() {
		System.out.println();
		System.out.println("SHIPPING");
		System.out.println("1. Fast    $10");
				
		return 10;
	}
}
