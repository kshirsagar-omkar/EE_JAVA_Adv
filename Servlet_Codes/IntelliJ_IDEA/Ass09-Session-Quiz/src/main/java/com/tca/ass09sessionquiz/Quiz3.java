package com.tca.ass09sessionquiz;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Quiz3", value = "/Quiz3")
public class Quiz3 extends HttpServlet {

    private static final long serialVersionUID = 1l;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String q2Ans = request.getParameter("q2");

        HttpSession hs = request.getSession(false);
        hs.setAttribute("q2Ans", q2Ans);

        out.println("<head></head>\n" +
                        "<body>\n" +
                        "    <form action=\"./CheckScore\" method=\"post\">\n" +
                        "        <h2>Quiz 3: Technology</h2>\n" +
                        "        <p>3. Who is known as the father of computers?</p>\n" +
                        "        <input type=\"radio\" name=\"q3\" value=\"Charles Babbage\"> Charles Babbage<br>\n" +
                        "        <input type=\"radio\" name=\"q3\" value=\"Alan Turing\"> Alan Turing<br>\n" +
                        "        <input type=\"radio\" name=\"q3\" value=\"Bill Gates\"> Bill Gates<br>\n" +
                        "\n" +
                        "        <br>\n" +
                        "        <button type=\"submit\">Submit</button>\n" +
                        "    </form>\n" +
                        "</body>\n" );


        out.close();
    }
}
