package dao;

import model.Business_unit;

public class Dao_Business_unit extends Dao {

	public Dao_Business_unit() {
		super();		
	}
	
	public boolean newBusiness_unit(Business_unit b_u) {
		boolean returnValue=true;
		
		sql="INSERT INTO DM_Users(Email,Phone,In_use) VALUES(?,?,?)";
		try {
			con=connect();
			prepStmt=con.prepareStatement(sql);
			prepStmt.setString(1, b_u.getEmail());
			prepStmt.setString(2, b_u.getPhone());
			prepStmt.setInt(3, 1);			
			prepStmt.executeQuery();
			con.close();
		} catch (Exception e) {
			return returnValue=false;			
		}
		if(b_u.getSupervisor_id()==0) {
			sql="INSERT INTO DM_Business_units VALUES (?,?,?,?,?)";
			try {
				con=connect();
				prepStmt=con.prepareStatement(sql);
				prepStmt.setString(1, "(SELECT User_id From DM_Users WHERE Email="+b_u.getEmail()+" AND Phone="+b_u.getPhone()+")");
				prepStmt.setString(2, b_u.getName());
				prepStmt.setString(3, b_u.getStreet_address());
				prepStmt.setInt(4, 1);
				// Supervisor =1 -> no assignet supervisor
				prepStmt.setString(5,b_u.getPostal_code());
				prepStmt.executeQuery();
				con.close();
			} catch (Exception e) {				
				return returnValue=false;				
			}			
		}else {
			sql="INSERT INTO DM_Business_units VALUES (?,?,?,?,?)";
			try {
				con=connect();
				prepStmt=con.prepareStatement(sql);
				prepStmt.setString(1, "(SELECT User_id From DM_Users WHERE Email="+b_u.getEmail()+" AND Phone="+b_u.getPhone()+")");
				prepStmt.setString(2, b_u.getName());
				prepStmt.setString(3, b_u.getStreet_address());
				prepStmt.setInt(4, b_u.getSupervisor_id());
				prepStmt.setString(5,b_u.getPostal_code());
				prepStmt.executeQuery();
				con.close();
			} catch (Exception e) {				
				return returnValue=false;				
			}
		}		
		return returnValue;
	}
	
	public boolean removeBusiness_unit(int user_id) {
		boolean returnValue = true;
		
		sql = "UPDATE TABLE DM_Users SET In_use = 0 WHERE User_Id=?";
		try {
			con=connect();
			prepStmt=con.prepareStatement(sql);
			prepStmt.setInt(1, user_id);
			prepStmt.executeQuery();
			con.close();			
		} catch (Exception e) {
			return returnValue=false;
		}
		return returnValue;
	}
	
	public boolean updateBusiness_unit(Business_unit b_u) {
		boolean returnValue = true;
		
		sql="UPDATE DM_Users SET Email=?, Phone=? WHERE User_id=? ";
		try {
			con=connect();
			prepStmt=con.prepareStatement(sql);
			prepStmt.setString(1, b_u.getEmail());
			prepStmt.setString(2, b_u.getPhone());
			prepStmt.setInt(3, b_u.getUser_id());			
			prepStmt.executeQuery();
			con.close();
		} catch (Exception e) {			
			return returnValue=false;			
		}
		
		if(b_u.getSupervisor_id()==0) {
			sql="UPDATE DM_Business_units SET Name=?, Street_address=?, Postal_code=? WHERE Business_unit_id=?";
			try {
				con=connect();
				prepStmt=con.prepareStatement(sql);
				prepStmt.setString(1, b_u.getName());
				prepStmt.setString(2, b_u.getStreet_address());
				prepStmt.setString(3, b_u.getPostal_address());
				prepStmt.setInt(4, b_u.getBusiness_unit_id());
				prepStmt.executeQuery();
				con.close();				
			} catch (Exception e) {
				return returnValue = false;
			}			
		}else {
			sql="UPDATE DM_Business_units SET Name=?, Street_address=?,Supervisor=? ,Postal_code=? WHERE Business_unit_id=?";
			try {
				con=connect();
				prepStmt=con.prepareStatement(sql);
				prepStmt.setString(1, b_u.getName());
				prepStmt.setString(2, b_u.getStreet_address());
				prepStmt.setInt(3, b_u.getSupervisor_id());
				prepStmt.setString(4, b_u.getPostal_address());
				prepStmt.setInt(5, b_u.getBusiness_unit_id());
				prepStmt.executeQuery();
				con.close();				
			} catch (Exception e) {
				return returnValue = false;
			}	
		}		
		return returnValue;
	}
	
	
	
	
	
	
	

}
