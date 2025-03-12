<%@ page import="java.util.List" %>
<%@ page import="com.tca.entities.Student" %><%--
  Created by IntelliJ IDEA.
  User: omkar
  Date: 3/13/25
  Time: 1:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>


<%-- Logic of search preserved typed char ny user --%>
<%
    String rno = "";
    String sbtn = request.getParameter("sbtn");

    if(sbtn != null && sbtn.equals("search")){
        rno = request.getParameter("rno");
    }

%>



<div class="container" style="margin-top: 100px">


    <div class="container text-center">
        <h2 class="text-primary">
            Student Information
        </h2>
    </div>


    <!-- Search Logic-->
    <div class="container-fluid d-flex justify-content-end mb-3">
        <form class="d-flex" role="search" method="POST" action="./DisplayStudent">
            <input class="form-control me-2" type="search" name="rno" placeholder="Enter Roll num" value="<%=rno%>" aria-label="Search">
            <button class="btn btn-outline-success me-2" type="submit" value="search" name="sbtn">Search</button>
            <button class="btn btn-outline-success" type="submit" value="refresh" name="sbtn">Refresh</button>
        </form>
    </div>




    <!-- Table Logic-->
    <div class="container">
        <table class="table table-hover table-bordered text-center">

            <thead>
            <tr class="table-primary">
                <th scope="col">Rno</th>
                <th scope="col">Name</th>
                <th scope="col">Percentage</th>
            </tr>
            </thead>
            <tbody>

            <%
                List<Student> students = (List<Student>) request.getAttribute("listofstudents");

                if(students != null && students.isEmpty()){
            %>
                        <tr>
                            <td colspan="3">No Record Found</td>
                        </tr>

            <%
                }
                else{
                    for(Student student : students){
                        String cls = "";
                        if(student.getPer() < 45){
                            cls = "table-danger";
                        }
            %>
                <tr class="<%=cls%>">
                    <td> <%= student.getRno() %> </td>
                    <td> <%= student.getName() %> </td>
                    <td> <%= student.getPer() %> </td>
                </tr>
            <%
                    }
                }
            %>



            </tbody>

        </table>
    </div>
</div>


</body>
</html>
