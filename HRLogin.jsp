<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login - Organization</title>

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
    padding: 40px 35px;
    width: 350px;
    border-radius: 12px;
    box-shadow: 0 10px 25px rgba(44, 62, 80, 0.15);
    text-align: center;
  }

  .login-card h2 {
    margin-bottom: 25px;
    font-weight: 700;
    font-size: 24px;
    color: #22303c;
  }

  .login-card input[type="text"],
  .login-card input[type="password"] {
    width: 100%;
    padding: 12px 14px;
    margin: 12px 0;
    border: 1.5px solid #ced6e0;
    border-radius: 8px;
    font-size: 16px;
  }

  .login-card input:focus {
    outline: none;
    border-color: #2c3e50;
    box-shadow: 0 0 6px rgba(44, 62, 80, 0.3);
  }

  .login-card button {
    width: 100%;
    padding: 12px;
    background-color: #2c3e50;
    color: white;
    border: none;
    border-radius: 8px;
    font-weight: 600;
    font-size: 18px;
    cursor: pointer;
    margin-top: 18px;
  }

  .login-card button:hover {
    background-color: #1a252f;
  }

  .login-card p {
    margin-top: 18px;
    font-size: 14px;
    color: #7a8a99;
  }

  .login-card a {
    color: #2c3e50;
    font-weight: 600;
    text-decoration: none;
  }

  .login-card a:hover {
    text-decoration: underline;
  }
</style>
</head>
<body>

<div class="login-card">
  <h2>Login</h2>

  <form action="<%= request.getContextPath() %>/HRDashboard.jsp" method="post">
    <input type="text" name="email" placeholder="Email" required />
    <input type="password" name="password" placeholder="Password" required />
    <button type="submit">Login</button>
  </form>

  <p>
    New user?
    <a href="<%= request.getContextPath() %>/HRregistration.jsp">Register here</a>
  </p>
</div>

</body>
</html>
