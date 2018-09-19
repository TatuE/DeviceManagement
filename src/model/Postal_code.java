package model;

public class Postal_code {
	private String postal_code, postal_address;

	public Postal_code() {
		super();		
	}

	public Postal_code(String postal_code, String postal_address) {
		super();
		this.postal_code = postal_code;
		this.postal_address = postal_address;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public String getPostal_address() {
		return postal_address;
	}

	public void setPostal_address(String postal_address) {
		this.postal_address = postal_address;
	}

	@Override
	public String toString() {
		return "Postal_code [postal_code=" + postal_code + ", postal_address=" + postal_address + "]";
	}
}
