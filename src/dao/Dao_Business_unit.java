package dao;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<Business_unit> searchBusiness_unit(Business_unit b_u){
		List<Business_unit>b_uList = new ArrayList<>();
		if(b_u.getName()==null && b_u.getStreet_address()==null && b_u.getSupervisor()==null && b_u.getPostal_code()==null && b_u.getPostal_address()==null) {
			sql="SELECT u.User_id, u.Email, u.Phone, b.Name, b.Street_address, b.Supervisor, CONCAT(e.First_name,' ',e.Last_name) AS Supervisor_name, b.Postal_code, p.Postal_address "
					+ "FROM DM_Users AS u CROSS JOIN DM_Business_units AS b ON u.User_id=b.Business_unit_id CROSS JOIN DM_Postal_codes AS p ON b.Postal_code=p.Postal_code CROSS JOIN DM_Employees AS e ON b.Supervisor=e.Employee_id "
					+ "WHERE In_use=1";
			try {
				con=connect();
				if(con!=null) {
					prepStmt=con.prepareStatement(sql);
					rs=prepStmt.executeQuery();
					if(rs!=null) {
						con.close();
						while(rs.next()) {
							Business_unit bu = new Business_unit();
							bu.setUser_id(rs.getInt("u.User_id"));
							bu.setEmail(rs.getString("u.Email"));
							bu.setPhone(rs.getString("u.Phone"));
							bu.setName(rs.getString("b.Name"));
							bu.setStreet_address(rs.getString("b.Street_address"));
							bu.setSupervisor_id(rs.getInt("b.Supervisor"));
							bu.setSupervisor(rs.getString("Supervisor_name"));
							bu.setPostal_code(rs.getString("b.Postal_code"));
							bu.setPostal_address(rs.getString("p.Postal_address"));
							b_uList.add(bu);
						}
					}
				}				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			sql="SELECT u.User_id, u.Email, u.Phone, b.Name, b.Street_address, b.Supervisor, CONCAT(e.First_name,' ',e.Last_name) AS Supervisor_name, b.Postal_code, p.Postal_address "
					+ "FROM DM_Users AS u CROSS JOIN DM_Business_units AS b ON u.User_id=b.Business_unit_id CROSS JOIN DM_Postal_codes AS p ON b.Postal_code=p.Postal_code CROSS JOIN DM_Employees AS e ON b.Supervisor=e.Employee_id "
					+ "WHERE In_use=1 AND u.Email LIKE ? AND u.Phone LIKE ? AND b.Name LIKE ? AND b.Street_address LIKE ? AND Supervisor_name LIKE ? AND b.Postal_code LIKE ? AND p.Postal_address LIKE ?";
			try {
				con=connect();
				if(con!=null) {
					prepStmt=con.prepareStatement(sql);
					prepStmt.setString(1,"%"+b_u.getEmail()+"%");
					prepStmt.setString(2,"%"+b_u.getPhone()+"%");
					prepStmt.setString(3,"%"+b_u.getName()+"%");
					prepStmt.setString(4,"%"+b_u.getStreet_address()+"%");
					prepStmt.setString(5,"%"+b_u.getSupervisor()+"%");
					prepStmt.setString(6, "%"+b_u.getPostal_code()+"%");
					prepStmt.setString(7,"%"+b_u.getPostal_address()+"%");
					rs=prepStmt.executeQuery();
					if(rs!=null) {
						con.close();
						Business_unit bu = new Business_unit();
						bu.setUser_id(rs.getInt("u.User_id"));
						bu.setEmail(rs.getString("u.Email"));
						bu.setPhone(rs.getString("u.Phone"));
						bu.setName(rs.getString("b.Name"));
						bu.setStreet_address(rs.getString("b.Street_address"));
						bu.setSupervisor_id(rs.getInt("b.Supervisor"));
						bu.setSupervisor(rs.getString("Supervisor_name"));
						bu.setPostal_code(rs.getString("b.Postal_code"));
						bu.setPostal_address(rs.getString("p.Postal_address"));
						b_uList.add(bu);						
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
		return b_uList;
	}
}
