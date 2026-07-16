<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Employee</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: #f4f7fb;
        padding: 20px;
    }

    h2 {
        text-align: center;
        color: #2c3e50;
    }

    form {
        width: 500px;
        margin: 0 auto;
        background: white;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0px 0px 10px #ccc;
    }

    label {
        display: block;
        margin-top: 10px;
        font-weight: bold;
    }

    input, select {
        width: 100%;
        padding: 8px;
        margin-top: 5px;
        border-radius: 4px;
        border: 1px solid #ccc;
    }

    /* ===== NAVY BLUE SUBMIT BUTTON ===== */
    input[type="submit"] {
        width: auto;
        background-color: #0a1f44;   /* Navy Blue */
        color: white;
        border: none;
        cursor: pointer;
        margin-top: 15px;
        padding: 10px 20px;
        border-radius: 4px;
        font-size: 15px;
    }

    input[type="submit"]:hover {
        background-color: #081a39;   /* Darker Navy */
    }

    .message {
        text-align: center;
        margin-bottom: 10px;
        font-weight: bold;
    }
</style>
</head>

<body>

<h2>Add Employee</h2>

<%
    String msg = request.getParameter("msg");
    if(msg != null){
        if(msg.equals("error")) {
%>
<div class="message" style="color:red;">Error adding employee. Try again!</div>
<%
        }
    }
%>

<form action="<%= request.getContextPath() %>/AddEmployeeServlet" method="post">

    <label for="employeeName">Full Name</label>
    <input type="text" id="employeeName" name="employeeName" required>

    <label for="gender">Gender</label>
    <select id="gender" name="gender">
        <option value="">Select Gender</option>
        <option value="Male">Male</option>
        <option value="Female">Female</option>
        <option value="Other">Other</option>
    </select>

    <label for="dob">Date of Birth</label>
    <input type="date" id="dob" name="dob">

    <label for="email">Email</label>
    <input type="email" id="email" name="email" required>

    <label for="phoneNo">Phone Number</label>
    <input type="text" id="phoneNo" name="phoneNo">

    <label for="role">Role</label>
    <input type="text" id="role" name="role">

    <label for="department">Department</label>
    <input type="text" id="department" name="department">

    <label for="salary">Salary</label>
    <input type="number" step="0.01" id="salary" name="salary">

    <input type="submit" value="Add Employee">

</form>

</body>
</html>
