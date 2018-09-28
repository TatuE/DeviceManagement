package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
	public Connection con =null;
	public ResultSet rs = null;
	public PreparedStatement prepStmt = null;
	public String sql;

	public Dao() {
		super();
	}

	public Connection connect() throws Exception{
		String JDBCDriver = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://<mariadb-server>";
		Class.forName(JDBCDriver);
		con = DriverManager.getConnection(url,"<mariadb_UserName>", "<mariadb_User_password>");
		return con;
	}

	public void closeConnection() throws Exception{
		if(con!=null) {
			con.close();
		}
	}

	public java.sql.Date sqlCurrentDate(){
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}


}
