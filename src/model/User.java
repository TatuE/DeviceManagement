package model;

public class User {
	private int user_id;
	private String email, phone;
	private int in_use;
	
	public User() {
		super();		
	}	

	public User(String email, String phone) {
		super();
		this.email = email;
		this.phone = phone;
	}

	public User(int user_id, String email, String phone, int in_use) {
		super();
		this.user_id = user_id;
		this.email = email;
		this.phone = phone;
		this.in_use = in_use;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getIn_use() {
		return in_use;
	}

	public void setIn_use(int in_use) {
		this.in_use = in_use;
	}	
}