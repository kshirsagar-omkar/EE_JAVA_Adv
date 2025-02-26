<%--
  Created by IntelliJ IDEA.
  User: omkar
  Date: 2/27/25
  Time: 12:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GreetUser</title>
</head>
<body>

    <h1> Hello </h1>

    <%
        String user = request.getParameter("name");
        out.println("<h1>" + user + "</h1>");
    %>

</body>
</html>
