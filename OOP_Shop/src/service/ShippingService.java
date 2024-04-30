package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import entity.Shipping;
import entity.Shop;

public class ShippingService extends Service<Shipping> {
	static Scanner scanner = new Scanner(System.in);

	public Shipping getByShop(Shop shop) {
		ArrayList<Shipping> datas = this.getAllByShop(shop);
		
		System.out.println("==============================");
		System.out.println("SHIPPING");
		for (Shipping shipping : datas) {
			System.out.println(shipping.shipID + ". " + 
							   shipping.shipPrice + " - " +
							   shipping.shipDays);
		}
		System.out.println("Please pick one option:");

		int shippingChoice = scanner.nextInt();
		for (Shipping shipping : datas) {
			if (shipping.shipID == shippingChoice) {
				return shipping;
			}
		}
		return null;
	
	}

	@Override
	public ArrayList<Shipping> getAllByShop(Shop shop) {
		ArrayList<Shipping> datas = null;
		try {
			datas  = new ArrayList<Shipping>();
			File myObj = new File("resource/shop" + shop.id + "/shipping.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] splitDatas = data.split(",");
				datas.add(new Shipping(
						Integer.parseInt(splitDatas[0]),
						splitDatas[1], 
						Float.parseFloat(splitDatas[2]),
						Integer.parseInt(splitDatas[3])));
			}
			myReader.close();
			return datas;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return datas;
	}

	@Override
	public Shipping getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Shipping save() {
		// TODO Auto-generated method stub
		return null;
	}
}
