package dto;

import entity.Product;

public class ItemInCart {

	public Product product;
	public int quantity;

	public ItemInCart() {
		// TODO Auto-generated constructor stub
	}

	public ItemInCart(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

}
