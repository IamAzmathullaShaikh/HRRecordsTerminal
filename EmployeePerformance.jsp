<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.Model.EmployeePerformance" %>

<%
    EmployeePerformance perf =
        (EmployeePerformance) request.getAttribute("performance");
%>

<!DOCTYPE html>
<html>
<head>
    <title>My Performance</title>
</head>
<body>

<h2 align="center">My Performance Report</h2>

<%
    if (perf != null) {
%>
    <p><b>Month:</b> <%= perf.getMonth() %> / <%= perf.getYear() %></p>
    <p><b>Total Tasks:</b> <%= perf.getTotalTasks() %></p>
    <p><b>Completed On Time:</b> <%= perf.getCompletedOnTime() %></p>
    <p><b>Completed Late:</b> <%= perf.getCompletedLate() %></p>
    <p><b>Performance Score:</b> <%= perf.getPerformanceScore() %></p>
    <p><b>Grade:</b> <%= perf.getGrade() %></p>
<%
    } else {
%>
    <p>No performance data available.</p>
<%
    }
%>

</body>
</html>
    