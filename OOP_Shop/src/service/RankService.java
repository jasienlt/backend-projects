package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import entity.Rank;
import entity.Shop;

public class RankService extends Service<Rank>{
	@Override
	public Rank getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rank save() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int getUserRank(float userPoints, Shop shop) {
		ArrayList<Rank> ranks = this.getAllByShop(shop);
		int result = -1;
		for (Rank rank:ranks) {
			if (userPoints >= rank.lowPoint && userPoints < rank.highPoint) {
				System.out.println("User Rank: " + rank.rankName);
				System.out.println("Current Points: " + userPoints);
				result = rank.rankId;
			}
		}
		return result;
	}

	@Override
	public ArrayList<Rank> getAllByShop(Shop shop) {
		ArrayList<Rank> datas = null;
		try {
			datas = new ArrayList<Rank>();
			File myObj = new File("resource/shop" + shop.id + "/rank.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] splitDatas = data.split(",");
				datas.add(new Rank(Integer.parseInt(splitDatas[0]), 
						splitDatas[1], 
						Float.parseFloat(splitDatas[2]),
						Float.parseFloat(splitDatas[3])));
			}
			myReader.close();
			return datas;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return datas;
	}
}
