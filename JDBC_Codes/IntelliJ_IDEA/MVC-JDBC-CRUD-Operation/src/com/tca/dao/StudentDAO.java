package com.tca.dao;

import com.tca.config.DatabaseConfig;
import com.tca.entity.Student;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class StudentDAO {



    public static void addStudent(Student student) throws SQLException {
        Connection conn = DatabaseConfig.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO student VALUES (?,?,?)");
            ps.setInt(1, student.getRollNumber());
            ps.setString(2, student.getName());
            ps.setDouble(3, student.getPercentage());
            ps.executeUpdate();
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println("Unable To Insert Record!!" + e.getMessage());
            e.printStackTrace();
        }
    }


    public static Student getStudentByRollNumber(Integer rno) throws SQLException {
        Connection conn = DatabaseConfig.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM student WHERE rno=?");
            ResultSet rs = null;

            ps.setInt(1, rno);

            rs = ps.executeQuery();
            if (rs.next()) {
                Student student = new Student();
                student.setRollNumber(rs.getInt("rno"));
                student.setName(rs.getString("name"));
                student.setPercentage(rs.getDouble("per"));
                return student;
            }

        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static List<Student> getAllStudents() throws SQLException {
        List<Student> students = new LinkedList<>();
        Connection conn = DatabaseConfig.getConnection();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM student");){

            while (rs.next()) {
                Student student = new Student();
                student.setRollNumber(rs.getInt("rno"));
                student.setName(rs.getString("name"));
                student.setPercentage(rs.getDouble("per"));
                students.add(student);
            }
        }
        return students;
    }


    public static void updateStudent(Student student) throws SQLException{
        Connection conn = DatabaseConfig.getConnection();
        try( PreparedStatement ps = conn.prepareStatement("UPDATE student SET name=?, per=? WHERE rno=?");){

            ps.setString(1, student.getName());
            ps.setDouble(2, student.getPercentage());
            ps.setInt(3, student.getRollNumber());
            ps.executeUpdate();

        }
    }

    public static void deleteStudent(Integer rollNumber) throws SQLException{
        Connection conn = DatabaseConfig.getConnection();
        try(PreparedStatement ps = conn.prepareStatement("DELETE FROM student WHERE rno=?");){

            ps.setInt(1, rollNumber);
            ps.executeUpdate();

        }
    }


}