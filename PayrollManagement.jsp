<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payroll Management</title>

    <style>
        body {
            margin: 0;
            font-family: "Segoe UI", Tahoma, sans-serif;
            background: linear-gradient(135deg, #eef2f7, #f9fbfd);
            color: #333;
        }

        .page-wrapper {
            max-width: 900px;
            margin: 60px auto;
            padding: 20px;
        }

        .page-header {
            background: linear-gradient(135deg, #2c5364, #1f4037);
            color: white;
            padding: 30px;
            border-radius: 16px;
            box-shadow: 0 14px 35px rgba(0,0,0,0.15);
            margin-bottom: 40px;
        }

        .page-header h2 {
            margin: 0;
            font-size: 26px;
            font-weight: 600;
        }

        .page-header p {
            margin-top: 8px;
            font-size: 14px;
            opacity: 0.9;
        }

        .form-card {
            background: rgba(255, 255, 255, 0.9);
            backdrop-filter: blur(10px);
            padding: 35px 40px;
            border-radius: 18px;
            box-shadow: 0 15px 40px rgba(0,0,0,0.08);
        }

        .form-group {
            margin-bottom: 22px;
        }

        label {
            display: block;
            font-size: 14px;
            font-weight: 600;
            margin-bottom: 6px;
            color: #1f2933;
        }

        input, select {
            width: 100%;
            padding: 12px 14px;
            border-radius: 8px;
            border: 1px solid #d1d5db;
            font-size: 14px;
            outline: none;
            transition: 0.2s;
        }

        input:focus, select:focus {
            border-color: #2c5364;
            box-shadow: 0 0 0 3px rgba(44,83,100,0.15);
        }

        button {
            margin-top: 10px;
            padding: 12px 30px;
            border: none;
            border-radius: 30px;
            background: linear-gradient(135deg, #2c5364, #1f4037);
            color: white;
            font-size: 14px;
            font-weight: 600;
            cursor: pointer;
            box-shadow: 0 10px 25px rgba(0,0,0,0.15);
            transition: all 0.3s ease;
        }

        button:hover {
            transform: translateY(-3px);
            box-shadow: 0 16px 35px rgba(0,0,0,0.25);
        }

        button:active {
            transform: scale(0.97);
        }
    </style>
</head>

<body>

<div class="page-wrapper">

    <div class="page-header">
        <h2>Generate Payroll</h2>
        <p>Create payroll for an employee</p>
    </div>

    <div class="form-card">
        <form action="PayrollServlet" method="post">

            <div class="form-group">
                <label>Employee ID</label>
                <input type="number" name="employeeID" required>
            </div>

            <div class="form-group">
                <label>Month</label>
                <select name="month">
                    <% for(int i=1;i<=12;i++){ %>
                        <option value="<%=i%>"><%=i%></option>
                    <% } %>
                </select>
            </div>

            <div class="form-group">
                <label>Year</label>
                <input type="number" name="year" value="2026">
            </div>

            <button type="submit">Generate Payroll</button>

        </form>
    </div>

</div>

</body>
</html>
