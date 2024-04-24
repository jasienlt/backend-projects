package rank_service;

import dto.CustInfo;

public class GoldCust_Service extends Cust_Service {
	
	public GoldCust_Service() {
		super.custRank = "Gold";
		super.deliverDiscount = (float) 0.5;
		super.productDiscount = (float) 0.02; 
	}

	
	@Override
	public float insertBenefit(float deliverFee, float productFee) {
		// Return total discount
		System.out.println("Rank Gold: ");
		System.out.println("- 50% Shipping = " + deliverFee * deliverDiscount);
		System.out.println("- 2% Product = " + productFee * productDiscount);

		
		float totalDiscount = deliverFee * (deliverDiscount) + productFee * productDiscount;
		return totalDiscount;
	}


}
