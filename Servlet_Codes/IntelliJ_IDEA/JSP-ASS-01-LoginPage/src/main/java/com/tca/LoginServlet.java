package com.tca;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1l;



    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        if( validateUser(userName, password) ){

            HttpSession session = request.getSession(true);
            session.setAttribute("username", userName);

            response.sendRedirect("dashboard.jsp");

        }
        else{
            request.setAttribute("error", "Invalid Username Or Password");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }

    }


    public Boolean validateUser(String userName, String password){

        return ( userName.equals("om") && password.equals("123") );

    }

}