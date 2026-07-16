<%@ page import="com.Model.EmployeeDetails" %>

<!DOCTYPE html>
<html>
<head>
    <title>Employee Details</title>
    <style>
        table {
            width: 60%;
            border-collapse: collapse;
            margin: 40px auto;
        }
        th, td {
            padding: 10px;
            border: 1px solid #333;
            text-align: left;
        }
        th {
            background-color: #2c3e50;
            color: white;
            width: 35%;
        }
        h2 {
            text-align: center;
        }
    </style>
</head>
<body>

<h2>Employee Details</h2>

<%
    EmployeeDetails emp = (EmployeeDetails) request.getAttribute("emp");
    if (emp != null) {
%>

<table>
    <tr><th>Employee ID</th><td><%= emp.getEmployeeID() %></td></tr>
    <tr><th>Name</th><td><%= emp.getEmployeeName() %></td></tr>
    <tr><th>Gender</th><td><%= emp.getGender() %></td></tr>
    <tr><th>Date of Birth</th><td><%= emp.getDob() %></td></tr>
    <tr><th>Email</th><td><%= emp.getEmail() %></td></tr>
    <tr><th>Phone</th><td><%= emp.getPhoneNo() %></td></tr>
    <tr><th>Role</th><td><%= emp.getRole() %></td></tr>
    <tr><th>Department</th><td><%= emp.getDepartment() %></td></tr>
    <tr><th>Salary</th><td><%= emp.getSalary() %></td></tr>
</table>

<%
    } else {
%>

<p style="text-align:center;color:red;">
    Employee details not found.
</p>

<%
    }
%>

</body>
</html>
