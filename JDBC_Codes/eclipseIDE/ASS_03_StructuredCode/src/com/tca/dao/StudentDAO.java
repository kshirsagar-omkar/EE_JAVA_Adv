package com.tca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tca.config.DatabaseConfig;
import com.tca.model.Student;

public class StudentDAO {
	
	
	
	//Add student to database
	public static Boolean addStudent(Student student) throws SQLException {
		String query = "INSERT INTO STUDENT VALUES(?,?,?)";
		try( Connection conn = DatabaseConfig.getConnection() ){
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, student.getRno());
			ps.setString(2, student.getName());
			ps.setDouble(3, student.getPer());
			
			return ps.executeUpdate() > 0;
		}
	}
	
	
	
	
	
	
	
}
