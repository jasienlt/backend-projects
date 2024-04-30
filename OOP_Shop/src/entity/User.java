package entity;

public class User {
	public String userId;
	public String password;
	public String name;
	public int shopId;
	public float userPoint;

	public User() {
		// TODO Auto-generated constructor stub
	}


	public User(String userId, String password, String name, int shopId) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.shopId = shopId;
		this.userPoint = (float) 0.00;
	}

	public User(String userId, String password, String name, int shopId, float userPoint) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.shopId = shopId;
		this.userPoint = userPoint;
	}

	
}
