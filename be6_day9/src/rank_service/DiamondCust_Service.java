package rank_service;

public class DiamondCust_Service extends Cust_Service {

	public DiamondCust_Service() {
		super.custRank = "Diamond";
		super.deliverDiscount = (float) 0.5;
		super.productDiscount = (float) 0.03;
	}

	@Override
	public float insertBenefit(float deliverFee, float productFee) {
		// Return total discount
		System.out.println("Rank Gold: ");
		System.out.println("- 50% Shipping = " + deliverFee * deliverDiscount);
		System.out.println("- 3% Product = " + productFee * productDiscount);

		
		float totalDiscount = deliverFee * (deliverDiscount) + productFee * productDiscount;
		return totalDiscount;
	}
}
