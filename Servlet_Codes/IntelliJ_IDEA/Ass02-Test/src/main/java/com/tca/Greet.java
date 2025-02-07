package com.tca;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;




//@WebServlet({"/Greet"})
public class Greet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        if(name.isEmpty()){
            out.println("<h1>Please Enter The Name To Greet</h1>");
        }
        else {
            out.println("<h1>Hello " + name + "</h1>");
        }

        out.close();

    }

}
