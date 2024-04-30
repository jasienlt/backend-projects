package OOP_Shop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Exception;

import dto.Cart;
import dto.ItemInCart;
import dto.Menu;
import entity.Product;
import entity.Shipping;
import entity.Shop;
import entity.User;
import entity.Voucher;
import service.ShopService;
import service.UserService;
import service.VoucherService;
import service.ProductService;
import service.RankService;
import service.ShippingService;

public class ShopMain {

	static UserService userService = new UserService();
	static ShopService shopService = new ShopService();
	static RankService rankService = new RankService();
	static ProductService productService = new ProductService();
	static VoucherService voucherService = new VoucherService();
	static ShippingService shippingService = new ShippingService();
	static Scanner scanner = new Scanner(System.in);
	static User user;
	static Shop shop;
	static Menu menu;
	static Cart cart;

	public static void main(String[] args) {
		user = dologin();
		shop = shopService.getById(user.shopId);
		menu = new Menu(shop);
		cart = new Cart();
		
		int userRankID = 0;
		
		System.out.println("Shop " + shop.name + ", Welcome " + user.name);
		int userSelection = showMainMenuAndGetSelection();

		do {
			if (userSelection == 1) {
				// show CART
				if (cart.items.size() == 0) {
					System.out.println("Cart is empty!");
				} else {
					// print cart + calc total
					System.out.println("==============================");
					System.out.println("Checkout");
					System.out.println();
					System.out.println("Receipt");
					cart.total = productService.printCart(cart);
					System.out.println();
					System.out.println("Total: " + cart.total + " AUD");
					
					
					// show Shipping

					float shippingFee;
					if (shop.hasShippingMethods) {
						Shipping shippingChoice = shippingService.getByShop(shop);
						shippingFee = shippingChoice.shipPrice;
					} else {
						shippingFee = shop.defaultShipFee;
					}
					System.out.println("Shipping Fee: " + shippingFee + " AUD");
					
					// show Voucher
					System.out.println();
					System.out.println("Voucher");
					System.out.println();
					ArrayList<Voucher> eligibleVouchers = voucherService.bestVoucher(menu.voucherOptions, cart.total, userRankID);
					
					// Dealing with situations where totalPaid < totalDiscounted
					float totalDiscount = voucherService.printVoucher(eligibleVouchers);
					System.out.println("Discounted: " + totalDiscount + " AUD");
					
					// show Final
					float totalAmount = cart.total + shippingFee - totalDiscount;
					System.out.println("Total: " + totalAmount + " AUD");
					
					System.out.println();
					System.out.println("Points updated successfully.");
					System.out.println();
					float updatedPointsBalance = userService.updateCustPoints(user, totalAmount);
					System.out.println("Previous balance: " + user.userPoint);
					user.userPoint = updatedPointsBalance;
					System.out.println("Current balance: " + user.userPoint);
					
					// Em vẫn chưa implement sau khi thanh toán sẽ update point balance cho users.txt :((
					//updateCustFile(custList);
					break; 
				}
			
			} else if (userSelection == menu.menuOptions.size()) {
				// show RANK
				userRankID = rankService.getUserRank(user.userPoint,shop);
				
			} else {
				
				// purchase PRODUCT: show Product - Qty - Total
				int productIndex = userSelection - menu.menuOptions.size();
				Product product = productService.getById(shop,productIndex);
				
				int updated_flag = 0;
				for (ItemInCart items : cart.items) {
					// If item already exists
					if (items.product.id == product.id) {
						items.quantity ++;
						updated_flag = 1;
					}
				}
				// If item not exist
				if (updated_flag == 0) {
					ItemInCart item = new ItemInCart(product, 1);
					cart.items.add(item);
				}
				
			}

			userSelection = showMainMenuAndGetSelection();
		} while (userSelection <= menu.menuOptions.size() + menu.productsOptions.size());
		
	}

	public static User dologin() {
		User user = null;
		do {
			System.out.println("Please input userId: ");
			String userId = scanner.nextLine();
			System.out.println("Please input password: ");
			String password = scanner.nextLine();
			user = userService.getUserByUserIdAndPassword(userId, password);
			if (user == null) {
				System.out.println("Login Failed. Please Input Again");
			}
		} while (user == null);

		return user;
	}

	public static int showMainMenuAndGetSelection() {
		System.out.println("==============================");
		System.out.println("Main Menu");
		int i = 1;
		for (String menuOption : menu.menuOptions) {
			System.out.println(i + ". " + menuOption);
			i++;
		}

		for (Product product : menu.productsOptions) {
			System.out.println(i + ". " + product.name +   ": " + product.price + " AUD");
			i++;
		}
		System.out.println("==============================");

		System.out.println("Please select an option !!!");
		return scanner.nextInt();
	}
}
