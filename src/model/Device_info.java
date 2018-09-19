package model;

import java.sql.Date;

public class Device_info {
	private int device_info_row_id, device_id, device_info_id;
	private Date indert_date;
	private String info;
	
	public Device_info() {
		super();		
	}	

	public Device_info(int device_id, Date indert_date, String info) {
		super();
		this.device_id = device_id;
		this.indert_date = indert_date;
		this.info = info;
	}

	public Device_info(int device_info_row_id, int device_id, int device_info_id, Date indert_date, String info) {
		super();
		this.device_info_row_id = device_info_row_id;
		this.device_id = device_id;
		this.device_info_id = device_info_id;
		this.indert_date = indert_date;
		this.info = info;
	}

	public int getDevice_info_row_id() {
		return device_info_row_id;
	}

	public void setDevice_info_row_id(int device_info_row_id) {
		this.device_info_row_id = device_info_row_id;
	}

	public int getDevice_id() {
		return device_id;
	}

	public void setDevice_id(int device_id) {
		this.device_id = device_id;
	}

	public int getDevice_info_id() {
		return device_info_id;
	}

	public void setDevice_info_id(int device_info_id) {
		this.device_info_id = device_info_id;
	}

	public Date getIndert_date() {
		return indert_date;
	}

	public void setIndert_date(Date indert_date) {
		this.indert_date = indert_date;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "Device_info [device_info_row_id=" + device_info_row_id + ", device_id=" + device_id
				+ ", device_info_id=" + device_info_id + ", indert_date=" + indert_date + ", info=" + info + "]";
	}	
}
