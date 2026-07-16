<%@ page import="com.Model.AttendanceSummary" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<%
List<AttendanceSummary> list = (List<AttendanceSummary>) request.getAttribute("attendanceList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Attendance</title>

<style>
    body {
        margin: 0;
        font-family: "Segoe UI", Tahoma, sans-serif;
        background: linear-gradient(135deg, #eef2f7, #f9fbfd);
        color: #333;
    }

    .page-wrapper {
        max-width: 1200px;
        margin: 50px auto;
        padding: 20px;
    }

    .page-header {
        background: linear-gradient(135deg, #1f4037, #2c5364);
        color: white;
        padding: 25px 30px;
        border-radius: 14px;
        box-shadow: 0 12px 30px rgba(0,0,0,0.15);
        margin-bottom: 35px;
    }

    .page-header h2 {
        margin: 0;
        font-size: 26px;
        font-weight: 600;
    }

    .page-header p {
        margin-top: 6px;
        font-size: 14px;
        opacity: 0.9;
    }

    .table-card {
        background: rgba(255, 255, 255, 0.9);
        backdrop-filter: blur(10px);
        border-radius: 16px;
        box-shadow: 0 15px 40px rgba(0,0,0,0.08);
        overflow: hidden;
    }

    table {
        width: 100%;
        border-collapse: collapse;
    }

    thead {
        background: #2c5364;
        color: white;
    }

    thead th {
        padding: 16px;
        font-size: 14px;
        font-weight: 600;
        text-transform: uppercase;
        letter-spacing: 0.6px;
        text-align: left;
    }

    tbody td {
        padding: 14px 16px;
        font-size: 14px;
        border-bottom: 1px solid #e5e7eb;
    }

    tbody tr:hover {
        background: #f1f5f9;
        transition: 0.2s;
    }

    tbody tr:last-child td {
        border-bottom: none;
    }

    .badge {
        padding: 6px 12px;
        border-radius: 20px;
        font-size: 12px;
        font-weight: 600;
        display: inline-block;
    }

    .present {
        background: #dcfce7;
        color: #166534;
    }

    .leave {
        background: #fee2e2;
        color: #991b1b;
    }

    .working {
        background: #e0f2fe;
        color: #075985;
    }
</style>

</head>

<body>

<div class="page-wrapper">

    <div class="page-header">
        <h2>All Employees Attendance</h2>
        <p>Attendance summary for all employees</p>
    </div>

    <div class="table-card">
        <table>
            <thead>
                <tr>
                    <th>Employee ID</th>
                    <th>Name</th>
                    <th>Working Days</th>
                    <th>Presents</th>
                    <th>Leaves</th>
                </tr>
            </thead>
            <tbody>
            <%
            for(AttendanceSummary s : list) {
            %>
                <tr>
                    <td><%= s.getEmployeeID() %></td>
                    <td><%= s.getEmployeeName() %></td>
                    <td>
                        <span class="badge working">
                            <%= s.getWorkingDays() %>
                        </span>
                    </td>
                    <td>
                        <span class="badge present">
                            <%= s.getPresents() %>
                        </span>
                    </td>
                    <td>
                        <span class="badge leave">
                            <%= s.getLeaves() %>
                        </span>
                    </td>
                </tr>
            <%
            }
            %>
            </tbody>
        </table>
    </div>

</div>

</body>
</html>
