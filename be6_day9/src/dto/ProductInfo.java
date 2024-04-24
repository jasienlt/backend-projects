package dto;

public class ProductInfo {
	int productNo;
	String productName;
	float productPrice;
	
	public ProductInfo(int productNo, String productName, float productPrice) {
		super();
		this.productNo = productNo;
		this.productName = productName;
		this.productPrice = productPrice;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	
	

}
