package rank_service;

import dto.CustInfo;

public class SilverCust_Service extends Cust_Service {

	public SilverCust_Service() {
		super.custRank = "Silver";
		super.deliverDiscount = (float) 0.5;
		super.productDiscount = 0;
	}
	

	@Override
	public float insertBenefit(float deliverFee, float productFee) {
		// Return total discount
		System.out.println("Rank Silver: - 50% Shipping = " + deliverFee * deliverDiscount);
		
		float totalDiscount = deliverFee * (deliverDiscount) + productFee * productDiscount;
		return totalDiscount;
	}

}
