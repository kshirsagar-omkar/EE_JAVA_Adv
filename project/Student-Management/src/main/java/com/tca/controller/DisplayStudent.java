package com.tca.controller;

import com.tca.entities.Student;
import com.tca.service.StudentService;
import com.tca.service.StudentServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/DisplayStudent")
public class DisplayStudent extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Student> students = new ArrayList<>();

        String rno = request.getParameter("rno");
        String sbtn = request.getParameter("sbtn");


        try {

            StudentService studentService = new StudentServiceImpl();

            if(sbtn != null) {
                if ( !rno.isEmpty() && sbtn.equals("search")) {

                    Student student = new Student();
                    student.setRno( Integer.parseInt(rno) );

                    student = studentService.getStudent(student);
                    if(student != null) {
                        students.add(student);
                    }
                }
                else if (sbtn.equals("refresh")) {
                    students = studentService.getAllStudent();
                }
            }
            else{
                students = studentService.getAllStudent();
            }

        } catch (Exception e) {
//            e.printStackTrace();
        }


        request.setAttribute("listofstudents", students);
        request.getRequestDispatcher("DisplayStudent.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}