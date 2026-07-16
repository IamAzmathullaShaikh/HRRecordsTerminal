<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.Model.EmployeePerformance" %>

<%
    List<EmployeePerformance> list =
        (List<EmployeePerformance>) request.getAttribute("performanceList");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Performance Report</title>
    <style>
        table {
            width: 90%;
            margin: auto;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            border: 1px solid #aaa;
            text-align: center;
        }
        th {
            background-color: #dff0d8;
        }
    </style>
</head>
<body>

<h2 align="center">Employee Performance Report</h2>

<table>
    <tr>
        <th>Employee ID</th>
        <th>Month</th>
        <th>Year</th>
        <th>Total Tasks</th>
        <th>On Time</th>
        <th>Late</th>
        <th>Score</th>
        <th>Grade</th>
    </tr>

<%
    if (list != null && !list.isEmpty()) {
        for (EmployeePerformance p : list) {
%>
    <tr>
        <td><%= p.getEmployeeID() %></td>
        <td><%= p.getMonth() %></td>
        <td><%= p.getYear() %></td>
        <td><%= p.getTotalTasks() %></td>
        <td><%= p.getCompletedOnTime() %></td>
        <td><%= p.getCompletedLate() %></td>
        <td><%= p.getPerformanceScore() %></td>
        <td><%= p.getGrade() %></td>
    </tr>
<%
        }
    } else {
%>
    <tr>
        <td colspan="8">No performance data found</td>
    </tr>
<%
    }
%>

</table>

</body>
</html>
    