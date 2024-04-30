package dto;

import java.util.ArrayList;

import entity.Product;
import entity.Shipping;
import entity.Shop;
import entity.Voucher;
import service.ProductService;
import service.ShippingService;
import service.VoucherService;

public class Menu {

	public ArrayList<String> menuOptions = new ArrayList<String>();
	public ArrayList<Product> productsOptions = new ArrayList<Product>();
	public ArrayList<Shipping> shippingOptions = new ArrayList<Shipping>();
	public ArrayList<Voucher> voucherOptions = new ArrayList<Voucher>();


	public Menu(Shop shop) {
		this.menuOptions.add("View Cart");

		if (shop.hasUserRank) {
			this.menuOptions.add("View Rank");
		}

		ProductService productService = new ProductService();
		this.productsOptions = productService.getAllByShop(shop);

		if (shop.hasShippingMethods) {
			ShippingService shippingService = new ShippingService();
			this.shippingOptions = shippingService.getAllByShop(shop);
		}
		
		VoucherService voucherService = new VoucherService();
		this.voucherOptions = voucherService.getAllByShop(shop);

		
	}

}
