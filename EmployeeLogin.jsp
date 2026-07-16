<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Login</title>

<style>
body {
    margin: 0;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background: #f6f8fb;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}
.login-card {
    background: #fff;
    padding: 40px;
    width: 360px;
    border-radius: 12px;
    box-shadow: 0 10px 25px rgba(0,0,0,0.15);
    text-align: center;
}
.login-card h2 {
    margin-bottom: 25px;
}
.login-card input {
    width: 100%;
    padding: 12px;
    margin: 10px 0;
    border-radius: 8px;
    border: 1px solid #ccc;
}
.login-card button {
    width: 100%;
    padding: 12px;
    background: #2c3e50;
    color: white;
    border: none;
    border-radius: 8px;
    font-size: 16px;
    cursor: pointer;
}
.login-card button:hover {
    background: #1a252f;
}
.error {
    color: red;
    margin-top: 10px;
}
</style>
</head>

<body>

<div class="login-card">
    <h2>Employee Login</h2>

    <form action="<%=request.getContextPath()%>/EmployeeLoginServlet" method="post">
        <input type="number" name="employeeID" placeholder="Employee ID" required />
        <input type="email" name="email" placeholder="Email" required />
        <input type="password" name="password" placeholder="Password" required />
        <button type="submit">Login</button>
    </form>

    <div class="error">
        <%= request.getAttribute("error") == null ? "" : request.getAttribute("error") %>
    </div>
</div>

</body>
</html>
