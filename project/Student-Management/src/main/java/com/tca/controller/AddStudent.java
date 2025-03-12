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

@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {

    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("AddStudent.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String msg = "";

        try{
            Integer rno = Integer.parseInt(request.getParameter("rno"));
            String name = request.getParameter("name");
            Double per  = Double.parseDouble(request.getParameter("per"));

            Student student = new Student();
            student.setRno(rno);
            student.setName(name);
            student.setPer(per);

            StudentService studentService = new StudentServiceImpl();
            if(studentService.addStudent(student)){
                msg = "Record Added Successfully";
            }
            else {
                msg = "Unable To Add Record";
            }


        } catch (Exception e) {
//            e.printStackTrace();
            msg = "Unable To Add Record";
        }

        request.setAttribute("msg", msg);
        request.getRequestDispatcher("AddStudent.jsp").forward(request, response);

    }



//    private void handelRequest(String key, String value, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        request.getRequestDispatcher("AddStudent.jsp").forward(request, response);
//    }
}
