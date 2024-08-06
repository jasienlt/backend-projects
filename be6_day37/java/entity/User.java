package entity;

public class User {
	String username;
	String password;
	String gender;
	String hobbies;
	String city;
	
	public User(String username, String password, String gender, String hobbies, String city) {
		super();
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.hobbies = hobbies;
		this.city = city;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
}