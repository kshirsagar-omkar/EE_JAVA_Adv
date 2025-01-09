package com.tca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Formatter;

//Using PreparedStatement Class

public class ShowStudent {

	public final static String URL = "jdbc:postgresql://localhost/ee_java_db?sslmode=disable";
	public final static String USER = "root";
	public final static String PASSWORD = "root@123";
	public final static String DRIVER= "org.postgresql.Driver";
	
	public static Connection conn = null;
	public static PreparedStatement ps = null;
	
	
	
	public static ResultSet rs = null;
	
	
	
	public static void main(String[] args) {
		
		
		
		String query = "SELECT * FROM student";
		
		
		
		try {
			
			
			Class.forName(DRIVER);
			
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			
			
			
			
			Formatter fmt = new Formatter();
			
			fmt.format("%16s %20s %16s\n", "RollNumber", "Name", "Percentage");
			fmt.format("--------------------------------------------------------\n");
			
			
			
			
//			System.out.println("rno------name------per");
//			System.out.println("----------------------");
			
			
			while( rs.next() ) {
				
//				System.out.println(rs.getInt("rno") + "    " + rs.getString("name") + "    " + rs.getDouble("per"));
//				System.out.println("----------------------");
				
				
				
				fmt.format("%16d %20s %16.2f\n", rs.getInt("rno"), rs.getString("name"), rs.getDouble("per"));
				fmt.format("--------------------------------------------------------\n");
				
			}
			
			System.out.println(fmt);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		

	}

}
