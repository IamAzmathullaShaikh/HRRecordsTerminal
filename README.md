# 🏢 HR Management System (HRMS)

A web-based Human Resource Management System built with **Java Servlets + JSP + MySQL**.  
It helps organizations manage employees, roles, payroll, attendance, tasks, and leave requests in one place.

---

## 👥 Who Uses This System?

### 1. Applicants
- Register online and track job applications.
- View status updates on recruitment progress.

### 2. Employees
- Log attendance and request leave.
- See assigned tasks and update progress.
- Check salary slips and payroll history.

### 3. Managers
- Assign tasks to employees.
- Monitor team performance.
- Run payroll for their teams.

### 4. HR Admins
- Add, update, or remove employee records.
- Assign roles and manage access rights.
- Audit attendance and run company-wide payroll.

---

## ⚙️ Tech Stack

| Layer        | Technology |
|--------------|------------|
| Frontend     | HTML, CSS, JSP |
| Backend      | Java Servlets |
| Database     | MySQL |
| Persistence  | JDBC + DAO Pattern |
| Architecture | MVC (Model-View-Controller) |
| Server       | Apache Tomcat |
---

---
## 📂 Detailed Project Structure

```text
OrganizationEmployeeDirectoryRoleAssignmentandHRRecordsMaintenance/
│
├── DBConnection/                 
│   └── Dbc.java                  # Handles MySQL database connection
│
├── Model/                        # Data models (POJOs)
│   ├── ApplicantModel.java       # Applicant details
│   ├── EmployeeDetails.java      # Employee profile info
│   ├── LeaveRequest.java         # Leave request entity
│   ├── PayrollDetails.java       # Payroll data
│   ├── ProjectTask.java          # Task assignment schema
│   └── AttendanceSummary.java    # Attendance tracking
│
├── DAO/                          # Interfaces for database operations
│   └── Dao.java                  # Defines CRUD methods
│
├── DAOImpl/                      # SQL implementations of DAO
│   └── DaoImpl.java              # Executes queries with JDBC
│
├── Servlet/                      # Controllers (business logic)
│   ├── Controller.java           # Central routing
│   ├── EmployeeLoginServlet.java # Handles employee login
│   ├── ManagerLoginServlet.java  # Handles manager login
│   ├── HRLoginServlet.java       # Handles HR login
│   ├── ApplyLeaveServlet.java    # Employee leave requests
│   ├── LeaveApprovalServlet.java # HR leave approvals
│   ├── AssignTaskServlet.java    # Manager assigns tasks
│   ├── UpdateTaskStatusServlet.java # Employee updates task status
│   ├── PayrollServlet.java       # Payroll processing
│   └── LogoutServlet.java        # Session termination
│
├── Web Pages (root JSP/HTML files)
│   ├── index.html                # Landing page
│   ├── login.html                # Login portal
│   ├── register.html             # Registration page
│   ├── HomePage.jsp              # Main dashboard
│   ├── ApplicantDashboard.jsp    # Applicant workspace
│   ├── EmployeeDashboard.jsp     # Employee workspace
│   ├── ManagerDashboard.jsp      # Manager workspace
│   ├── HRDashboard.jsp           # HR workspace
│   ├── addEmployee.jsp           # Add employee form
│   ├── updateEmployee.jsp        # Update employee form
│   ├── EmployeeDetails.jsp       # Employee profile view
│   ├── EmployeeList.jsp          # Employee list view
│   ├── AssignProjectTask.jsp     # Task assignment UI
│   ├── EmployeeTasks.jsp         # Employee task list
│   ├── applyLeave.jsp            # Leave request form
│   ├── employeeLeaveStatus.jsp   # Employee leave status
│   ├── HRLeaveList.jsp           # HR leave approvals
│   ├── employeeAttendance.jsp    # Employee attendance
│   ├── hrAttendance.jsp          # HR attendance audit
│   ├── PayrollManagement.jsp     # Payroll processing
│   ├── PayrollResult.jsp         # Payroll results
│   ├── PerformanceReport.jsp     # Performance reports
│   └── OrgHierarchy.jsp          # Organizational chart
│
├── README.md                     # Documentation
└── pom.xml / build.gradle        # (Optional) Build configuration if using Maven/Gradle

```

---

📊 HRMS Architecture Flow

                ┌─────────────────────┐
                │       Browser        │
                │ (Applicant/Employee/ │
                │  Manager/HR User)    │
                └─────────┬───────────┘
                          │
                          ▼
                ┌─────────────────────┐
                │        Views         │
                │  JSP / HTML Pages    │
                │ (login.jsp, apply-   │
                │ leave.jsp, etc.)     │
                └─────────┬───────────┘
                          │  (Form submits / links)
                          ▼
                ┌─────────────────────┐
                │     Controllers      │
                │   Java Servlets      │
                │ (LoginServlet,       │
                │ ApplyLeaveServlet,   │
                │ AssignTaskServlet…)  │
                └─────────┬───────────┘
                          │  (Business logic)
                          ▼
                ┌─────────────────────┐
                │   DAO Interfaces     │
                │ (Dao.java)           │
                └─────────┬───────────┘
                          │
                          ▼
                ┌─────────────────────┐
                │ DAO Implementations  │
                │ (DaoImpl.java)       │
                │ Executes SQL queries │
                └─────────┬───────────┘
                          │
                          ▼
                ┌─────────────────────┐
                │   Database Layer     │
                │      MySQL           │
                │ (employees, leaves,  │
                │ payroll, tasks…)     │
                └─────────────────────┘
---

---

## 🚀 Getting Started (Local Setup)

### Prerequisites
- Install **JDK 8+**
- Install **MySQL 8+**
- Install **Apache Tomcat 9+**
- Use an IDE like **Eclipse** or **IntelliJ IDEA**

### Step 1: Database Setup
Open MySQL and run:
```sql
CREATE DATABASE hrms_db;
USE hrms_db;

CREATE TABLE employees (
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100) UNIQUE,
    role VARCHAR(50),
    salary DECIMAL(10,2),
    hire_date DATE
);
```
*(Add more tables for applicants, leaves, attendance, tasks, payroll as needed.)*

### Step 2: Configure Database Connection
Edit `DBConnection/Dbc.java`:
```java
con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/hrms_db",
    "YOUR_USERNAME",
    "YOUR_PASSWORD"
);
```

### Step 3: Run on Tomcat
1. Import project into your IDE.
2. Set Tomcat as the runtime.
3. Run the project on server.
4. Open:  
   ```
   http://localhost:8080/OrganizationEmployeeDirectoryRoleAssignmentandHRRecordsMaintenance/
   ```

---

## 🔄 Example Workflows

- **Add Employee**: HR → `addEmployee.jsp` → `AddEmployeeServlet.java` → Database via `DaoImpl.java`
- **Assign Task**: Manager → `AssignProjectTask.jsp` → `AssignTaskServlet.java` → Employee updates via `UpdateTaskStatusServlet.java`
- **Leave Request**: Employee → `applyLeave.jsp` → `ApplyLeaveServlet.java` → HR reviews in `HRLeaveList.jsp`

---

## 📌 Git Workflow

```bash
# Check changes
git status

# Stage README
git add README.md

# Commit
git commit -m "docs: add beginner-friendly README with setup guide"

# Push to GitHub
git push origin main
```

---
