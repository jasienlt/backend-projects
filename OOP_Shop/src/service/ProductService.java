package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import dto.Cart;
import dto.ItemInCart;
import entity.Product;
import entity.Shop;

public class ProductService extends Service<Product> {

	@Override
	public Product getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product save() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Product> getAllByShop(Shop shop) {
		ArrayList<Product> datas = null;
		try {
			datas = new ArrayList<Product>();
			File myObj = new File("resource/shop" + shop.id + "/product.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] splitDatas = data.split(",");
				datas.add(new Product(Integer.parseInt(splitDatas[0]), 
						splitDatas[1], 
						Float.parseFloat(splitDatas[2])));
			}
			myReader.close();
			return datas;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return datas;
	}
	
	public Product getById (Shop shop, int id) {
		ArrayList<Product> datas = this.getAllByShop(shop);
		for (Product item : datas) {
			if (item.id == id) {
				return item;
			}
		}
		return null;
	}
	
	public float printCart(Cart cart) {
		for (ItemInCart each : cart.items) {
			System.out.println(each.product.name + " - " + 
						each.product.price + " - " +
					    each.quantity + " - " +
					    each.product.price*each.quantity);
			cart.total = cart.total + each.quantity*each.product.price;
		}

 		return cart.total;
 	}

}
