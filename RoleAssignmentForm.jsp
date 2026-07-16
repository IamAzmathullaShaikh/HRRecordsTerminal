<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    // Generate current timestamp
    java.time.LocalDateTime now = java.time.LocalDateTime.now();
%>

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
        display: flex;
        justify-content: center;
        padding: 40px;
    }

    .container {
        background: #fff;
        padding: 30px;
        border-radius: 12px;
        box-shadow: 0 8px 20px rgba(0,0,0,0.1);
        width: 520px;
    }

    h2 {
        text-align: center;
        color: #1f3c88;
        margin-bottom: 25px;
    }

    table {
        width: 100%;
        border-collapse: separate;
        border-spacing: 0 15px;
    }

    td:first-child {
        width: 40%;
        font-weight: 600;
    }

    input, select {
        width: 100%;
        padding: 10px;
        border-radius: 6px;
        border: 1px solid #ccc;
        font-size: 14px;
    }

    input[readonly] {
        background: #f0f0f0;
    }

    button {
        width: 100%;
        padding: 12px;
        background: #1f3c88;
        color: white;
        border: none;
        border-radius: 6px;
        font-size: 16px;
        cursor: pointer;
        margin-top: 15px;
    }

    button:hover {
        background: #162c66;
    }
</style>
</head>

<body>

<div class="container">
    <h2>Role Assignment</h2>

    <form action="RoleAssignmentServlet" method="post">
        <table>

            <tr>
                <td>Employee ID</td>
                <td>
                    <input type="number" name="employeeID"
                           placeholder="Enter Employee ID" required>
                </td>
            </tr>

            <tr>
                <td>Role</td>
                <td>
                    <select name="role" required>
                        <option value="">-- Select Role --</option>
                        <option value="Java Developer">Java Developer</option>
                        <option value="Cybersecurity">Cybersecurity</option>
                        <option value="HR">HR</option>
                        <option value="Manager">Manager</option>
                    </select>
                </td>
            </tr>

            <tr>
                <td>Department</td>
                <td>
                    <select name="department" required>
                        <option value="">-- Select Department --</option>
                        <option value="IT">IT</option>
                        <option value="CSE">CSE</option>
                        <option value="HR">HR</option>
                    </select>
                </td>
            </tr>

            

            <tr>
                <td colspan="2">
                    <button type="submit">Assign Role</button>
                </td>
            </tr>

        </table>
    </form>
</div>

</body>
</html>
