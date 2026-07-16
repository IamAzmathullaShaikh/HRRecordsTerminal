<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.Model.PayrollDetails" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HR Payroll</title>

<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: #f4f6f9;
        margin: 0;
        padding: 20px;
    }

    h2 {
        text-align: center;
        color: #2c3e50;
        margin-bottom: 25px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        background: #fff;
        box-shadow: 0 8px 20px rgba(0,0,0,0.08);
    }

    th, td {
        padding: 12px 15px;
        text-align: center;
        border-bottom: 1px solid #e1e5ea;
    }

    th {
        background-color: #2c3e50;
        color: #ffffff;
        font-weight: 600;
    }

    tr:hover {
        background-color: #f1f4f8;
    }

    .empty {
        text-align: center;
        padding: 20px;
        color: #7a8a99;
        font-size: 16px;
    }

    .back-btn {
        display: inline-block;
        margin-bottom: 20px;
        padding: 10px 18px;
        background: #2c3e50;
        color: white;
        text-decoration: none;
        border-radius: 6px;
        font-weight: 600;
    }

    .back-btn:hover {
        background: #1a252f;
    }
</style>
</head>

<body>

<a href="<%= request.getContextPath() %>/HRDashboard.jsp" class="back-btn">
    ← Back to Dashboard
</a>

<h2>All Employee Payroll</h2>

<table>
    <tr>
        <th>Employee ID</th>
        <th>Employee Name</th>
        <th>Month</th>
        <th>Year</th>
        <th>Net Salary</th>
    </tr>

    <%
        List<PayrollDetails> payrollList =
            (List<PayrollDetails>) request.getAttribute("payrollList");

        if (payrollList == null || payrollList.isEmpty()) {
    %>
        <tr>
            <td colspan="5" class="empty">
                No payroll records found.
            </td>
        </tr>
    <%
        } else {
            for (PayrollDetails p : payrollList) {
    %>
        <tr>
            <td><%= p.getEmployeeID() %></td>
            <td><%= p.getEmployeeName() %></td>
            <td><%= p.getMonth() %></td>
            <td><%= p.getYear() %></td>
            <td>₹ <%= p.getNetSalary() %></td>
        </tr>
    <%
            }
        }
    %>

</table>

</body>
</html>
    