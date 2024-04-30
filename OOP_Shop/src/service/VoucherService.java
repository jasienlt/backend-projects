package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import entity.Shop;
import entity.Voucher;

public class VoucherService extends Service<Voucher>{
	@Override
	public Voucher getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Voucher save() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Voucher> getAllByShop(Shop shop) {
		ArrayList<Voucher> datas = null;
		try {
			datas = new ArrayList<Voucher>();
			File myObj = new File("resource/shop" + shop.id + "/voucher.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] splitDatas = data.split(",");
				datas.add(new Voucher(
						splitDatas[0],
						Float.parseFloat(splitDatas[1]),
						Boolean.parseBoolean(splitDatas[2]),
						Boolean.parseBoolean(splitDatas[3]),
						Integer.parseInt(splitDatas[4]),
						Float.parseFloat(splitDatas[5])));
			}
			
			
			myReader.close();
			return datas;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return datas;
	}
	
	
	public ArrayList<Voucher> bestVoucher(ArrayList<Voucher> vouchers, float totalPaid, int userRank) {
		float maxItemDiscount = 0F;
		float maxShippingDiscount = 0F;
		Voucher bestItem = null;
		Voucher bestShipping = null;

		ArrayList<Voucher> bestVoucher = new ArrayList<Voucher>();
		
		// If shop doesnt have rank
		if (userRank == 0) {
			for (Voucher voucher:vouchers) {
				if (voucher.isItemVoucher && voucher.voucherMinSpent <= totalPaid) {
					if(voucher.voucherDiscount > maxItemDiscount) {
						maxItemDiscount = voucher.voucherDiscount;
						bestItem = voucher;
					}
				}
				else if (voucher.isShippingVoucher && voucher.voucherMinSpent <= totalPaid) {
					if(voucher.voucherDiscount > maxShippingDiscount) {
						maxShippingDiscount = voucher.voucherDiscount;
						bestShipping = voucher;
					}
				}
			}
		}
		
		// If shop does have rank -> only include vouchers eligible for ranks
		else {
			for (Voucher voucher:vouchers) {
				if (voucher.isItemVoucher && voucher.voucherMinSpent <= totalPaid && voucher.voucherRank <= userRank) {
					if(voucher.voucherDiscount > maxItemDiscount) {
						maxItemDiscount = voucher.voucherDiscount;
						bestItem = voucher;
					}
				}
				else if (voucher.isShippingVoucher && voucher.voucherMinSpent <= totalPaid && voucher.voucherRank <= userRank) {
					if(voucher.voucherDiscount > maxShippingDiscount) {
						maxShippingDiscount = voucher.voucherDiscount;
						bestShipping = voucher;
					}
				}
			}
			
		}
		
		bestVoucher.add(bestItem);
		bestVoucher.add(bestShipping);
		
		return bestVoucher;
	}
	
	public float printVoucher(ArrayList<Voucher> vouchers) {
		if (vouchers.size() > 0) {
			float totalCredit = 0;
			for (Voucher amount:vouchers) {
				if (amount.isItemVoucher) {
					System.out.println("ITEM VOUCHER: "+amount.voucherId+": "+amount.voucherDiscount+" AUD");
				} else if (amount.isShippingVoucher) {
					System.out.println("SHIPPING VOUCHER "+amount.voucherId+": "+amount.voucherDiscount+" AUD");

				}
				totalCredit += amount.voucherDiscount;	
			}
			return totalCredit;
		}
		return 0;
	}

	
}
