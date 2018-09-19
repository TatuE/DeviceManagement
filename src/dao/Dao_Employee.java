package dao;

import java.util.ArrayList;
import java.util.List;

import model.Employee;

public class Dao_Employee extends Dao{

	public Dao_Employee() {
		super();
	}
	
	public boolean newEmployee(Employee employee) {
		boolean returnValue = true;;
		
		sql="INSERT INTO DM_Users(Email,Phone,In_use) VALUES(?,?,?)";
		try {
			con=connect();
			prepStmt=con.prepareStatement(sql);
			prepStmt.setString(1, employee.getEmail());
			prepStmt.setString(2, employee.getPhone());
			prepStmt.setInt(3, 1);			
			prepStmt.executeQuery();
			con.close();
		} catch (Exception e) {			
			return returnValue=false;			
		}
		if(employee.getBusiness_unit_id()==0) {
			sql ="INSERT INTO DM_Employees VALUES(?,?,?,?)";
			try {
				con=connect();
				prepStmt=con.prepareStatement(sql);
				prepStmt.setString(1, "(SELECT User_id From DM_Users WHERE Email="+employee.getEmail()+" AND Phone="+employee.getPhone()+")");
				prepStmt.setString(2, employee.getFirst_name());
				prepStmt.setString(3, employee.getLast_name());
				prepStmt.setInt(4, 1);
				// Business_unit_id = 1 -> no assignet business unit
				prepStmt.executeQuery();
				con.close();			
			} catch (Exception e) {				
				return returnValue=false;			
			}
		}else {
			sql ="INSERT INTO DM_Employees VALUES(?,?,?,?)";
			try {
				con=connect();
				prepStmt=con.prepareStatement(sql);
				prepStmt.setString(1, "(SELECT User_id From DM_Users WHERE Email="+employee.getEmail()+" AND Phone="+employee.getPhone()+")");
				prepStmt.setString(2, employee.getFirst_name());
				prepStmt.setString(3, employee.getLast_name());
				prepStmt.setInt(4, employee.getBusiness_unit_id());
				prepStmt.executeQuery();
				con.close();			
			} catch (Exception e) {				
				return returnValue=false;			
			}
		}		
		return returnValue;	
	}
	
	public boolean removeEmployee(int user_id) {
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
	
	public boolean updateEmployee(Employee employee) {
		boolean returnValue = true;
		
		sql="UPDATE DM_Users SET Email=?, Phone=? WHERE User_id=? ";
		try {
			con=connect();
			prepStmt=con.prepareStatement(sql);
			prepStmt.setString(1, employee.getEmail());
			prepStmt.setString(2, employee.getPhone());
			prepStmt.setInt(3, employee.getUser_id());			
			prepStmt.executeQuery();
			con.close();
		} catch (Exception e) {			
			return returnValue=false;			
		}
		if(employee.getBusiness_unit_id()==0) {
			sql ="UPDATE DM_Employees SET First_name=?, Last_name=? WHERE Employee_id=?";
			try {
				con=connect();
				prepStmt=con.prepareStatement(sql);
				prepStmt.setString(1, employee.getFirst_name());
				prepStmt.setString(2, employee.getLast_name());
				prepStmt.setInt(3, employee.getUser_id());			
				prepStmt.executeQuery();
				con.close();			
			} catch (Exception e) {
				System.out.println("DC_Employee1_update");
				return returnValue=false;			
			}
		}else {
			sql ="UPDATE DM_Employees SET First_name=?, Last_name=?, Business_unit_id=? WHERE Employee_id=?";
			try {
				con=connect();
				prepStmt=con.prepareStatement(sql);
				prepStmt.setString(1, employee.getFirst_name());
				prepStmt.setString(2, employee.getLast_name());
				prepStmt.setInt(3, employee.getBusiness_unit_id());
				prepStmt.setInt(4, employee.getUser_id());
				prepStmt.executeQuery();
				con.close();			
			} catch (Exception e) {
				System.out.println("DC_Employee2_update");
				return returnValue=false;			
			}
		}		
		return returnValue;	
	}
	
	public List<Employee> searchEmployee(Employee employee){
		List<Employee> employeeList = new ArrayList<>();
		if(employee.getFirst_name()==null&&employee.getLast_name()==null&&employee.getBusiness_unit()==null&&employee.getEmail()==null&&employee.getPhone()==null) {
			sql="SELECT u.User_id, u.Email, u.Phone, e.First_name, e.Last_name, e.Business_unit_id, b.Name "
					+ "FROM DM_Users as u CROSS JOIN DM_Employees AS e ON u.User_id=e.Employee_id CROSS JOIN DM_Business_units AS b on e.Business_unit_id=b.Business_unit_id "
					+ "WHERE u.In_use=1";
			try {
				con=connect();
				if(con!=null) {
					prepStmt=con.prepareStatement(sql);
					rs=prepStmt.executeQuery();
					if(rs!=null) {
						con.close();
						while(rs.next()) {
							Employee emp = new Employee();
							emp.setUser_id(rs.getInt("u.User_id"));
							emp.setEmail(rs.getString("u.Email"));
							emp.setPhone(rs.getString("u.Phone"));
							emp.setFirst_name(rs.getString("e.First_name"));
							emp.setLast_name(rs.getString("e.Last_name"));
							emp.setBusiness_unit_id(rs.getInt("e.Business_unit_id"));
							emp.setBusiness_unit(rs.getString("b.Name"));
							employeeList.add(emp);	
						}						
					}
				}			
			} catch (Exception e) {
				System.out.println("virhe");
				e.printStackTrace();
			}						
		}else {
			sql="SELECT u.User_id, u.Email, u.Phone, e.First_name, e.Last_name, e.Business_unit_id, b.Name "
					+ "FROM DM_Users as u CROSS JOIN DM_Employees AS e ON u.User_id=e.Employee_id CROSS JOIN DM_Business_units AS b on e.Business_unit_id=b.Business_unit_id "
					+ "WHERE u.In_use=1 AND u.Email Like ? AND u.Phone LIKE ? AND e.First_name LIKE ? AND e.Last_Name LIKE ? AND b.Name LIKE ?";
			try {
				con=connect();
				if(con!=null) {
					prepStmt=con.prepareStatement(sql);
					prepStmt.setString(1, "%"+employee.getEmail()+"%");
					prepStmt.setString(2, "%"+employee.getPhone()+"%");
					prepStmt.setString(3, "%"+employee.getFirst_name()+"%");
					prepStmt.setString(4, "%"+employee.getLast_name()+"%");
					prepStmt.setString(5, "%"+employee.getBusiness_unit()+"%");				
					rs=prepStmt.executeQuery();
					if(rs!=null) {
						Employee emp = new Employee();
						emp.setUser_id(rs.getInt("User_id"));
						emp.setEmail(rs.getString("Email"));
						emp.setPhone(rs.getString("Phone"));
						emp.setFirst_name(rs.getString("First_name"));
						emp.setLast_name(rs.getString("Last_name"));
						emp.setBusiness_unit_id(rs.getInt("Business_unit_id"));
						emp.setBusiness_unit(rs.getString("Name"));
						employeeList.add(emp);
					}
				}
			con.close();
			} catch (Exception e) {
				System.out.println("virhe2");
				e.printStackTrace();
			}			
		}		
		return employeeList;		
	}
}
