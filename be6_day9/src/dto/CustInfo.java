package dto;

public class CustInfo {
	
	int custID;
	int custPassword;
	String custName;
	float custPoints;
	int custShop;
	
	public CustInfo(int custID, int custPassword, String custName, float custPoints, int custShop) {
		super();
		this.custID = custID;
		this.custPassword = custPassword;
		this.custName = custName;
		this.custPoints = custPoints;
		this.custShop = custShop;
	}
	

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public int getCustPassword() {
		return custPassword;
	}

	public void setCustPassword(int custPassword) {
		this.custPassword = custPassword;
	}
	
	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public float getCustPoints() {
		return custPoints;
	}

	public void setCustPoints(float custPoints) {
		this.custPoints = custPoints;
	}

	public int getCustShop() {
		return custShop;
	}

	public void setCustShop(int custShop) {
		this.custShop = custShop;
	}
	
	
}
