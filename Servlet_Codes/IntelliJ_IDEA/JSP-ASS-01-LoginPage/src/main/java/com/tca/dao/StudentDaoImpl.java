package com.tca.dao;

import com.tca.Util.DBUtil;
import com.tca.entities.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao{

    public Student getStudent(Student searchStudent){

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        Student student = null;


        try{
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM student WHERE rno=?");
            preparedStatement.setInt(1, searchStudent.getRno());
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                student = new Student();
                student.setRno( resultSet.getInt("rno") );
                student.setName( resultSet.getString("name") );
                student.setPer( resultSet.getDouble("per") );
                student.setUsername( resultSet.getString("username") );
                student.setPassword( resultSet.getString("password") );

                System.out.println("Student Found!");
            }
            else {
                System.out.println("Student Not Found!");
            }

        } catch (Exception e) {
            System.out.println("\n\n\nException in StudentDaoImpl Class :" + e.getMessage() + "\n\n\n");
            e.printStackTrace();
        }
        finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("\n\n\nException in StudentDaoImpl Class While Closing Connection:" + e.getMessage() + "\n\n\n");
                    e.printStackTrace();
                }
            }

            return student;
        }
    }




    public List<Student> getAllStudent(){


        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        List<Student> students = null;


        try{
            connection = DBUtil.getConnection();
            statement = connection.createStatement();

            resultSet = statement.executeQuery("SELECT * FROM student");

            students = new ArrayList<>();

            while(resultSet.next()){

                Student student = new Student();
                student.setRno( resultSet.getInt("rno") );
                student.setName( resultSet.getString("name") );
                student.setPer( resultSet.getDouble("per") );
                student.setUsername( resultSet.getString("username") );
                student.setPassword( resultSet.getString("password") );

                students.add(student);

            }

        } catch (Exception e) {
            System.out.println("\n\n\nException in StudentDaoImpl Class :" + e.getMessage() + "\n\n\n");
            e.printStackTrace();
        }
        finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("\n\n\nException in StudentDaoImpl Class While Closing Connection:" + e.getMessage() + "\n\n\n");
                    e.printStackTrace();
                }
            }
            if(students != null && students.isEmpty()) {
                return null;
            }
            return students;
        }


    }







}
