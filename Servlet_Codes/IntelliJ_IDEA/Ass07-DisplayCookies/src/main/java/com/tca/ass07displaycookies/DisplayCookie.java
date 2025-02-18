package com.tca.ass07displaycookies;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet({"/DisplayCookie"})
public class DisplayCookie extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();

        Cookie cookies[] = request.getCookies();

        if(cookies == null){
            out.println("<h1>No Saved Cookies</h1>");
        }
        else{
            out.println("<h1>Saved Cookie Cookies</h1>");
            for(var cookie : cookies){
                out.println(cookie.getName() + " " + cookie.getValue() + "<br>");
            }
        }

        out.close();
    }

}