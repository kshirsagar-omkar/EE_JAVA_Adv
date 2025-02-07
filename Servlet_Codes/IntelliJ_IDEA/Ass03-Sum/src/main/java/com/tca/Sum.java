package com.tca;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({"/sum"})
public class Sum extends HttpServlet {

    private static final long serialVersionUID = 1l;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        try {

            Double num1 = Double.parseDouble(request.getParameter("num1"));
            Double num2 = Double.parseDouble(request.getParameter("num2"));

            out.println("<h1> SUM : " + (num1 + num2) + "</h1>" );



        }catch (Exception e) {
            out.println("<h1>Invalid Input</h1>");
            System.out.println("\n\nInvalid Input\n\n");
        }finally {
            out.close();
        }

    }


}