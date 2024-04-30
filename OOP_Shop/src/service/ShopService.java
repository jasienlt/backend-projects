package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import entity.Shop;

public class ShopService extends Service<Shop> {

	@Override
	public ArrayList<Shop> getAll() {
		ArrayList<Shop> datas = null;
		try {
			datas = new ArrayList<Shop>();
			File myObj = new File("resource/shops.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] splitDatas = data.split(",");
				datas.add(new Shop(Integer.parseInt(splitDatas[0]), splitDatas[1], Boolean.parseBoolean(splitDatas[2]),
						Boolean.parseBoolean(splitDatas[3]), Integer.parseInt(splitDatas[4])));
			}
			myReader.close();
			return datas;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return datas;
	}

	@Override
	public Shop getById(int id) {
		ArrayList<Shop> datas = this.getAll();
		for (Shop shop : datas) {
			if (shop.id == id) {
				return shop;
			}
		}
		return null;
	}

	@Override
	public Shop save() {
		// TODO Auto-generated method stub
		return null;
	}

}
