<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.Model.LeaveRequest" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Leave Requests</title>

<style>
body {
    font-family: "Segoe UI", Tahoma, sans-serif;
    background: #f5f7fa;
    padding: 40px;
    color: #1f2933;
}

h2 {
    margin-bottom: 20px;
    font-size: 26px;
    font-weight: 700;
}

/* ===== Table Container ===== */
.table-container {
    background: #ffffff;
    padding: 20px;
    border-radius: 12px;
    box-shadow: 0 10px 30px rgba(0,0,0,0.08);
    overflow-x: auto;
}

/* ===== Table ===== */
table {
    width: 100%;
    border-collapse: collapse;
    font-size: 14px;
}

th {
    background: #1f4037;
    color: #ffffff;
    padding: 14px 12px;
    text-align: left;
    font-weight: 600;
}

td {
    padding: 12px;
    border-bottom: 1px solid #e5e7eb;
}

tr:hover {
    background: #f1f5f9;
}

/* ===== Status Badge ===== */
.status {
    padding: 4px 10px;
    border-radius: 20px;
    font-size: 12px;
    font-weight: 600;
    display: inline-block;
}

.status.PENDING {
    background: #fef3c7;
    color: #92400e;
}

.status.APPROVED {
    background: #dcfce7;
    color: #166534;
}

.status.REJECTED {
    background: #fee2e2;
    color: #991b1b;
}

/* ===== Action Buttons ===== */
.action-btn {
    padding: 6px 14px;
    border-radius: 6px;
    text-decoration: none;
    font-size: 13px;
    font-weight: 600;
    margin-right: 6px;
    display: inline-block;
}

.approve {
    background: #16a34a;
    color: white;
}

.approve:hover {
    background: #15803d;
}

.reject {
    background: #dc2626;
    color: white;
}

.reject:hover {
    background: #b91c1c;
}
</style>

</head>
<body>

<h2>Leave Approval Requests</h2>

<div class="table-container">
<table>
<tr>
  <th>Emp ID</th>
  <th>From</th>
  <th>To</th>
  <th>Reason</th>
  <th>Status</th>
  <th>Action</th>
</tr>

<%
List<LeaveRequest> list = (List<LeaveRequest>) request.getAttribute("leaveList");
for (LeaveRequest l : list) {
%>
<tr>
  <td><%= l.getEmployeeID() %></td>
  <td><%= l.getFromDate() %></td>
  <td><%= l.getToDate() %></td>
  <td><%= l.getReason() %></td>
  <td>
      <span class="status <%= l.getStatus() %>">
          <%= l.getStatus() %>
      </span>
  </td>
  <td>
    <a class="action-btn approve"
       href="LeaveApprovalServlet?leaveId=<%=l.getLeaveId()%>&action=approve">
       Approve
    </a>
    <a class="action-btn reject"
       href="LeaveApprovalServlet?leaveId=<%=l.getLeaveId()%>&action=reject">
       Reject
    </a>
  </td>
</tr>
<% } %>

</table>
</div>

</body>
</html>
