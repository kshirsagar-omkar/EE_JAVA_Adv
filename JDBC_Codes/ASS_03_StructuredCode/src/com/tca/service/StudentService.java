package com.tca.service;

import java.sql.SQLException;

import com.tca.dao.StudentDAO;
import com.tca.model.Student;

public class StudentService {
	
	
	//Send Student details to StudentDAO to add in database
	public static Boolean addStudent(Student student) {
		try {
			return StudentDAO.addStudent(student);
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
}
