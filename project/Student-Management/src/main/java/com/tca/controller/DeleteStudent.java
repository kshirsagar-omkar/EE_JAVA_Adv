package com.tca.controller;

import com.tca.entities.Student;
import com.tca.service.StudentService;
import com.tca.service.StudentServiceImpl;
import com.tca.util.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet {
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
        request.getRequestDispatcher("DeleteStudent.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Connection conn = null;
        String rno = request.getParameter("rno");
        Statement statement = null;
        String qry = "DELETE FROM student WHERE rno = " + rno;

        String status = "failed";

        try {
            conn = DBUtil.getConnection();

            conn.setAutoCommit(false);

            statement = conn.createStatement();
            statement.executeUpdate(qry);

            conn.commit();

            status = "success";

        } catch (Exception e) {
            System.out.println("Error while deleting record doPost :" + e.getMessage());
           e.printStackTrace();

            try {
                conn.rollback();
            } catch (Exception ex) {
                System.out.println("Error while deleting (rollback) record doPost :" + ex.getMessage());
                ex.printStackTrace();
            }
        }
        finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println("Error while deleting (Closing connection) record doPost :" + e.getMessage());
                e.printStackTrace();
            }
        }


        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println(status);
//        out.flush();
        out.close();

    }
}