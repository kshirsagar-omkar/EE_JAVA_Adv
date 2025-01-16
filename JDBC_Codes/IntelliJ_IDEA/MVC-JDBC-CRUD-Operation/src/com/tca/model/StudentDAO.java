package com.tca.model;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class StudentDAO {

    private Connection conn = null;

    public StudentDAO(Connection conn) {
        this.conn = conn;
    }


    public void addStudent(Student student) throws SQLException {

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


    public Student getStudentByRollNumber(Integer rno) throws SQLException {

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


    public List<Student> getAllStudent() throws SQLException {
        List<Student> students = new LinkedList<>();
        try {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");


            while (rs.next()) {
                Student student = new Student();
                student.setRollNumber(rs.getInt("rno"));
                student.setName(rs.getString("name"));
                student.setPercentage(rs.getDouble("per"));
                students.add(student);
            }
            return students;
        }


        //Start From here

    }
}