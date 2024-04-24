package rank_service;

import dto.CustInfo;

public abstract class Cust_Service {
	public String custRank;
	public float deliverDiscount;
	public float productDiscount;
	
	public void viewRank(CustInfo regCust) {
		System.out.println("Customer Name = " + regCust.getCustName());
		System.out.println("Point Balance = " + regCust.getCustPoints());
		System.out.println("Customer Rank = " + custRank);
	}
		
	public abstract float insertBenefit(float deliverFee, float productFee);
	
	public float updateCustPoints(CustInfo regCust,float paidAmount) {
		return regCust.getCustPoints() + paidAmount * 10;
	}
	
	public static Cust_Service classifyRank(float custPoints) {
		if (custPoints < 1000) {
			return new SilverCust_Service();
		} else if (custPoints >= 1000 && custPoints <= 5000) {
			return new GoldCust_Service();
		} else {
			return new DiamondCust_Service();
		}
	}
	
	
}
