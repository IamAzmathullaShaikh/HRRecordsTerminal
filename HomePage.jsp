<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HR Application</title>

    <style>
        body {
            margin: 0;
            font-family: "Segoe UI", Tahoma, sans-serif;
            background: #f4f7fb;
        }

        /* Header */
        .app-header {
            background: #2c3e50;
            color: white;
            padding: 25px 40px;
            text-align: center;
        }

        .app-header h1 {
            margin: 0;
            font-size: 24px;
            font-weight: 600;
        }

        .app-header p {
            margin-top: 8px;
            font-size: 14px;
            color: #dcdde1;
        }

        .container {
            text-align: center;
            max-width: 1100px;
            margin: 50px auto;
            padding: 0 20px;
        }

        .container h2 {
            color: #2c3e50;
        }

        .container p {
            color: #666;
            margin-bottom: 40px;
        }

        .roles {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(230px, 1fr));
            gap: 30px;
        }

        .card {
            background: white;
            border-radius: 14px;
            padding: 35px 25px;
            box-shadow: 0 10px 25px rgba(0,0,0,0.08);
            transition: 0.3s;
        }

        .card:hover {
            transform: translateY(-10px);
            box-shadow: 0 14px 30px rgba(0,0,0,0.12);
        }

        .icon {
            font-size: 42px;
            margin-bottom: 15px;
        }

        h3 {
            color: #333;
        }

        button {
            margin-top: 18px;
            padding: 10px 20px;
            border: none;
            border-radius: 6px;
            background: #2c3e50;
            color: white;
            font-size: 14px;
            cursor: pointer;
        }

        button:hover {
            background: #1a252f;
        }
    </style>
</head>

<body>

<div class="app-header">
    <h1>Organizational Employee Directory, Role Assignment and HR Records Maintenance Application</h1>
    <p>Centralized HR Management System</p>
</div>

<div class="container">
    <h2>Select Your Role</h2>
    <p>Please choose your role to continue</p>

    <div class="roles">
        <div class="card">
            <div class="icon">👩‍💼</div>
            <h3>HR</h3>
            <p>Manage employees and HR records</p>
            <button onclick="location.href='<%= request.getContextPath() %>/HRLogin.jsp'">Login</but 
            ton>
        </div>

        <div class="card">
            <div class="icon">🧑‍💼</div>
            <h3>Manager</h3>
            <p>Manage team and approvals</p>
            <button onclick="location.href='<%= request.getContextPath() %>/ManagerLogin.jsp'">Login</button>
        </div>

        <div class="card">
            <div class="icon">👨‍💻</div>
            <h3>Employee</h3>
            <p>View profile and tasks</p>
            <button onclick="location.href='<%= request.getContextPath() %>/EmployeeLogin.jsp'">Login</button>
        </div>

        <div class="card">
            <div class="icon">📝</div>
            <h3>Applicant</h3>
            <p>Apply for jobs</p>
            <button onclick="location.href='<%= request.getContextPath() %>/Applicantlogin.html'">Apply Now</button>
        </div>
    </div>
</div>

</body>
</html>
