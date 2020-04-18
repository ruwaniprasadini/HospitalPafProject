package com.pafproject.Hospital.Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DoctorDB {
	public static Connection connector()
	{
		Connection con = null;
		
		String url = "jdbc:mysql://localhost:3306/doctorapiproject";
		String username = "root";
		String password = "";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			System.out.println("Connection Done");
			if (con != null) {
                
            }
		}catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}

}
