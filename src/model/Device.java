package model;

import java.sql.Date;

public class Device {
	private int device_id, model_id;
	private String model_name, model_number, brand_name, device_type, features, device_info;	
	private Date acquisition_date, retirement;
	
	public Device() {
		super();
		
	}

	public Device(int model_id, String model_number, Date acquisition_date, String device_info) {
		super();
		this.model_id = model_id;
		this.model_number = model_number;		
		this.acquisition_date = acquisition_date;
		this.device_info = device_info;
	}

	public Device(int device_id, int model_id, String model_name, String model_number, String brand_name,
			String device_type, String features, Date acquisition_date, String device_features, String device_info) {
		super();
		this.device_id = device_id;
		this.model_id = model_id;
		this.model_name = model_name;
		this.model_number = model_number;
		this.brand_name = brand_name;
		this.device_type = device_type;
		this.features = features;		
		this.acquisition_date = acquisition_date;
		this.device_info = device_info;
	}

	public int getDevice_id() {
		return device_id;
	}

	public void setDevice_id(int device_id) {
		this.device_id = device_id;
	}

	public int getModel_id() {
		return model_id;
	}

	public void setModel_id(int model_id) {
		this.model_id = model_id;
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

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public String getDevice_info() {
		return device_info;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	public Date getAcquisition_date() {
		return acquisition_date;
	}

	public void setAcquisition_date(Date acquisition_date) {
		this.acquisition_date = acquisition_date;
	}

	public Date getRetirement() {
		return retirement;
	}

	public void setRetirement(Date retirement) {
		this.retirement = retirement;
	}

	@Override
	public String toString() {
		return "Device [device_id=" + device_id + ", model_id=" + model_id + ", model_name=" + model_name
				+ ", model_number=" + model_number + ", brand_name=" + brand_name + ", device_type=" + device_type
				+ ", features=" + features + ", device_info=" + device_info + ", acquisition_date=" + acquisition_date
				+ ", retirement=" + retirement + "]";
	}	
}
