package com.tca.ass09sessionquiz;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Quiz2", value = "/Quiz2")
public class Quiz2 extends HttpServlet {

    private static final long serialVersionUID = 1l;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String q1Ans = request.getParameter("q1");

        HttpSession hs = request.getSession(false);
        hs.setAttribute("q1Ans", q1Ans);



        out.println("<head>" +
                "</head>\n" +
                "<body>\n" +
                "    <form action=\"./Quiz3\" method=\"post\">\n" +
                "        <h2>Quiz 2: Science</h2>\n" +
                "        <p>2. What planet is known as the Red Planet?</p>\n" +
                "        <input type=\"radio\" name=\"q2\" value=\"Mars\"> Mars<br>\n" +
                "        <input type=\"radio\" name=\"q2\" value=\"Venus\"> Venus<br>\n" +
                "        <input type=\"radio\" name=\"q2\" value=\"Jupiter\"> Jupiter<br>\n" +
                "\n" +
                "        <br>\n" +
                "        <button type=\"submit\">Next</button>\n" +
                "    </form>\n" +
                "</body>\n");


        out.close();

    }
}
