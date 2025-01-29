package com.tca;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet({"/first", "/omkar"})
public class HelloServlet extends HttpServlet {
    private String message;


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("Hello World");
        out.close();
    }

}