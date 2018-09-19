package model;

public class Device_model {
	private int model_id, type_id, brand_id;
	private String model_name, model_number, brand_name, device_type;
	
	public Device_model() {
		super();
		
	}	

	public Device_model(int type_id, int brand_id, String model_name, String model_number) {
		super();
		this.type_id = type_id;
		this.brand_id = brand_id;
		this.model_name = model_name;
		this.model_number = model_number;
	}
	
	public Device_model(int model_id, int type_id, int brand_id, String model_name, String model_number,
			String brand_name, String device_type) {
		super();
		this.model_id = model_id;
		this.type_id = type_id;
		this.brand_id = brand_id;
		this.model_name = model_name;
		this.model_number = model_number;
		this.brand_name = brand_name;
		this.device_type = device_type;
	}

	public int getModel_id() {
		return model_id;
	}

	public void setModel_id(int model_id) {
		this.model_id = model_id;
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public int getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}

	public String getModel_name() {
		return model_name;
	}

	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}

	public String getModel_number() {
		return model_number;
	}

	public void setModel_number(String model_number) {
		this.model_number = model_number;
	}

	public String getBrand_name() {
		return brand_name;
	}

	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

	public String getDevice_type() {
		return device_type;
	}

	public void setDevice_type(String device_type) {
		this.device_type = device_type;
	}

	@Override
	public String toString() {
		return "Device_model [model_id=" + model_id + ", type_id=" + type_id + ", brand_id=" + brand_id
				+ ", model_name=" + model_name + ", model_number=" + model_number + ", brand_name=" + brand_name
				+ ", device_type=" + device_type + "]";
	}
}
