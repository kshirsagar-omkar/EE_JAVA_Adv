package com.tca.ass09sessionquiz;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Quiz1", value = "/Quiz1")
public class Quiz1 extends HttpServlet {

    private static final long serialVersionUID = 1l;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        out.println("<head>" +
                "</head>\n" +
                "<body>\n" +
                "    <form action=\"./Quiz2\" method=\"post\">\n" +
                "        <h2>Quiz 1: General Knowledge</h2>\n" +
                "        <p>1. What is the capital of France?</p>\n" +
                "        <input type=\"radio\" name=\"q1\" value=\"Paris\"> Paris<br>\n" +
                "        <input type=\"radio\" name=\"q1\" value=\"London\"> London<br>\n" +
                "        <input type=\"radio\" name=\"q1\" value=\"Rome\"> Rome<br>\n" +
                "\n" +
                "        <br>\n" +
                "        <button type=\"submit\">Next</button>\n" +
                "    </form>\n" +
                "</body>\n" );


        out.close();
    }
}
