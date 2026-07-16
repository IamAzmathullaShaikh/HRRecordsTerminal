<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Assign Project Task</title>

<style>
/* ===== Base ===== */
body {
    font-family: "Segoe UI", Tahoma, sans-serif;
    background: linear-gradient(135deg, #f5f7fa, #eef2f7);
    margin: 0;
    padding: 40px;
    color: #1f2933;
    overflow-x: hidden;
}

/* ===== Decorative background circles ===== */
.bg-circle {
    position: fixed;
    border-radius: 50%;
    filter: blur(60px);
    opacity: 0.4;
    z-index: -1;
    animation: float 8s ease-in-out infinite;
}

.circle1 {
    width: 260px;
    height: 260px;
    background: #a7f3d0;
    top: 80px;
    left: -100px;
}

.circle2 {
    width: 320px;
    height: 320px;
    background: #bfdbfe;
    bottom: 60px;
    right: -120px;
    animation-delay: 3s;
}

/* Floating animation */
@keyframes float {
    0% { transform: translateY(0); }
    50% { transform: translateY(-25px); }
    100% { transform: translateY(0); }
}

/* ===== Title ===== */
h2 {
    text-align: center;
    margin-bottom: 30px;
    font-size: 28px;
    font-weight: 700;
    animation: fadeDown 0.8s ease;
}

@keyframes fadeDown {
    from {
        opacity: 0;
        transform: translateY(-15px);
    }
    to {
        opacity: 1;
        transform: translateY(0);
    }
}

/* ===== Form Card ===== */
.form-card {
    width: 420px;
    margin: auto;
    background: rgba(255,255,255,0.9);
    padding: 30px;
    border-radius: 16px;
    box-shadow: 0 20px 40px rgba(0,0,0,0.1);
    backdrop-filter: blur(10px);
    animation: scaleIn 0.7s ease;
}

@keyframes scaleIn {
    from {
        opacity: 0;
        transform: scale(0.95);
    }
    to {
        opacity: 1;
        transform: scale(1);
    }
}

/* ===== Labels & Inputs ===== */
label {
    font-weight: 600;
    margin-bottom: 6px;
    display: block;
}

input, textarea {
    width: 100%;
    padding: 11px 12px;
    margin-bottom: 16px;
    border-radius: 10px;
    border: 1px solid #d1d5db;
    font-size: 14px;
    font-family: inherit;
    transition: all 0.25s ease;
}

input:focus,
textarea:focus {
    outline: none;
    border-color: #2c5364;
    box-shadow: 0 0 0 3px rgba(44,83,100,0.18);
    transform: translateY(-1px);
}

textarea {
    resize: vertical;
    min-height: 80px;
}

/* ===== Submit Button ===== */
input[type=submit] {
    background: linear-gradient(135deg, #1f4037, #2c5364);
    color: white;
    border: none;
    padding: 13px;
    border-radius: 12px;
    font-size: 15px;
    font-weight: 600;
    cursor: pointer;
    transition: all 0.3s ease;
}

input[type=submit]:hover {
    transform: translateY(-3px);
    box-shadow: 0 14px 30px rgba(0,0,0,0.2);
}

input[type=submit]:active {
    transform: translateY(0);
}
</style>

</head>
<body>

<!-- Decorative graphics -->
<div class="bg-circle circle1"></div>
<div class="bg-circle circle2"></div>

<h2>Assign Project Task</h2>

<div class="form-card">
<form action="AssignTaskServlet" method="post">

    <label>Employee ID</label>
    <input type="number" name="employeeID" required>

    <label>Task Name</label>
    <input type="text" name="taskName" required>

    <label>Description</label>
    <textarea name="description" required></textarea>

    <label>Start Date</label>
    <input type="date" name="startDate" required>

    <label>Due Date</label>
    <input type="date" name="dueDate" required>

    <input type="submit" value="Assign Task">

</form>
</div>

</body>
</html>
