package entity;

public class Shop {

	public int id;
	public String name;
	public boolean hasUserRank;
	public boolean hasShippingMethods;
	public int defaultShipFee;

	public Shop() {
		// TODO Auto-generated constructor stub
	}

	public Shop(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Shop(int id, String name, boolean hasUserRank, boolean hasShippingMethods, int defaultShipFee) {
		super();
		this.id = id;
		this.name = name;
		this.hasUserRank = hasUserRank;
		this.hasShippingMethods = hasShippingMethods;
		this.defaultShipFee = defaultShipFee;
	}
	
	

}
