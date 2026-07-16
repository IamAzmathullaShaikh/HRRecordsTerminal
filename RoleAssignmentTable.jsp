<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.Model.RoleAssignment" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Role Assignment</title>

<style>
    body {
        margin: 0;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: #f6f8fb;
        padding: 30px;
    }

    h2 {
        text-align: center;
        margin-bottom: 15px;
        color: #2c3e50;
    }

    .top-bar {
        width: 90%;
        margin: 0 auto 20px auto;
        display: flex;
        justify-content: flex-end;
    }

    .assign-btn {
        background: #1f3c88;
        color: white;
        padding: 10px 18px;
        border-radius: 6px;
        text-decoration: none;
        font-size: 15px;
        font-weight: 600;
    }

    .assign-btn:hover {
        background: #162c66;
    }

    table {
        width: 90%;
        margin: auto;
        border-collapse: collapse;
        background: #fff;
        box-shadow: 0 6px 15px rgba(0,0,0,0.1);
    }

    th, td {
        padding: 12px;
        text-align: center;
        border-bottom: 1px solid #ddd;
    }

    th {
        background: #2c3e50;
        color: #fff;
    }

    tr:hover {
        background: #f2f6fc;
    }
</style>
</head>

<body>

<h2>Role Assignment</h2>

<!-- TOP BUTTON -->
<div class="top-bar">
    <a href="RoleAssignmentForm.jsp" class="assign-btn">
        + Role Assignment
    </a>
</div>

<table>
    <tr>
        <th>Employee ID</th>
        <th>Role</th>
        <th>Department</th>
    </tr>

    <%
        List<RoleAssignment> list =
            (List<RoleAssignment>) request.getAttribute("RoleAssignmentList");

        if (list != null && !list.isEmpty()) {
            for (RoleAssignment emp : list) {
    %>
    <tr>
        <td><%= emp.getEmployeeID() %></td>
        <td><%= emp.getRole() %></td>
        <td><%= emp.getDepartment() %></td>
        
    </tr>
    <%
            }
        } else {
    %>
    <tr>
        <td colspan="4">No role assignments found</td>
    </tr>
    <%
        }
    %>

</table>

</body>
</html>
