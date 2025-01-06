package com.tca.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.tca.model.Student;
import com.tca.service.StudentService;

public class StudentController {
	
	
	public static Student accept() {
		
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
		
		try{
			
			Student student = new Student();
			
			System.out.print("Enter Student Roll No.   : ");
			student.setRno( Integer.parseInt( br.readLine() ) );
			
			
			System.out.print("Enter Student Name       : ");
			student.setName( br.readLine() );
			
			
			System.out.print("Enter Student Percentage : ");
			student.setPer( Double.parseDouble( br.readLine() ) );
		
			return student;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
//		finally{
//			
//			try {
//				br.close();
//			} 
//			catch (IOException e) {
//				e.printStackTrace();
//			}
//			
//		}		
	}
	
	
	
	
	
	//Create student object and send to the StudentService 
	public static Boolean addStudent(Integer rno, String name, Double per) {
		Student student = new Student(rno, name, per);
		
		return StudentService.addStudent(student);
	}
	
	
	
	public static Boolean addStudent(Student student) {		
		return StudentService.addStudent(student);
	}
	
	
	
	
	
}
