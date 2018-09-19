package dao;

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
				
			} catch (Exception e) {
				return returnValue=false;
			}
			
		}else {
			
		}
		
		
		
		return returnValue;
	}
	
	

}
