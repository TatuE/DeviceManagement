package dao;

import java.util.ArrayList;
import java.util.List;

import model.Device;

public class Dao_Device extends Dao {

	public Dao_Device() {
		super();
		
	}
	
	public boolean newDevice(Device device) {
		boolean returnValue=true;
		
		if(device.getAcquisition_date()==null) {
			sql="INSERT INTO DM_Devices(Model_id) VALUES(?)";
			try {
				con=connect();
				prepStmt=con.prepareStatement(sql);
				prepStmt.setInt(1, device.getModel_id());
				prepStmt.executeQuery();
				con.close();				
			} catch (Exception e) {
				return returnValue=false;
			}			
		}else {
			sql="INSERT INTO DM_Devices(Model_id, Acquisition_date) VALUES (?,?)";
			try {
				con=connect();
				prepStmt=con.prepareStatement(sql);
				prepStmt.setInt(1, device.getModel_id());
				prepStmt.setDate(2, device.getAcquisition_date());
				prepStmt.executeQuery();
				con.close();				
			} catch (Exception e) {
				return returnValue=false;
			}
		}
		
		List<Integer> devices = getDevice(device.getModel_id());
		int device_id = devices.get(devices.size()-1);
		device.setDevice_id(device_id);
		
		return returnValue;
		// List devices = getDevice(device);
		// device = devices.get(devices.size()-1);
		// Dao_device_info dao = new Dao_device_info();
		// add date!!
		// dao.newInfo()
	}
	
	public boolean removeDevice(int device_id) {
		boolean returnValue=true;		
		
		sql="UPDATE DM_Devices SET Retirement=? WHERE Device_id=?";		
		try {
			con=connect();
			prepStmt=con.prepareStatement(sql);
			prepStmt.setDate(1, sqlCurrentDate());
			prepStmt.setInt(2, device_id);
			prepStmt.executeQuery();
			con.close();			
		} catch (Exception e) {
			return returnValue=false;
		}		
		return returnValue;		
	}
	
	public boolean updateDevice(Device device) {
		boolean returnValue = true;
		
		sql="UPDATE DM_Devices SET Model_id=?, Acquisition_date=? WHERE Device_id=?";
		try {
			con=connect();
			prepStmt.setInt(1, device.getModel_id());
			prepStmt.setDate(2, device.getAcquisition_date());
			prepStmt.executeQuery();
			con.close();			
		} catch (Exception e) {
			return returnValue=false;
		}		
		return returnValue;		
	}
	
	private List<Integer> getDevice(int model_id){
		List<Integer> deviceList = new ArrayList<>();
		
		sql="SELECT Device_id FROM DM_Devices WHERE Model_id=?";
		try {
			con=connect();
			if(con!=null) {
				prepStmt=con.prepareStatement(sql);
				prepStmt.setInt(1, model_id);
				rs=prepStmt.executeQuery();
				if(rs!=null) {
					con.close();
					while(rs.next()) {
						deviceList.add(rs.getInt("Device_id"));						
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return deviceList;
	}
	
	public List<Device> searchDevice(Device device){
		List<Device> deviceList = new ArrayList<>();
		
		
		
		return deviceList;
		
	}
	

}
