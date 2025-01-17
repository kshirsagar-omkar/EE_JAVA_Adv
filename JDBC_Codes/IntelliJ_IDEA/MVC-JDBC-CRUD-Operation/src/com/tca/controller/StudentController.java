package com.tca.controller;

import com.tca.dao.StudentDAO;
import com.tca.entity.Student;
import com.tca.service.StudentService;

import javax.xml.transform.Source;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class StudentController {

    private static Scanner sc = null;

    static {
        sc = new Scanner(System.in);
    }

    public static void addStudent(){
        try {
            Student student = new Student();

            System.out.print("Enter Roll Number: ");
            student.setRollNumber( sc.nextInt() );
            sc.nextLine();

            System.out.print("Enter Name: ");
            student.setName( sc.nextLine() );

            System.out.print("Enter Percentage: ");
            student.setPercentage( sc.nextDouble() );
            sc.nextLine();

            StudentService.addStudent(student);
            System.out.println("Student added successfully.");

        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            sc.nextLine();
        } catch ( SQLException e) {
            System.out.println("Error Adding Student: " + e.getMessage());
        }
    }


    public static void getStudentByRollNumber(){
        try {
            System.out.print("Enter Roll Number: ");
            Integer rno = sc.nextInt();
            sc.nextLine();


            Student student = StudentService.getStudentByRollNumber(rno);
            if(student != null){
                System.out.println("Record Found: " + student);
            }else {
                System.out.println("Record Not Found For RollNumber: " + rno);
            }

        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            sc.nextLine();
        } catch ( SQLException e) {
            System.out.println("Error retrieving student: " + e.getMessage());
        }
    }



    public static void getAllStudents(){
        try {
            List<Student> students = StudentService.getAllStudents();
            for (Student student : students){
                System.out.println(student);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving students: " + e.getMessage());
        }
    }


    public static void updateStudent(){
        try {
            Student student = new Student();

            System.out.print("Enter Roll Number: ");
            student.setRollNumber( sc.nextInt() );
            sc.nextLine();

            System.out.print("Enter Name: ");
            student.setName( sc.nextLine() );

            System.out.print("Enter Percentage: ");
            student.setPercentage( sc.nextDouble() );
            sc.nextLine();

            StudentService.updateStudent(student);
            System.out.println("Student updated successfully.");

        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            sc.nextLine();
        } catch ( SQLException e) {
            System.out.println("Error updating Student: " + e.getMessage());
        }
    }


    public static void deleteStudent(){
        try {
            System.out.print("Enter Roll Number: ");
            Integer rno = sc.nextInt();
            sc.nextLine();

            StudentService.deleteStudent(rno);
            System.out.println("Student Deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Error Deleting student: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

    }

}
