<%--
  Created by IntelliJ IDEA.
  User: omkar
  Date: 2/27/25
  Time: 12:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>


<html>
  <head>
    <title>Title</title>
  </head>
  <body>

    <%
      out.println("<h1>Exception Page : </h1>" + exception.getMessage());
    %>

  </body>
</html>
