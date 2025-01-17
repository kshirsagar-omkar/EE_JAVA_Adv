package com.tca.service;

import com.tca.dao.StudentDAO;
import com.tca.entity.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentService {

    public static void addStudent(Student student) throws SQLException{
        StudentDAO.addStudent(student);
    }

    public static Student getStudentByRollNumber(Integer rno) throws SQLException{
        return StudentDAO.getStudentByRollNumber(rno);
    }

    public static List<Student> getAllStudents() throws SQLException{
        return StudentDAO.getAllStudents();
    }

    public static void updateStudent(Student student) throws SQLException{
        StudentDAO.updateStudent(student);
    }

    public static void deleteStudent(Integer rno) throws SQLException{
        StudentDAO.deleteStudent(rno);
    }

}
