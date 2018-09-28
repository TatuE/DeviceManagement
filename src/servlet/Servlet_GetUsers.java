package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao_Business_unit;
import dao.Dao_Employee;


@WebServlet("/Servlet_GetUsers")
public class Servlet_GetUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Servlet_GetUsers() {
        super();
        System.out.println("Servlet_GetUsers.Servlet_GetUsers()");
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_GetUsers.doGet()");
		Dao_Employee dao_e = new Dao_Employee();
		Dao_Business_unit dao_b = new Dao_Business_unit();
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_GetUsers.doPost()");		
	}

}
