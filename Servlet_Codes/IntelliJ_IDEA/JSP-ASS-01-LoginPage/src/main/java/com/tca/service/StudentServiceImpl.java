package com.tca.service;

import com.tca.dao.StudentDao;
import com.tca.dao.StudentDaoImpl;
import com.tca.entities.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService{

    public Student getStudent(Student student){
        StudentDao studentDao = new StudentDaoImpl();
        return studentDao.getStudent(student);
    }

    public List<Student> getAllStudent(){
        StudentDao studentDao = new StudentDaoImpl();
        return studentDao.getAllStudent();
    }





}
