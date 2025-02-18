package com.tca.ass06addcookies;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet({"/AddCookie"})
public class AddCookie extends HttpServlet {



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");


        PrintWriter out = response.getWriter();


        Cookie ck1 = new Cookie("omkar" , "Kshirsagar");
        Cookie ck2 = new Cookie("Sachin" , "Dhane");
        Cookie ck3 = new Cookie("Saurabh" , "Deo");

        ck1.setPath("/");
        ck2.setPath("/");
        ck3.setPath("/");

        response.addCookie(ck1);
        response.addCookie(ck2);
        response.addCookie(ck3);

        out.println("<h1>Added Cookies!</h1>");



        out.close();
    }

}