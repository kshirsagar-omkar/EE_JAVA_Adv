<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  // Check if the user is logged in
  if (session == null || session.getAttribute("username") == null) {
    response.sendRedirect("login.jsp");
    return;
  }
%>




<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Dashboard - Student Portal</title>
  <!-- Bootstrap 5 CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <!-- Font Awesome for Icons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
  <!-- Custom CSS -->
  <style>
    body {
      background-color: #f8f9fa;
    }
    .dashboard-header {
      background-color: #2575fc;
      color: white;
      padding: 40px 20px;
      text-align: center;
      margin-bottom: 30px;
    }
    .dashboard-header h1 {
      font-size: 2.5rem;
      font-weight: bold;
    }
    .dashboard-card {
      background-color: white;
      border-radius: 10px;
      padding: 20px;
      margin-bottom: 20px;
      box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
      transition: transform 0.3s ease;
    }
    .dashboard-card:hover {
      transform: translateY(-5px);
    }
    .dashboard-card h3 {
      color: #2575fc;
      margin-bottom: 15px;
      font-size: 1.5rem;
    }
    .dashboard-card p {
      color: #555;
      margin-bottom: 0;
    }
    .btn-logout {
      background-color: #dc3545;
      color: white;
      border: none;
      padding: 10px 20px;
      border-radius: 5px;
      transition: background-color 0.3s ease;
    }
    .btn-logout:hover {
      background-color: #c82333;
    }
    .recent-activities {
      list-style: none;
      padding: 0;
    }
    .recent-activities li {
      padding: 10px;
      border-bottom: 1px solid #eee;
      color: #555;
    }
    .recent-activities li:last-child {
      border-bottom: none;
    }
    .icon {
      margin-right: 10px;
      color: #2575fc;
    }
  </style>
</head>
<body>
<!-- Header -->
<div class="dashboard-header">
  <h1>Welcome back, <%= session.getAttribute("username") %>!</h1>
  <p>Here's what's happening today.</p>
</div>

<!-- Main Content -->
<div class="container">
  <div class="row">
    <!-- Quick Stats -->
    <div class="col-md-4">
      <div class="dashboard-card">
        <h3><i class="fas fa-book icon"></i>Enrolled Courses</h3>
        <p>You are enrolled in <strong>5 courses</strong>.</p>
      </div>
    </div>
    <div class="col-md-4">
      <div class="dashboard-card">
        <h3><i class="fas fa-check-circle icon"></i>Completed Topics</h3>
        <p>You have completed <strong>12 topics</strong>.</p>
      </div>
    </div>
    <div class="col-md-4">
      <div class="dashboard-card">
        <h3><i class="fas fa-calendar-alt icon"></i>Upcoming Exams</h3>
        <p>You have <strong>3 exams</strong> coming up.</p>
      </div>
    </div>
  </div>

  <!-- Recent Activities -->
  <div class="row mt-4">
    <div class="col-md-8">
      <div class="dashboard-card">
        <h3><i class="fas fa-clock icon"></i>Recent Activities</h3>
        <ul class="recent-activities">
          <li><i class="fas fa-check-circle icon"></i>Completed topic: Object-Oriented Programming</li>
          <li><i class="fas fa-book icon"></i>Enrolled in new course: Advanced Java</li>
          <li><i class="fas fa-calendar-alt icon"></i>Upcoming exam: Java Fundamentals on 10th Oct</li>
          <li><i class="fas fa-check-circle icon"></i>Completed topic: Collections Framework</li>
        </ul>
      </div>
    </div>
    <div class="col-md-4">
      <div class="dashboard-card">
        <h3><i class="fas fa-bell icon"></i>Notifications</h3>
        <ul class="recent-activities">
          <li><i class="fas fa-info-circle icon"></i>New assignment posted</li>
          <li><i class="fas fa-info-circle icon"></i>Exam schedule updated</li>
          <li><i class="fas fa-info-circle icon"></i>Course materials uploaded</li>
        </ul>
      </div>
    </div>
  </div>

  <!-- Logout Button -->
  <div class="text-center mt-4">
    <a href="logout" class="btn btn-logout">Logout</a>
  </div>
</div>

<!-- Bootstrap 5 JS and dependencies -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
</body>
</html>