<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.Model.LeaveRequest" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Leave Status</title>

<style>
body {
    font-family: Arial, sans-serif;
    background: #f4f6f9;
    margin: 0;
    padding: 20px;
}

h2 {
    text-align: center;
    color: #2c3e50;
}

table {
    border-collapse: collapse;
    width: 80%;
    margin: 30px auto;
    background: white;
    box-shadow: 0 4px 10px rgba(0,0,0,0.1);
}

th, td {
    padding: 12px;
    text-align: center;
}

th {
    background-color: #2c3e50;
    color: white;
}

tr:nth-child(even) {
    background-color: #f2f2f2;
}

.status-PENDING {
    color: orange;
    font-weight: bold;
}

.status-APPROVED {
    color: green;
    font-weight: bold;
}

.status-REJECTED {
    color: red;
    font-weight: bold;
}

.back-btn {
    display: block;
    width: fit-content;
    margin: 20px auto;
    padding: 10px 20px;
    background: #3498db;
    color: white;
    text-decoration: none;
    border-radius: 6px;
}
</style>

</head>
<body>

<h2>My Leave Requests</h2>

<table border="1">
<tr>
    <th>From Date</th>
    <th>To Date</th>
    <th>Reason</th>
    <th>Status</th>
</tr>

<%
List<LeaveRequest> list = (List<LeaveRequest>) request.getAttribute("leaveList");

if (list == null || list.isEmpty()) {
%>
<tr>
    <td colspan="4">No leave requests found</td>
</tr>
<%
} else {
    for (LeaveRequest l : list) {
%>
<tr>
    <td><%= l.getFromDate() %></td>
    <td><%= l.getToDate() %></td>
    <td><%= l.getReason() %></td>
    <td class="status-<%= l.getStatus() %>">
        <%= l.getStatus() %>
    </td>
</tr>
<%
    }
}
%>

</table>

<a href="employeedashboard.jsp" class="back-btn">⬅ Back to Dashboard</a>

</body>
</html>
    