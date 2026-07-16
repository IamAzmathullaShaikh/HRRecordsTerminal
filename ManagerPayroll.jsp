<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.Model.PayrollDetails" %>
<%
    List<PayrollDetails> payrollList = (List<PayrollDetails>) request.getAttribute("payrollList");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Manager Payroll</title>

<style>
body {
    font-family: "Segoe UI", Tahoma, sans-serif;
    background: #f5f7fa;
    margin: 0;
    padding: 40px;
    color: #1f2933;
}

/* ===== Page Header ===== */
h1 {
    text-align: center;
    background: linear-gradient(135deg, #1f4037, #2c5364);
    color: white;
    padding: 22px 0;
    margin: -40px -40px 30px -40px;
    font-size: 28px;
    font-weight: 700;
    letter-spacing: 0.5px;
}

/* ===== Card Container ===== */
.table-wrapper {
    background: #ffffff;
    padding: 25px;
    border-radius: 14px;
    box-shadow: 0 12px 30px rgba(0,0,0,0.08);
    overflow-x: auto;
}

/* ===== Table ===== */
table {
    width: 100%;
    border-collapse: collapse;
    font-size: 14px;
}

th {
    background: #f1f5f9;
    color: #1f2933;
    padding: 14px 12px;
    text-align: center;
    font-weight: 700;
    border-bottom: 2px solid #e5e7eb;
}

td {
    padding: 12px;
    border-bottom: 1px solid #e5e7eb;
}

tr:nth-child(even) {
    background: #fafafa;
}

tr:hover {
    background: #f1f5f9;
}

/* ===== Amount Highlight ===== */
td:last-child {
    font-weight: 700;
    color: #166534;
}

/* ===== No Data ===== */
.no-data {
    background: #ffffff;
    padding: 30px;
    border-radius: 14px;
    text-align: center;
    font-size: 18px;
    color: #475569;
    box-shadow: 0 10px 25px rgba(0,0,0,0.08);
}
</style>

</head>
<body>

<h1>Department Payroll</h1>

<% if (payrollList != null && !payrollList.isEmpty()) { %>

<div class="table-wrapper">
<table>
    <tr>
        <th>Employee ID</th>
        <th>Employee Name</th>
        <th>Month</th>
        <th>Year</th>
        <th>Working Days</th>
        <th>Presents</th>
        <th>Leaves</th>
        <th>Salary</th>
        <th>Per Day Salary</th>
        <th>Net Salary</th>
    </tr>

    <% for(PayrollDetails p : payrollList) { %>
    <tr>
        <td><%= p.getEmployeeID() %></td>
        <td><%= p.getEmployeeName() %></td>
        <td><%= p.getMonth() %></td>
        <td><%= p.getYear() %></td>
        <td><%= p.getWorkingDays() %></td>
        <td><%= p.getPresents() %></td>
        <td><%= p.getLeaves() %></td>
        <td><%= String.format("%.2f", p.getSalary()) %></td>
        <td><%= String.format("%.2f", p.getPerDaySalary()) %></td>
        <td><%= String.format("%.2f", p.getNetSalary()) %></td>
    </tr>
    <% } %>
</table>
</div>

<% } else { %>

<div class="no-data">
    No payroll data available for your department.
</div>

<% } %>

</body>
</html>
