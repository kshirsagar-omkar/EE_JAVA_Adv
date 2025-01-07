package com.tca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main {

	public final static String URL = "jdbc:postgresql://localhost/ee_java_db?sslmode=disable";
	public final static String USER = "root";
	public final static String PASSWORD = "root@123";
	public final static String DRIVER = "org.postgresql.Driver";
	
	
	public static Connection conn = null;
	public static PreparedStatement ps = null; 
	
	
	
	
	
	public static void main(String[] args) {	
		
		String query = "DELETE FROM student WHERE rno = ?";
		Integer rno = 104;
		
		Integer successVal = null;
		
		
		try {
			
			
			//step 1: load Driver
			Class.forName(DRIVER);
			
			//step 2: form Connection
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			
			//step 3: create SQL
			ps = conn.prepareStatement(query);
			ps.setInt(1, rno);

			
			//step 4: Fire SQL
			successVal = ps.executeUpdate();
			
			if(successVal == 0) {
				System.out.println("No Record Found For Roll Number : " + rno);
			}
			else {
				System.out.println("Record Deleted Successfully For Roll Number : " + rno);
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				
				//step 5: close database connection
				conn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
