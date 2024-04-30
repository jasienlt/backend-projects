package entity;

public class Shipping {
	public int shipID;
	public String shipType;
	public float shipPrice;
	public int shipDays;
	
	public Shipping(int shipID,String shipType, float shipPrice, int shipDays) {
		super();
		this.shipID = shipID;
		this.shipType = shipType;
		this.shipPrice = shipPrice;
		this.shipDays = shipDays;
	}
	
	
}
