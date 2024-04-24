package be6_day9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import dto.CustInfo;
import rank_service.Cust_Service;
import shop_service.Shop_Service;
import utils.Validator;

public class ShopMain {
	
	final static int VIEW_CART = 1;
	final static int VIEW_RANK = 2;
	final static int VIEW_PRODUCT = 3;
	final static int LOGOUT = 4;
	final static int EXIT = 5;
	
	public static CustInfo isUser(ArrayList<CustInfo> custList, int custID) {
		CustInfo inputUser = new CustInfo(-1, -1, "",(float)-1,-1);
		for (CustInfo users : custList) {
			if (users.getCustID() == custID) {
				inputUser = users;
			}
			break;
		}
		return inputUser;
	}
	
	public static CustInfo loginScreen(Scanner sc, ArrayList<CustInfo> custList) {
		CustInfo inputUser = new CustInfo(-1, -1, "",(float)-1,-1);

		System.out.println("LOGIN");
		boolean approved = false;
		do {
			System.out.print("Please enter your ID: ");
			int custID = Validator.validInt(sc);

			System.out.print("Please enter your password: ");
			int custPW = Validator.validInt(sc);

			inputUser = isUser(custList, custID);
			// If user not exists (not in list)
			if (inputUser.getCustID() == -1) {
				System.out.println("User not exist.");
			}
			// If user input wrong PIN
			else if (inputUser.getCustPassword() != custPW) {
				System.out.println("Unmatching card no and PIN.");
			}
			// Success case: user exists + correct PIN
			else if (inputUser.getCustID() != -1 && inputUser.getCustPassword() == custPW) {
				System.out.println("User verified successfully.");
				approved = true;
			}

		} while (!approved);

		return inputUser;
	}
	
	public static int selectMenu(Scanner sc) {
		System.out.println("MAIN MENU");
		System.out.println(" 1. View Cart");
		System.out.println(" 2. View Rank");
		System.out.println(" 3. View Product");
		System.out.println(" 4. Logout");
		System.out.println(" 5. Exit");
		System.out.print("Please select: ");

		return Validator.validChoice(sc, 1, 5);
	} 

	public static ArrayList<CustInfo> readCustFile() {
		try {
			ArrayList<CustInfo> list = new ArrayList<CustInfo>();
			File file = new File("CustList.txt");
			Scanner scanInput = new Scanner(file);

			while (scanInput.hasNextLine()) {
				String data = scanInput.nextLine();
				String[] elArray = data.split(",");
				CustInfo customerList = new CustInfo(Integer.parseInt(elArray[0].trim()), 
						Integer.parseInt(elArray[1].trim()), 
						elArray[2].trim(),
						Float.parseFloat(elArray[3].trim()), 
						Integer.parseInt(elArray[4].trim()));
				list.add(customerList);
			}
			
			scanInput.close();
			return list;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	} 

	public static void updateCustFile(ArrayList<CustInfo> custList) {
		// TODO Auto-generated method stub		
		
		FileWriter writer;
		try {			
			writer = new FileWriter("be.txt");
			for (CustInfo newCust:custList) {
				writer.write(newCust.getCustID() 
						+ ',' + newCust.getCustPassword() 
						+ ',' + newCust.getCustName()
						+ ',' + newCust.getCustPoints()
						+ ',' + newCust.getCustShop()
						+System.lineSeparator());
			}
			writer.flush();
			writer.close();
			System.out.println("Customers updated!");

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ArrayList<CustInfo> custList = readCustFile();
		Scanner sc = new Scanner(System.in);
		int option;
		int[] custCart = new int[0];
		Cust_Service registeredRank = null;
		Shop_Service registeredShop = null;

		do {
			CustInfo registeredUser = loginScreen(sc, custList);
			//Direct customer to the right rank_service
			registeredRank = Cust_Service.classifyRank(registeredUser.getCustPoints());

			//Apply the right benefits for shop_service
			registeredShop = Shop_Service.classifyShop(registeredUser.getCustShop());


			do {
				
				option = selectMenu(sc);
				switch (option) {
				case VIEW_RANK:
					registeredRank.viewRank(registeredUser);
					break;
					
				case VIEW_PRODUCT:
					registeredShop.welcomeMessage();
					registeredShop.readProductFile();
					custCart = registeredShop.addProductToList(sc, registeredShop.productList);
					
					break;

				case VIEW_CART:
					if (custCart.length == 0) {
						System.out.println("Cart is empty!");
						break;
					} else {
						// PRINT CART
						System.out.println();
						System.out.println("CHECKOUT");
						System.out.println();
						
						System.out.println("SHOPPING CART");
						System.out.println();
						
						
						float productFee = registeredShop.printCart(custCart, registeredShop.productList);
						
						// DELIVER SELECTION
						int shippingFee = registeredShop.shippingSelection();
						
						// CHECKOUT

						
						//Apply benefit
						float shopVoucher = registeredShop.voucherDiscount();
						float rankBenefit = registeredRank.insertBenefit(shippingFee, productFee);
						
						//TOTAL printout + update Points
						float totalAmount = productFee + shippingFee - shopVoucher - rankBenefit;
						System.out.println("Total: " + totalAmount);
						
						float updatedPointsBalance = registeredRank.updateCustPoints(registeredUser, totalAmount);
						System.out.println("Previous balance: " + registeredUser.getCustPoints());
						registeredUser.setCustPoints(updatedPointsBalance);
						System.out.println("Current balance: " + registeredUser.getCustPoints());
						
						updateCustFile(custList);
						break;
					}
					

				case EXIT:
					// If user wants to exit app, print thank you note and return
					System.out.println("EXIT");
					System.out.println("Thank you for using our app!");
					System.out.println("--------------------------");
					return;

				}

				System.out.println("--------------------------");
				System.out.println("--------------------------");
			} while (option != LOGOUT);
		} while (option != EXIT);
	}
		
	
}
