<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    String id = request.getParameter("id");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Update Employee</title>

<style>
body {
    margin: 0;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background: #f6f8fb;
    display: flex;
    justify-content: center;
    padding: 30px;
}

.container {
    background: #fff;
    padding: 30px;
    width: 450px;
    border-radius: 12px;
    box-shadow: 0 4px 12px rgba(0,0,0,0.1);
}

h2 {
    text-align: center;
    margin-bottom: 25px;
    color: #1e2a5b;
}

label {
    font-weight: 600;
    display: block;
    margin-bottom: 6px;
}

input, select {
    width: 100%;
    padding: 10px;
    margin-bottom: 18px;
    border: 1px solid #ccc;
    border-radius: 6px;
    font-size: 14px;
}

button {
    width: 100%;
    background: #0b1f44;
    color: white;
    border: none;
    padding: 12px;
    border-radius: 6px;
    font-size: 15px;
    cursor: pointer;
}

button:hover {
    background: #081734;
}
</style>
</head>

<body>

<div class="container">
<h2>Update Employee</h2>

<form action="UpdateEmployeeServlet" method="post">

    <!-- Hidden Employee ID -->
    <input type="hidden" name="employeeID" value="<%= id %>">

    <label>Full Name</label>
    <input type="text" name="employeeName" placeholder="Enter full name" required>

    <label>Gender</label>
    <select name="gender" required>
        <option value="">Select Gender</option>
        <option value="Male">Male</option>
        <option value="Female">Female</option>
        <option value="Other">Other</option>
    </select>

    <label>Date of Birth</label>
    <input type="date" name="dob" required>

    <label>Email</label>
    <input type="email" name="email" placeholder="Enter email" required>

    <label>Phone Number</label>
    <input type="text" name="phoneNo" placeholder="Enter phone number" required>

    <label>Role</label>
    <input type="text" name="role" placeholder="Enter role">

    <label>Department</label>
    <input type="text" name="department" placeholder="Enter department">

    <label>Salary</label>
    <input type="number" step="0.01" name="salary" placeholder="Enter salary" required>

    <button type="submit">Update Employee</button>
</form>

</div>

</body>
</html>
