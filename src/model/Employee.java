package model;

public class Employee extends User {	
	private String first_name, last_name, business_unit;
	private int business_unit_id;
	
			
	public Employee() {
		super();
	}
	
	
	
	public Employee(String email, String phone, String first_name, String last_name, String business_unit, int business_unit_id) {
		super(email, phone);
		this.first_name = first_name;
		this.last_name = last_name;
		this.business_unit = business_unit;
		this.business_unit_id = business_unit_id;
	}



	public Employee(int user_id, String email, String phone, int in_use, String first_name, String last_name, int business_unit_id) {
		super(user_id, email, phone, in_use);
		this.first_name = first_name;
		this.last_name = last_name;
		this.business_unit_id = business_unit_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}	

	public String getBusiness_unit() {
		return business_unit;
	}

	public void setBusiness_unit(String business_unit) {
		this.business_unit = business_unit;
	}

	public int getBusiness_unit_id() {
		return business_unit_id;
	}

	public void setBusiness_unit_id(int business_unit_id) {
		this.business_unit_id = business_unit_id;
	}
	
	@Override
	public String toString() {
		return "Employee [user_id="+ super.getUser_id() +", first_name=" + this.first_name + ", last_name=" + this.last_name +", email="+super.getEmail() +", phone="+super.getPhone() +", business_unit_id="
				+ this.business_unit_id +", business_unit="+this.business_unit+", in_use="+ super.getIn_use() +"]";
	}	
}