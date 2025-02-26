<%--
  Created by IntelliJ IDEA.
  User: omkar
  Date: 2/27/25
  Time: 12:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%@ page errorPage="myErrorPage.jsp" %>

<html>
<head>
    <title>Print Msg From Servlet</title>
</head>
<body>

    <%-- JSP COMMENT --%>

    <%-- Decleration Tag --%>
    <%!
        int a[] = new int[]{11,22,33};
    %>

    <%-- Expression Tag --%>
    <h1><%=request.getAttribute("msg") + " " + (a[0] + a[1])%> </h1>


    <%-- Script let Tag --%>
    <%
        //ArrayOutOfBoundException
        a[5] = 0;
    %>

</body>
</html>
