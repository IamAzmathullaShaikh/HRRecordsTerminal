<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>HR Dashboard</title>

<link rel="stylesheet"
 href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

<style>
body {
  margin: 0;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  background-color: #f6f8fb;
  color: #2c3e50;
}

/* ===== HEADER ===== */
header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: #2c3e50;
  color: white;
  padding: 15px 40px;
  position: sticky;
  top: 0;
  z-index: 100;
}

header h1 {
  margin: 0;
  font-size: 22px;
}

/* ===== MENU ===== */
.menu {
  position: relative;
}

.menu-icon {
  font-size: 22px;
  cursor: pointer;
}

.menu-dropdown {
  display: none;
  position: absolute;
  right: 0;
  top: 35px;
  background: #fff;
  color: #2c3e50;
  min-width: 160px;
  border-radius: 8px;
  box-shadow: 0 8px 20px rgba(0,0,0,0.2);
  overflow: hidden;
}

.menu-dropdown a {
  display: block;
  padding: 12px 16px;
  text-decoration: none;
  color: #2c3e50;
  font-weight: 600;
}

.menu-dropdown a:hover {
  background: #f0f0f0;
}

/* ===== DASHBOARD ===== */
h2 { text-align:center; margin-top:20px; }

.dashboard-container {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 30px;
  max-width: 1200px;
  margin: 40px auto;
}

.container-box {
  background-color: #fff;
  border-radius: 12px;
  box-shadow: 0 8px 20px rgba(0,0,0,0.1);
  padding: 40px 20px;
  text-align: center;
  cursor: pointer;
  transition: transform 0.3s;
}

.container-box:hover {
  transform: translateY(-5px);
}

.container-box i {
  font-size: 50px;
  margin-bottom: 15px;
}

.container-box h3 {
  margin: 0;
  font-size: 18px;
}

.icon-employee { color: #3498db; }
.icon-role { color: #e67e22; }
.icon-attendance { color: #2ecc71; }
.icon-payroll { color: #9b59b6; }
.icon-hierarchy { color: #e74c3c; }

@media(max-width:900px){
  .dashboard-container { grid-template-columns: 1fr 1fr; }
}
@media(max-width:600px){
  .dashboard-container { grid-template-columns: 1fr; }
}
</style>

<script>
function toggleMenu() {
  const menu = document.getElementById("menuDropdown");
  menu.style.display = menu.style.display === "block" ? "none" : "block";
}

window.onclick = function(event) {
  if (!event.target.matches('.menu-icon')) {
    const menu = document.getElementById("menuDropdown");
    if (menu) menu.style.display = "none";
  }
}
</script>

</head>
<body>

<header>
  <h1>HR Dashboard</h1>

  <div class="menu">
    <i class="fas fa-bars menu-icon" onclick="toggleMenu()"></i>
    <div class="menu-dropdown" id="menuDropdown">
      <a href="<%= request.getContextPath() %>/profile.jsp">
        <i class="fas fa-user"></i> Profile
      </a>
      <a href="<%=request.getContextPath()%>/LogoutServlet">
    <i class="fas fa-sign-out-alt"></i> Logout
</a>
      
    </div>
  </div>
</header>

<h2>HR Dashboard</h2>

<div class="dashboard-container">

  <a href="<%= request.getContextPath() %>/EmployeeListServlet"
     style="text-decoration:none; color:inherit;">
    <div class="container-box">
      <i class="fas fa-users icon-employee"></i>
      <h3>Employee Records</h3>
    </div>
  </a>

  <a href="RoleAssignmentListServlet" style="text-decoration:none; color:inherit;">
    <div class="container-box">
      <i class="fas fa-user-tag icon-role"></i>
      <h3>Role Assignment</h3>
    </div>
  </a>

  <a href="<%= request.getContextPath() %>/HRAttendanceServlet"
     style="text-decoration:none; color:inherit;">
    <div class="container-box">
      <i class="fas fa-clock icon-attendance"></i>
      <h3>Attendance Tracking</h3>
    </div>
  </a>

 <div class="container-box"
 onclick="location.href='<%=request.getContextPath()%>/PayrollManagement.jsp'">
  <i class="fas fa-money-bill-wave icon-payroll"></i>
  <h3>Payroll Management</h3>
</div>
 
 <div class="container-box"
     onclick="location.href='<%=request.getContextPath()%>/HRPayrollServlet'">
  <i class="fas fa-file-invoice-dollar icon-payroll"></i>
  <h3>View Payroll</h3>
</div>
 
 <div class="container-box"
     onclick="location.href='<%=request.getContextPath()%>/ViewEmployeePerformanceServlet?employeeID=0&month=0&year=0'">
  <i class="fas fa-chart-line icon-payroll"></i>
  <h3>Employee Performance</h3>
</div>
 

  <a href="<%=request.getContextPath()%>/OrgHierarchyServlet"
     style="text-decoration:none; color:inherit;">
    <div class="container-box">
      <i class="fas fa-sitemap icon-hierarchy"></i>
      <h3>Organization Hierarchy</h3>
    </div>
  </a>

  <a href="<%= request.getContextPath() %>/LeaveApprovalServlet"
     style="text-decoration:none; color:inherit;">
    <div class="container-box">
      <i class="fas fa-plane-departure icon-attendance"></i>
      <h3>Leave Requests</h3>
    </div>
  </a>

</div>

</body>
</html>
