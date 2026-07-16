
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    HttpSession sess = request.getSession(false);
    if (sess == null || sess.getAttribute("employee") == null) {
        response.sendRedirect(request.getContextPath() + "/EmployeeLogin.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Employee Dashboard</title>

<link rel="stylesheet"
 href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

<style>
/* ===== GLOBAL ===== */
body {
    margin: 0;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background-color: #f6f8fb;
    color: #2c3e50;
}

/* ===== HEADER ===== */
.header {
    background-color: #2c3e50;
    color: white;
    padding: 15px 40px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    position: sticky;
    top: 0;
    z-index: 100;
}

.header h1 {
    margin: 0;
    font-size: 22px;
}

/* ===== HEADER ACTIONS ===== */
.header-actions {
    display: flex;
    align-items: center;
    gap: 15px;
}

/* ===== PRESENT BUTTON ===== */
.present-btn {
    background-color: #2ecc71;
    border: none;
    padding: 10px 22px;
    color: white;
    font-size: 14px;
    border-radius: 8px;
    cursor: pointer;
    font-weight: 600;
}

.present-btn:hover {
    background-color: #27ae60;
}

/* ===== LEAVE STATUS BUTTON ===== */
.leave-status-btn {
    background-color: #3498db;
    border: none;
    padding: 10px 22px;
    color: white;
    font-size: 14px;
    border-radius: 8px;
    cursor: pointer;
    font-weight: 600;
}

.leave-status-btn:hover {
    background-color: #1d6fa5;
}

/* ===== MENU ===== */
.menu {
    position: relative;
}

.menu-icon {
    font-size: 22px;
    cursor: pointer;
}

.menu-content {
    display: none;
    position: absolute;
    right: 0;
    top: 35px;
    background-color: white;
    min-width: 160px;
    box-shadow: 0 8px 20px rgba(0,0,0,0.2);
    border-radius: 8px;
    overflow: hidden;
}

.menu-content a {
    display: block;
    padding: 12px 16px;
    text-decoration: none;
    color: #2c3e50;
    font-weight: 600;
}

.menu-content a:hover {
    background-color: #f2f2f2;
}

/* ===== DASHBOARD GRID ===== */
.dashboard {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
    gap: 30px;
    padding: 40px;
}

/* ===== CARDS ===== */
.card {
    background-color: #fff;
    border-radius: 14px;
    box-shadow: 0 8px 20px rgba(0,0,0,0.1);
    padding: 30px 25px;
    cursor: pointer;
}

.card:hover {
    transform: translateY(-5px);
}

.card h2 {
    margin-top: 0;
    font-size: 18px;
}

.card p {
    font-size: 14px;
    color: #555;
}
</style>

<script>
function toggleMenu() {
    const menu = document.getElementById("menuContent");
    menu.style.display = menu.style.display === "block" ? "none" : "block";
}

window.onclick = function(event) {
    if (!event.target.matches('.menu-icon')) {
        const menu = document.getElementById("menuContent");
        if (menu) menu.style.display = "none";
    }
}
</script>

</head>

<body>

<!-- ===== HEADER ===== -->
<div class="header">
    <h1>Employee Dashboard</h1>

    <div class="header-actions">

        <form action="MarkAttendanceServlet" method="post">
            <button type="submit" class="present-btn">
                <i class="fas fa-check"></i> Present
            </button>
        </form>

        <form action="<%=request.getContextPath()%>/EmployeeLeaveStatusServlet" method="get">
            <button type="submit" class="leave-status-btn">
                <i class="fas fa-calendar-alt"></i> Leave Status
            </button>
        </form>

        <!-- MENU -->
        <div class="menu">
            <i class="fas fa-bars menu-icon" onclick="toggleMenu()"></i>
            <div class="menu-content" id="menuContent">
                <a href="LogoutServlet">
                    <i class="fas fa-sign-out-alt"></i> Logout
                </a>
            </div>
        </div>

    </div>
</div>

<!-- ===== DASHBOARD ===== -->
<div class="dashboard">

    <div class="card" onclick="location.href='EmployeeDetailsServlet'">
        <h2><i class="fas fa-user"></i> Employee Details</h2>
        <p>View your personal information.</p>
    </div>

    <div class="card" onclick="location.href='EmployeeAttendanceServlet'">
        <h2><i class="fas fa-calendar-check"></i> Attendance</h2>
        <p>Mark or view attendance.</p>
    </div>

    <div class="card" onclick="location.href='EmployeePayrollServlet'">
        <h2><i class="fas fa-money-bill-wave"></i> Payroll</h2>
        <p>Salary and payment history.</p>
    </div>

	<div class="card"
     onclick="location.href='<%= request.getContextPath() %>/EmployeeTasksServlet'">
    <h2><i class="fas fa-tasks"></i> My Tasks</h2>
    <p>View and complete assigned tasks</p>
</div>

	<div class="card"
     onclick="location.href='<%=request.getContextPath()%>/ViewEmployeePerformanceServlet'">
    <h2><i class="fas fa-chart-line"></i> My Performance</h2>
    <p>View your performance report</p>
</div>
	
	
    <div class="card" onclick="location.href='OrgHierarchyServlet'">
        <h2><i class="fas fa-sitemap"></i> Organization</h2>
        <p>View hierarchy.</p>
    </div>

    <div class="card" onclick="location.href='applyLeave.jsp'">
        <h2><i class="fas fa-plane-departure"></i> Apply Leave</h2>
        <p>Request leave.</p>
    </div>

</div>

</body>
</html>
