package com.tca.ass09sessionquiz;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "loginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();




        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if( validateUser(username, password) ){

            HttpSession hs = request.getSession(true);
            hs.setAttribute("username", username);

            out.println("<html>");
            out.println("<body>");
            out.println("<form id='quizForm' action='Quiz1' method='post'>");
//            out.println("<input type='hidden' name='username' value='" + username + "'>");
            out.println("</form>");
            out.println("<script>document.getElementById('quizForm').submit();</script>");
            out.println("</body>");
            out.println("</html>");


        }
        else {
            out.println("<h1>Invalid Credentials</h1>");
        }





        out.close();
    }



    public boolean validateUser(String user, String password){
        return (user.equals("om") && password.equals("123"));
    }


}