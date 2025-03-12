<%--
  Created by IntelliJ IDEA.
  User: omkar
  Date: 3/12/25
  Time: 11:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Add Student</title>
</head>
<body>

<div class="container text-center" style="margin-top: 100px">

  <div class="container text-center" >
    <h2 class="text-primary">Add Student</h2>
  </div>


  <div class="container mt-4" style="width: 600px">

    <form method="POST" action="./AddStudent">
        <div class="mb-3">
          <label for="rno" class="form-label">Roll Number</label>
          <input type="text" class="form-control" id="rno" name="rno" required>
        </div>


        <div class="mb-3">
          <label for="name" class="form-label">Name</label>
          <input type="text" class="form-control" id="name" name="name" required>
        </div>


      <div class="mb-3">
        <label for="per" class="form-label">Percentage</label>
        <input type="text" class="form-control" id="per" name="per" required>
      </div>

      <div class="d-grid gap-2">
        <button type="submit" class="btn btn-primary">Add</button>
      </div>

    </form>

  </div>




  <div class="container">
    <p style="color: blue;"> ${msg} </p>
  </div>



</div>





</body>
</html>