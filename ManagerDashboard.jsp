<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manager Dashboard</title>

<link rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

<style>
body {
    margin: 0;
    font-family: "Segoe UI", Arial, sans-serif;
    background: #f4f6f9;
}

/* ===== Header ===== */
.header {
    background: #2f4154;
    color: #fff;
    padding: 14px 30px;
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.header h2 {
    margin: 0;
    font-size: 20px;
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
    background-color: #fff;
    min-width: 160px;
    box-shadow: 0 8px 20px rgba(0,0,0,0.2);
    border-radius: 8px;
    overflow: hidden;
}

.menu-content a {
    display: block;
    padding: 12px 16px;
    text-decoration: none;
    color: #2f4154;
    font-weight: 600;
}

.menu-content a:hover {
    background-color: #f2f2f2;
}

/* ===== Title ===== */
.page-title {
    text-align: center;
    font-size: 26px;
    font-weight: 600;
    margin: 25px 0 20px;
    color: #2f4154;
}

/* ===== Dashboard Cards ===== */
.dashboard {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
    gap: 35px;
    padding: 0 60px 60px;
}

.card {
    background: #fff;
    border-radius: 16px;
    padding: 40px 20px;
    text-align: center;
    box-shadow: 0 8px 20px rgba(0,0,0,0.08);
    cursor: pointer;
    transition: 0.25s;
}

.card:hover {
    transform: translateY(-6px);
}

.icon-circle {
    width: 70px;
    height: 70px;
    border-radius: 50%;
    margin: 0 auto 20px;
    display: flex;
    align-items: center;
    justify-content: center;
    color: #fff;
    font-size: 30px;
}

.blue { background: #3498db; }
.green { background: #2ecc71; }
.purple { background: #9b59b6; }
.orange { background: #e67e22; }

.card h3 {
    margin-bottom: 8px;
    color: #2f4154;
}

.card p {
    font-size: 14px;
    color: #6c7a89;
}
</style>

<script>
function toggleMenu() {
    const menu = document.getElementById("menuContent");
    menu.style.display = (menu.style.display === "block") ? "none" : "block";
}

window.onclick = function(event) {
    if (!event.target.matches('.menu-icon')) {
        const menu = document.getElementById("menuContent");
        if (menu) {
            menu.style.display = "none";
        }
    }
}
</script>

</head>

<body>

<!-- ===== Header ===== -->
<div class="header">
    <h2>Manager Dashboard</h2>

    <div class="menu">
        <i class="fas fa-bars menu-icon" onclick="toggleMenu()"></i>
        <div class="menu-content" id="menuContent">
            <a href="<%= request.getContextPath() %>/LogoutServlet">
                <i class="fas fa-sign-out-alt"></i> Logout
            </a>
        </div>
    </div>
</div>

<!-- ===== Title ===== -->
<div class="page-title">Manager Dashboard</div>

<!-- ===== Dashboard Cards ===== -->
<div class="dashboard">

    <div class="card"
         onclick="location.href='<%= request.getContextPath() %>/EmployeeListServlet'">
        <div class="icon-circle blue">
            <i class="fas fa-users"></i>
        </div>
        <h3>Employee Records</h3>
        <p>View employee details</p>
    </div>

    <div class="card"
         onclick="location.href='<%= request.getContextPath() %>/HRAttendanceServlet'">
        <div class="icon-circle green">
            <i class="fas fa-clock"></i>
        </div>
        <h3>Attendance Tracking</h3>
        <p>View team attendance</p>
    </div>

    <div class="card"
         onclick="location.href='<%= request.getContextPath() %>/ManagerPayrollServlet'">
        <div class="icon-circle purple">
            <i class="fas fa-money-bill-wave"></i>
        </div>
        <h3>Payroll Management</h3>
        <p>Salary & payroll info</p>
    </div>

	<div class="card"
     onclick="location.href='AssignProjectTask.jsp'">
    <div class="icon-circle blue">
        <i class="fas fa-tasks"></i>
    </div>
    <h3>Assign Tasks</h3>
    <p>Assign project tasks to employees</p>
</div>
	
	<div class="card"
     onclick="location.href='<%=request.getContextPath()%>/ViewEmployeePerformanceServlet?employeeID=0&month=0&year=0'">
    <div class="icon-circle purple">
        <i class="fas fa-chart-line"></i>
    </div>
    <h3>Employee Performance</h3>
    <p>View task-based performance</p>
</div>
	

    <div class="card"
         onclick="location.href='<%= request.getContextPath() %>/OrgHierarchyServlet'">
        <div class="icon-circle orange">
            <i class="fas fa-sitemap"></i>
        </div>
        <h3>Organization Hierarchy</h3>
        <p>Reporting structure</p>
    </div>

</div>

</body>
</html>
