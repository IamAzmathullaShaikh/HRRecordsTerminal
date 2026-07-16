<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.Model.ProjectTask" %>

<%
    List<ProjectTask> taskList =
        (List<ProjectTask>) request.getAttribute("taskList");
%>

<!DOCTYPE html>
<html>
<head>
    <title>My Project Tasks</title>
    <style>
        table {
            width: 90%;
            margin: auto;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ccc;
            text-align: center;
        }
        th {
            background-color: #f0f0f0;
        }
    </style>
</head>
<body>

<h2 align="center">My Project Tasks</h2>

<table>
    <tr>
        <th>Task Name</th>
        <th>Description</th>
        <th>Start Date</th>
        <th>Due Date</th>
        <th>Status</th>
        <th>Action</th>
    </tr>

<%
    if (taskList != null && !taskList.isEmpty()) {
        for (ProjectTask t : taskList) {
%>
    <tr>
        <td><%= t.getTaskName() %></td>
        <td><%= t.getDescription() %></td>
        <td><%= t.getStartDate() %></td>
        <td><%= t.getDueDate() %></td>
        <td><%= t.getStatus() %></td>
        <td>
            <% if (!"COMPLETED".equalsIgnoreCase(t.getStatus())) { %>
                <form action="UpdateTaskStatusServlet" method="post">
                    <input type="hidden" name="taskId" value="<%= t.getTaskId() %>">
                    <input type="submit" value="Mark Completed">
                </form>
            <% } else { %>
                ✔ Completed
            <% } %>
        </td>
    </tr>
<%
        }
    } else {
%>
    <tr>
        <td colspan="6">No tasks assigned</td>
    </tr>
<%
    }
%>

</table>

</body>
</html>
    