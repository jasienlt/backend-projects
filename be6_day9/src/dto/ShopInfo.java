package dto;

public class ShopInfo {
	String shopName;
	int shopID;
	float voucherDiscount;
	
	public ShopInfo(String shopName, int shopID, float voucherDiscount) {
		super();
		this.shopName = shopName;
		this.shopID = shopID;
		this.voucherDiscount = voucherDiscount;
	}
	
	public void welcomeMessage() {
		System.out.println("Welcome to "+ shopName);
	}

}
