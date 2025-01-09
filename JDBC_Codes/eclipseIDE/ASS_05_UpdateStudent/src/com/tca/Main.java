package com.tca;



//Assignment 2: Update the NAME, PER or BOTH as per user requirement --> created a method for it.. -> menuDrivenUpdate()



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
	
	
	
	
	
	public static void menuDrivenUpdate() {
		
		
		
		Integer rno = 103;
		
		//Update Name for record 103 
		String name = "sachin";
		
		//Update Per For Record 103
		Double per = 72.56;
		
		Integer successVal = null;
		
		
		
		//User will enter
		String choice = "both";
		
		
		
		
		try {
			
			
			//step 1: load Driver
			Class.forName(DRIVER);
			
			//step 2: form Connection
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			
			//step 3: create SQL
			
			
			
			
			
			switch(choice) {
				
			case "name":
				ps = conn.prepareStatement("UPDATE student SET name = ? WHERE rno = ?");
				ps.setString(1, name);
				ps.setInt(2, rno);
				break;
				
			case "per":
				ps = conn.prepareStatement("UPDATE student SET per = ? WHERE rno = ?");
				ps.setDouble(1, per);
				ps.setInt(2, rno);
				break;
				
			case "both":
				ps = conn.prepareStatement("UPDATE student SET per = ?, name = ? WHERE rno = ?");
				ps.setDouble(1, per);
				ps.setString(2, name);
				ps.setInt(3, rno);
				break;
			
			default:
				System.out.println("Wrong Choice!!");
				
			}
			
			//step 4: Fire SQL
			successVal = ps.executeUpdate();
			
			
			
			if(successVal == 0) {
				System.out.println("No Record Found For Roll Number : " + rno);
			}
			else {
				System.out.println("Record Updated Successfully For Roll Number : " + rno);
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
	
	
	
	
	public static void main(String[] args) {	
		
		
		
		
		menuDrivenUpdate();
		
		
		
		
		
		
//		String query = "UPDATE student SET name = ? WHERE rno = ?";
//		Integer rno = 103;
//		
//		//Update Name for record 103 
//		String name = "Sachin";
//		
//		Integer successVal = null;
//		
//		
//		try {
//			
//			
//			//step 1: load Driver
//			Class.forName(DRIVER);
//			
//			//step 2: form Connection
//			conn = DriverManager.getConnection(URL, USER, PASSWORD);
//			
//			
//			//step 3: create SQL
//			ps = conn.prepareStatement(query);
//			ps.setString(1, name);
//			ps.setInt(2, rno);
//
//			
//			//step 4: Fire SQL
//			successVal = ps.executeUpdate();
//			
//			if(successVal == 0) {
//				System.out.println("No Record Found For Roll Number : " + rno);
//			}
//			else {
//				System.out.println("Record Updated Successfully For Roll Number : " + rno);
//			}
//			
//			
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		finally {
//			try {
//				
//				//step 5: close database connection
//				conn.close();
//			}
//			catch(Exception e) {
//				e.printStackTrace();
//			}
//		}

	}
	
	
	
	
	
	
	

}
