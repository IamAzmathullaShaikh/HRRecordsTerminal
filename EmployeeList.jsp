<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.Model.EmployeeDetails" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee List</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: #f4f7fb;
        margin: 0;
        padding: 20px;
    }

    h2 {
        text-align: center;
        color: #2c3e50;
    }

    .btn-container {
        text-align: center;
        margin-bottom: 20px;
    }

    .btn {
        padding: 6px 12px;
        margin: 2px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 13px;
        color: white;
    }

    .add {
        background-color: #0a1f44;
    }

    .update {
        background-color: #2980b9;
    }

    .delete {
        background-color: #c0392b;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        background: white;
    }

    th, td {
        padding: 10px;
        border: 1px solid #ddd;
        text-align: center;
    }

    th {
        background: #2c3e50;
        color: white;
    }

    tr:nth-child(even) {
        background: #f2f2f2;
    }

    a {
        text-decoration: none;
    }
</style>
</head>

<body>

<h2>Employee List</h2>

<div class="btn-container">
    <a href="addEmployee.jsp">
        <button class="btn add">➕ Add Employee</button>
    </a>
</div>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Gender</th>
        <th>DOB</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Role</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Actions</th>
    </tr>

<%
    List<EmployeeDetails> list =
        (List<EmployeeDetails>) request.getAttribute("EmployeeList");

    if (list != null && !list.isEmpty()) {
        for (EmployeeDetails emp : list) {
%>
    <tr>
        <td><%= emp.getEmployeeID() %></td>
        <td><%= emp.getEmployeeName() %></td>
        <td><%= emp.getGender() %></td>
        <td><%= emp.getDob() %></td>
        <td><%= emp.getEmail() %></td>
        <td><%= emp.getPhoneNo() %></td>
        <td><%= emp.getRole() %></td>
        <td><%= emp.getDepartment() %></td>
        <td><%= emp.getSalary() %></td>

        <!-- ✅ FIXED ACTION BUTTONS -->
        <td>
            <!-- Update -->
            <a href="updateEmployee.jsp?id=<%= emp.getEmployeeID() %>">
                <button class="btn update">✏ Update</button>
            </a>

            <!-- Delete (POST + correct param) -->
            <form action="<%= request.getContextPath() %>/DeleteEmployeeServlet"
                  method="post"
                  style="display:inline;"
                  onsubmit="return confirm('Are you sure you want to delete this employee?');">

                <input type="hidden" name="employeeID"
                       value="<%= emp.getEmployeeID() %>">

                <button type="submit" class="btn delete">🗑 Delete</button>
            </form>
        </td>
    </tr>
<%
        }
    } else {
%>
    <tr>
        <td colspan="10">No Employees Found</td>
    </tr>
<%
    }
%>

</table>

</body>
</html>
