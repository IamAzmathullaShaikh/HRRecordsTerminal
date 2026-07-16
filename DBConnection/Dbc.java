package com.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Dbc {
	
		public static Connection getConnection() {
			Connection con = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Organization","root","root");
				
			}
			
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return con;

		}

	}