package com.tca;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "firstServlet", value = "/first-servlet")
public class FirstServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
        response.setContentType("text/html");

//        Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//
//        //out.println("<a href = \"./second-servlet\" alt=\"link\"> second servlet </a>");
//        //The above is for the Redirect to given page in url
//
//        out.println("</body></html>");

//        Forwarding the Request To Another Server
        RequestDispatcher rd = request.getRequestDispatcher("./second-servlet");
        rd.forward(request,response);
    }

    public void destroy() {
    }
}