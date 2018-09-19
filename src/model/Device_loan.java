package model;

import java.sql.Date;

public class Device_loan {
	private int device_row_id, user_id, device_id, loan_id;
	private Date loan_date, return_date;
	
	public Device_loan() {
		super();		
	}

	public Device_loan(int user_id, int device_id, Date loan_date) {
		super();
		this.user_id = user_id;
		this.device_id = device_id;
		this.loan_date = loan_date;
	}

	public Device_loan(int device_row_id, int user_id, int device_id, int loan_id, Date loan_date, Date return_date) {
		super();
		this.device_row_id = device_row_id;
		this.user_id = user_id;
		this.device_id = device_id;
		this.loan_id = loan_id;
		this.loan_date = loan_date;
		this.return_date = return_date;
	}

	public int getDevice_row_id() {
		return device_row_id;
	}

	public void setDevice_row_id(int device_row_id) {
		this.device_row_id = device_row_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getDevice_id() {
		return device_id;
	}

	public void setDevice_id(int device_id) {
		this.device_id = device_id;
	}

	public int getLoan_id() {
		return loan_id;
	}

	public void setLoan_id(int loan_id) {
		this.loan_id = loan_id;
	}

	public Date getLoan_date() {
		return loan_date;
	}

	public void setLoan_date(Date loan_date) {
		this.loan_date = loan_date;
	}

	public Date getReturn_date() {
		return return_date;
	}

	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}

	@Override
	public String toString() {
		return "Device_loan [device_row_id=" + device_row_id + ", user_id=" + user_id + ", device_id=" + device_id
				+ ", loan_id=" + loan_id + ", loan_date=" + loan_date + ", return_date=" + return_date + "]";
	}
}
