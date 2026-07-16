<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.Model.PayrollDetails"%>
<%
PayrollDetails p = (PayrollDetails) request.getAttribute("payroll");
%>

<h2>Payroll Generated</h2>

<table border="1">
<tr><th>Employee</th><td><%=p.getEmployeeName()%></td></tr>
<tr><th>Month</th><td><%=p.getMonth()%>/<%=p.getYear()%></td></tr>
<tr><th>Working Days</th><td><%=p.getWorkingDays()%></td></tr>
<tr><th>Presents</th><td><%=p.getPresents()%></td></tr>
<tr><th>Leaves</th><td><%=p.getLeaves()%></td></tr>
<tr><th>Per Day Salary</th><td><%=p.getPerDaySalary()%></td></tr>
<tr><th>Net Salary</th><td><%=p.getNetSalary()%></td></tr>
</table>
    