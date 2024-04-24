package shop_service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import dto.ProductInfo;
import rank_service.Cust_Service;
import rank_service.DiamondCust_Service;
import rank_service.GoldCust_Service;
import rank_service.SilverCust_Service;
import utils.Validator;

public abstract class Shop_Service {
	public int shopSelect;
	public String fileName;
	public ArrayList<ProductInfo> productList = new ArrayList<ProductInfo>();
	public ArrayList<Float> voucherCredit;
	
	public abstract void welcomeMessage();
	
 	public void readProductFile() {
		try {
			File file = new File(fileName);
			Scanner scanInput = new Scanner(file);

			System.out.println("PRODUCT LIST");
			System.out.println();
			while (scanInput.hasNextLine()) {
				String data = scanInput.nextLine();
				String[] elArray = data.split(",");
				ProductInfo product = new ProductInfo(
						Integer.parseInt(elArray[0].trim()),
						elArray[1].trim(),
						Float.parseFloat(elArray[2].trim())
						);
				productList.add(product);
				System.out.println(elArray[0].trim() + ". " + elArray[1].trim() + ": "
						+ elArray[2].trim() + "AUD");
			}
			System.out.println();
			
			scanInput.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
 	
 	public int[] addProductToList(Scanner sc, ArrayList<ProductInfo> productList) {
 		int[] productCart = new int[productList.size()];
 		Arrays.fill(productCart, 0);
 		boolean quit = false;
 		
 		while(!quit) {
 			System.out.print("Which product would you like?");
 			int prod = Validator.validChoice(sc, 1, productList.size());
 			System.out.print("How many would you like?");
 			int qty = Validator.validInt(sc);
 			productCart[prod-1] = productCart[prod-1] + qty;
 			
 			System.out.println("Do you want to add more product? (0/1)");
 			int response = sc.nextInt();
 			if (response == 0) {
 				quit = true;
 			} else if (!sc.hasNextInt()) {
 				System.out.println("Please provide y or n.");
 			} else {
 				continue;
 			}
 		}
		return productCart;
 	}

 	public float printCart(int[] productCart, ArrayList<ProductInfo> productList) {
 		float totalAmount = 0;
 		
 		for (int i=0; i<productCart.length; i++) {
 			if(productCart[i] > 0) {
 				for (ProductInfo prod:productList) {
 					if (prod.getProductNo()==i+1) {
 		 				System.out.println(prod.getProductName() + " - " + 
 		 								   prod.getProductPrice() + " - " +
 		 								   productCart[i] + " - " +
 		 								   prod.getProductPrice()*productCart[i]);
 		 				
 		 				totalAmount = totalAmount + prod.getProductPrice()*productCart[i];
 					}
 				}
 			}
 		}
 		
 		return totalAmount;
 	}
 	public abstract int shippingSelection();
	
	public float voucherDiscount() {
		if (!voucherCredit.isEmpty()) {
			float totalCredit = 0;
			int i = 1;
			for (float amount:voucherCredit) {
				System.out.println("VOUCHER "+i+": "+amount+" AUD");
				totalCredit += amount;	
				i++;
			}
			return totalCredit;
		}
		return 0;
	}
	
	public static Shop_Service classifyShop(int custShop) {
		if (custShop == 1) {
			return new Shop1_Service();
		} else if (custShop == 2) {
			return new Shop2_Service();
		} else {
			return new Shop3_Service();
		}
	}

	
}
