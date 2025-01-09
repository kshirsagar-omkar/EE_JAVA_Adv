package com.tca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.tca.controller.StudentController;
import com.tca.model.Student;

public class Main {
	
	
	public static void main(String[] args) {
		
		
		/*
		//Add Single Record
		
		if( StudentController.addStudent(111, "TEST", 1.00) ) {
			System.out.println("RecordAdded Successfully!!!");
		}
		else {
			System.out.println("Unable to Add Record!!!");
		}
		*/
		
		
		
		
		
		//Add 'n' Records
		
		String choice;
		
		
		
		try(BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) )){
		
			while(true) {
				
				System.out.print("Do you want to enter record (y/n) ");
				choice =  br.readLine();
				
				if( choice.equalsIgnoreCase("y") ) {
					
					Student student = StudentController.accept();
					
					if( StudentController.addStudent(student) ) {
						System.out.println("RecordAdded Successfully!!!");
					}
					else {
						System.out.println("Unable to Add Record!!!");
					}					
				}
				else if(choice.equalsIgnoreCase("n")){
					
					System.out.println("Byee!!");
					break;
					
				}
				else {
					System.out.println("Wrong Option Choose Again!!\n");
				}
			}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
}
