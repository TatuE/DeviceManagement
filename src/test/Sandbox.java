package test;

import java.util.List;

import dao.Dao_Business_unit;
import model.Business_unit;

public class Sandbox {

	public static void main(String[] args) {
		
		//test
		/*Employee emp = new Employee();
		emp.setEmail("2test@test.com2");
		emp.setPhone("2786504012345672");
		emp.setFirst_name("John2");
		emp.setLast_name("Doe2");
		
		Dao_Employee dao = new Dao_Employee();
		if(dao.newEmployee(emp)) {
			System.out.println("toimii");
		} else {
			System.out.println("ei toimi");
		}
		
		Business_unit bu = new Business_unit();
		bu.setEmail("Yritys@yritys1111391");
		bu.setPhone("yritysnumero1111391");
		bu.setName("Iso yritys111391");
		bu.setStreet_address("Katu101391");
		bu.setSupervisor_id(8);
		
		
		Dao_Business_unit dao = new Dao_Business_unit();
		if(dao.newBusiness_unit(bu)) {
			System.out.println("toimii");
		}else {
			System.out.println("ei toimi");
		}
		
		
		
		String koe =null;
		Employee emp = new Employee();
		emp.setEmail(koe);
		System.out.println(emp.getEmail());
		
		
		Dao_Employee dao = new Dao_Employee();
		Employee emp = new Employee();		
		List<Employee> empkoe = dao.searchEmployee(emp);
		System.out.println(empkoe.size());
		
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		System.out.println(sqlDate);

		Dao dao = new Dao();
		System.out.println(dao.sqlCurrentDate());
		*/
		Business_unit bu = new Business_unit();
		Dao_Business_unit dao = new Dao_Business_unit();
		List<Business_unit> buList = dao.searchBusiness_unit(bu);
		System.out.println(buList);
		
		
		
	}

}
