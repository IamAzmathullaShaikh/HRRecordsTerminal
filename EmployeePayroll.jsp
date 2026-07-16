<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.Model.PayrollDetails"%>

<h2>My Salary Details</h2>

<table border="1">
<tr>
  <th>Month</th>
  <th>Year</th>
  <th>Presents</th>
  <th>Net Salary</th>
</tr>

<%
List<PayrollDetails> list = (List<PayrollDetails>) request.getAttribute("payrollList");
for (PayrollDetails p : list) {
%>
<tr>
  <td><%=p.getMonth()%></td>
  <td><%=p.getYear()%></td>
  <td><%=p.getPresents()%></td>
  <td><%=p.getNetSalary()%></td>
</tr>
<% } %>
</table>
    