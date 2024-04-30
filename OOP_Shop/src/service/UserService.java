package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import entity.User;

public class UserService extends Service<User> {

	public User getUserByUserIdAndPassword(String userId, String password) {
		ArrayList<User> users = this.getAll();
		for (User user : users) {
			if (user.userId.equals(userId) && user.password.equals(password)) {
				return user;
			}
		}
		return null;
	}
	
	public float updateCustPoints(User regUser,float paidAmount) {
		return paidAmount < 0 ? regUser.userPoint : regUser.userPoint + paidAmount;

	}

	@Override
	public ArrayList<User> getAll() {
		ArrayList<User> users = null;
		try {
			users = new ArrayList<User>();
			File myObj = new File("resource/users.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] splitDatas = data.split(",");
				users.add(new User(splitDatas[0], 
						splitDatas[1], 
						splitDatas[2], 
						Integer.parseInt(splitDatas[3]),
						Float.parseFloat(splitDatas[4])));
			}
			myReader.close();
			return users;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public void updateCustFile(ArrayList<User> userList) {
		// TODO Auto-generated method stub		
		
		FileWriter writer;
		try {			
			writer = new FileWriter("be.txt");
			for (User newCust:userList) {
				writer.write(newCust.userId
						+ ',' + newCust.password
						+ ',' + newCust.name
						+ ',' + newCust.shopId
						+ ',' + newCust.userPoint
						+System.lineSeparator());
			}
			writer.flush();
			writer.close();
			System.out.println("Customers updated!");

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public User save() {
		// TODO Auto-generated method stub
		return null;
	}

}
