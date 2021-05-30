package com.mindtree.store.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mindtree.store.exceptions.ConnectionUtilityException;

public class ConnectionUtility {
	private static final String hostname="jdbc:mysql://localhost:3306/practice";
	private static final String username="root";
	private static final String password="Qwerty@12345";
	
	public Connection getConnection() throws ConnectionUtilityException
	{
		Connection con=null;
		 try {
			con=DriverManager.getConnection(hostname,username,password);
		} catch (SQLException e) {
			throw new ConnectionUtilityException(e.getMessage());
		}
		return con;
		
	}
	public void closeConnection(Connection con) throws ConnectionUtilityException
	{
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				throw new ConnectionUtilityException(e.getMessage());
			}
	}
	


}
