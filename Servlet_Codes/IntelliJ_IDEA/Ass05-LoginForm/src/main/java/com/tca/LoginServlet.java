package com.tca;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginServlet" ,value = "/login-servlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        if( (req.getParameter("uname")).equals("omkar") && (req.getParameter("upwd")).equals("123") ){
            //out.println("Login SuccessFull!!");
            //out.println("<script> alert('Login SuccessFull') </script>");
            resp.sendRedirect("https://www.technocompacademy.com/");
        }
        else{
            //out.println("Login Failed!!!");
            out.println("<script> alert('Login Failed') </script>");
            out.println("\n" +
                    "<form method=\"POST\" action=\"./login-servlet\">\n" +
                    "\n" +
                    "  <label for=\"uname\">UserName : </label>\n" +
                    "  <input type=\"text\" id=\"uname\" name=\"uname\" required>\n" +
                    "\n" +
                    "    <br>\n" +
                    "\n" +
                    "  <label for=\"upwd\">Password : </label>\n" +
                    "  <input type=\"password\" id=\"upwd\" name=\"upwd\" required>\n" +
                    "\n" +
                    "    <br>\n" +
                    "\n" +
                    "  <input type=\"submit\" value=\"Login\"> <input type=\"reset\" value=\"Clear\">\n" +
                    "</form>");

            /*
                resp.sendRedirect("http://localhost:8080/Ass05_LoginForm_war_exploded/Login.html");

                This Line Overrides the Alert Msg And Set An url for the response
            */
        }

        //out.println("<a href='./Login.html'> Go Back </a>");

        out.close();

    }
}
