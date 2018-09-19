package model;

import java.sql.Date;

public class Device_maintenance {
	private int maintenance_row_id, maintenance_id, device_id;
	private Date maintenance_date;
	private String maintenance_info;
	
	public Device_maintenance() {
		super();
		
	}
	
	public Device_maintenance(int device_id, Date maintenance_date, String maintenance_info) {
		super();
		this.device_id = device_id;
		this.maintenance_date = maintenance_date;
		this.maintenance_info = maintenance_info;
	}
	
	public Device_maintenance(int maintenance_row_id, int maintenance_id, int device_id, Date maintenance_date,
			String maintenance_info) {
		super();
		this.maintenance_row_id = maintenance_row_id;
		this.maintenance_id = maintenance_id;
		this.device_id = device_id;
		this.maintenance_date = maintenance_date;
		this.maintenance_info = maintenance_info;
	}

	public int getMaintenance_row_id() {
		return maintenance_row_id;
	}

	public void setMaintenance_row_id(int maintenance_row_id) {
		this.maintenance_row_id = maintenance_row_id;
	}

	public int getMaintenance_id() {
		return maintenance_id;
	}

	public void setMaintenance_id(int maintenance_id) {
		this.maintenance_id = maintenance_id;
	}

	public int getDevice_id() {
		return device_id;
	}

	public void setDevice_id(int device_id) {
		this.device_id = device_id;
	}

	public Date getMaintenance_date() {
		return maintenance_date;
	}

	public void setMaintenance_date(Date maintenance_date) {
		this.maintenance_date = maintenance_date;
	}

	public String getMaintenance_info() {
		return maintenance_info;
	}

	public void setMaintenance_info(String maintenance_info) {
		this.maintenance_info = maintenance_info;
	}

	@Override
	public String toString() {
		return "Device_maintenance [maintenance_row_id=" + maintenance_row_id + ", maintenance_id=" + maintenance_id
				+ ", device_id=" + device_id + ", maintenance_date=" + maintenance_date + ", maintenance_info="
				+ maintenance_info + "]";
	}
}
