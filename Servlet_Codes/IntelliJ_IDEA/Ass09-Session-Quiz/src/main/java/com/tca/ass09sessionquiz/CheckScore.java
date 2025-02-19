package com.tca.ass09sessionquiz;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CheckScore", value = "/CheckScore")
public class CheckScore extends HttpServlet {

    private static final long serialVersionUID = 1l;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle POST requests here
        response.setContentType("text/html");

        // Hello
        String q3Ans = request.getParameter("q2");

        HttpSession hs = request.getSession(false);




        PrintWriter out = response.getWriter();

        out.println(hs.getAttribute("username") + "<br>");
        out.println(hs.getAttribute("q1Ans") + "<br>");
        out.println(hs.getAttribute("q2Ans") + "<br>");
        out.println(q3Ans + "<br>");


        out.println("<h1>end</h1>");
        out.println("<a href='http://localhost:8080/Ass09_Session_Quiz_war_exploded/' target='_self'> go Back");

        out.close();
    }
}
