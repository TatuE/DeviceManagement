package model;

public class Business_unit extends User {
	private int business_unit_id;
	private String name, street_address, supervisor;
	private int supervisor_id;
	private String postal_code, postal_address;
	
	public Business_unit() {
		super();		
	}	

	public Business_unit(String email, String phone, String name, String street_address, String supervisor, int supervisor_id, String postal_code) {
		super(email, phone);
		this.name = name;
		this.street_address = street_address;
		this.supervisor = supervisor;
		this.supervisor_id = supervisor_id;
		this.postal_code = postal_code;
	}

	public Business_unit(int user_id, String email, String phone, int in_use, int business_unit_id, String name, String street_address, int supervisor_id, String postal_code, String postal_address) {
		super(user_id, email, phone, in_use);
		this.business_unit_id = business_unit_id;
		this.name = name;
		this.street_address = street_address;
		this.supervisor_id = supervisor_id;
		this.postal_code = postal_code;
		this.postal_address = postal_address;
	}

	public int getBusiness_unit_id() {
		return business_unit_id;
	}

	public void setBusiness_unit_id(int business_unit_id) {
		this.business_unit_id = business_unit_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet_address() {
		return street_address;
	}

	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}

	public int getSupervisor_id() {
		return supervisor_id;
	}

	public void setSupervisor_id(int supervisor_id) {
		this.supervisor_id = supervisor_id;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}	

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}	

	public String getPostal_address() {
		return postal_address;
	}

	public void setPostal_address(String postal_address) {
		this.postal_address = postal_address;
	}

	@Override
	public String toString() {
		return "Business_unit [user_id="+ super.getUser_id() +", business_unit_id=" + this.business_unit_id + ", name=" + this.name + ", street_address="
				+ this.street_address +", email="+super.getEmail() +", phone="+super.getPhone() +", supervisor_id=" + this.supervisor_id + ", postal_code=" + this.postal_code + ", in_use="+ super.getIn_use() +"]";
	}
}