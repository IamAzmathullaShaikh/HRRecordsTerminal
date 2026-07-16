<%@ page import="com.Model.AttendanceSummary" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*" %>
<%
AttendanceSummary summary = (AttendanceSummary) request.getAttribute("summary");
%>
<h2>Your Attendance</h2>
<table border="1">
<tr>
    <th>Employee ID</th>
    <th>Name</th>
    <th>Working Days</th>
    <th>Presents</th>
    <th>Leaves</th>
</tr>
<tr>
    <td><%= summary.getEmployeeID() %></td>
    <td><%= summary.getEmployeeName() %></td>
    <td><%= summary.getWorkingDays() %></td>
    <td><%= summary.getPresents() %></td>
    <td><%= summary.getLeaves() %></td>
</tr>
</table>
    