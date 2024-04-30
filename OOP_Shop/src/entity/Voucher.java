package entity;

public class Voucher {
	
	public String voucherId;
	public float voucherDiscount;
	public boolean isItemVoucher;
	public boolean isShippingVoucher;
	public int voucherRank;
	public float voucherMinSpent;
	
	
	// For vouchers regardless of rank
	public Voucher(String voucherId, float voucherDiscount, boolean isItemVoucher,
			boolean isShippingVoucher) {
		super();
		this.voucherId = voucherId;
		this.voucherDiscount = voucherDiscount;
		this.isItemVoucher = isItemVoucher;
		this.isShippingVoucher = isShippingVoucher;
		this.voucherRank = 0;
		this.voucherMinSpent = (float) 0.00;
	}


	// For rank-specific vouchers
	public Voucher(String voucherId, float voucherDiscount, boolean isItemVoucher,
			boolean isShippingVoucher, int voucherRank, float voucherMinSpent) {
		super();
		this.voucherId = voucherId;
		this.voucherDiscount = voucherDiscount;
		this.isItemVoucher = isItemVoucher;
		this.isShippingVoucher = isShippingVoucher;
		this.voucherRank = voucherRank;
		this.voucherMinSpent = voucherMinSpent;
	}
	
	

}
