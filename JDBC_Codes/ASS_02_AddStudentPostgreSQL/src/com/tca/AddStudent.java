package com.tca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddStudent {
	
	public static Connection conn = null;
	public static PreparedStatement ps = null;
	
	
	public static void main(String[] args) {
		
		try {
			
			//step 1: Load Driver
			Class.forName("org.postgresql.Driver");
			
			
			//step 2: Form a Database COnnection
//			conn = DriverManager.getConnection("jdbc:postgresql://localhost/ee_java_db", "root", "root@123");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost/ee_java_db?sslmode=disable", "root", "root@123");

			
			//step 3: Prepare sql
			ps = conn.prepareStatement("insert into student values(?,?,?)");
			ps.setInt(1, 104);
			ps.setString(2, "Omkar");
			ps.setDouble(3, 95.88);
			
			
			//step 4: fire sql
			int statusValue = ps.executeUpdate();
			
			
			
			if( statusValue == 0 ) {
				System.out.println("Unable to add record!!");
			}
			else {
				System.out.println("inserted record successfully!!");
			}
			
			
			System.out.println("Hurry!!");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}


