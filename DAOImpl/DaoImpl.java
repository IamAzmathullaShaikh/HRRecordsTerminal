package com.DAOImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.Model.PayrollDetails;
import com.Model.ProjectTask;
import com.Model.HRregisterModel;
import com.Model.LeaveRequest;
import com.Model.ApplicantModel;
import com.Model.AttendanceSummary;
import com.Model.EmployeeDetails;
import com.Model.ManagerModel;
import com.Model.RoleAssignment;
import com.Model.EmployeeModel;
import com.Model.EmployeePerformance;
import com.DAO.Dao;
import com.DBConnection.Dbc;

public class DaoImpl implements Dao {

    // Register normal user
    public boolean registerUser(HRregisterModel user) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Dbc.getConnection();
            String sql = "INSERT INTO Register(firstName, lastName, gender, dob, maritalStatus, country, phno, email, password) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);

            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getGender());
            ps.setString(4, user.getDob());
            ps.setString(5, user.getMaritalStatus());
            ps.setString(6, user.getCountry());
            ps.setString(7, user.getPhno());
            ps.setString(8, user.getEmail());
            ps.setString(9, user.getPassword());

            int rows = ps.executeUpdate();
            if (rows > 0) status = true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (ps != null) ps.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
        return status;
    }

    // Register applicant
    public boolean registerApplicant(ApplicantModel applicant) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Dbc.getConnection();
            String sql = "INSERT INTO Applicant(fullName, lastName, gender, dob, maritalStatus, country, phno, email, password, resume, jobTitle, passoutYear) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);

            ps.setString(1, applicant.getFirstName());
            ps.setString(2, applicant.getLastName());
            ps.setString(3, applicant.getGender());
            ps.setString(4, applicant.getDob());
            ps.setString(5, applicant.getMaritalStatus());
            ps.setString(6, applicant.getCountry());
            ps.setString(7, applicant.getPhno());
            ps.setString(8, applicant.getEmail());
            ps.setString(9, applicant.getPassword());
            ps.setString(10, applicant.getResume());
            ps.setString(11, applicant.getJobTitle());
            ps.setInt(12, applicant.getPassoutYear());

            int rows = ps.executeUpdate();
            if (rows > 0) status = true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (ps != null) ps.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
        return status;
    }

    // Register manager
    public boolean registerManager(ManagerModel manager) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Dbc.getConnection();
            String sql = "INSERT INTO Manager(firstName, lastName, gender, dob, maritalStatus, country, phno, email, password,department) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            ps = conn.prepareStatement(sql);

            ps.setString(1, manager.getFirstName());
            ps.setString(2, manager.getLastName());
            ps.setString(3, manager.getGender());
            ps.setString(4, manager.getDob());
            ps.setString(5, manager.getMaritalStatus());
            ps.setString(6, manager.getCountry());
            ps.setString(7, manager.getPhno());
            ps.setString(8, manager.getEmail());
            ps.setString(9, manager.getPassword());
            ps.setString(10, manager.getDepartment());
            
            int rows = ps.executeUpdate();
            if (rows > 0) status = true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (ps != null) ps.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
        return status;
    }

    // Register employee
    public boolean registerEmployee(EmployeeModel employee) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Dbc.getConnection();
            String sql = "INSERT INTO Employee(firstName, lastName, gender, dob, maritalStatus, country, phno, email, password) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);

            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getGender());
            ps.setString(4, employee.getDob());
            ps.setString(5, employee.getMaritalStatus());
            ps.setString(6, employee.getCountry());
            ps.setString(7, employee.getPhno());
            ps.setString(8, employee.getEmail());
            ps.setString(9, employee.getPassword());

            int rows = ps.executeUpdate();
            if (rows > 0) status = true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (ps != null) ps.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
        return status;
    }

    // Login normal user
    public boolean loginUser(String email, String password) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = Dbc.getConnection();
            String sql = "SELECT * FROM Register WHERE email=? AND password=?";
            ps = conn.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            rs = ps.executeQuery();
            if (rs.next()) status = true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (ps != null) ps.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
        return status;
    }

    // Login manager
    public boolean loginManager(String email, String password) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = Dbc.getConnection();
            String sql = "SELECT * FROM Manager WHERE email=? AND password=?";
            ps = conn.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            rs = ps.executeQuery();
            if (rs.next()) status = true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (ps != null) ps.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
        return status;
    }
    
    @Override
    public EmployeeDetails loginEmployee(int employeeID, String email, String password) {

        EmployeeDetails emp = null;

        try (Connection con = Dbc.getConnection()) {

            // Step 1: Validate login
            PreparedStatement ps1 = con.prepareStatement(
                "SELECT * FROM Employee WHERE Id=? AND email=? AND password=?"
            );
            ps1.setInt(1, employeeID);
            ps1.setString(2, email);
            ps1.setString(3, password);

            ResultSet rs1 = ps1.executeQuery();

            if (!rs1.next()) {
                return null; // invalid login
            }

            // Step 2: Fetch employee details
            PreparedStatement ps2 = con.prepareStatement(
                "SELECT * FROM EmployeeDetails WHERE employeeID=?"
            );
            ps2.setInt(1, employeeID);

            ResultSet rs2 = ps2.executeQuery();

            if (rs2.next()) {
                emp = new EmployeeDetails();
                emp.setEmployeeID(rs2.getInt("employeeID"));
                emp.setEmployeeName(rs2.getString("employeeName"));
                emp.setEmail(rs2.getString("email"));
                emp.setDepartment(rs2.getString("department"));
                emp.setRole(rs2.getString("role"));
                emp.setSalary(rs2.getDouble("salary"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return emp;
    }


    // Login employee
//    public boolean loginEmployee(String email, String password) {
//        boolean status = false;
//        Connection conn = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//
//        try {
//            conn = Dbc.getConnection();
//            String sql = "SELECT * FROM Employee WHERE email=? AND password=?";
//            ps = conn.prepareStatement(sql);
//
//            ps.setString(1, email);
//            ps.setString(2, password);
//
//            rs = ps.executeQuery();
//            if (rs.next()) status = true;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try { if (rs != null) rs.close(); } catch (Exception e) {}
//            try { if (ps != null) ps.close(); } catch (Exception e) {}
//            try { if (conn != null) conn.close(); } catch (Exception e) {}
//        }
//        return status;
//    }

//	private boolean EmployeeDetails(EmployeeDetails e) {
//		// TODO Auto-generated method stub
//		return false;
//	}
	
	@Override
    public boolean addEmployee(EmployeeDetails e) {
        try (Connection con = Dbc.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO EmployeeDetails(employeeName, gender, dob, email, phoneNo, role, department, salary,status) " +
                "VALUES(?,?,?,?,?,?,?,?,?)"
            );
            ps.setString(1, e.getEmployeeName());
            ps.setString(2, e.getGender());
            ps.setString(3, e.getDob());
            ps.setString(4, e.getEmail());
            ps.setString(5, e.getPhoneNo());
            ps.setString(6, e.getRole());
            ps.setString(7, e.getDepartment());
            ps.setDouble(8, e.getSalary());
            ps.setString(9,"ACTIVE");
            return ps.executeUpdate() > 0;
        } catch(Exception ex) { ex.printStackTrace(); }
        return false;
    }

    @Override
    public boolean updateEmployee(EmployeeDetails e) {
        try (Connection con = Dbc.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "UPDATE EmployeeDetails SET employeeName=?, gender=?, dob=?, email=?, phoneNo=?, role=?, department=?, salary=? " +
                "WHERE employeeID=?"
            );
            ps.setString(1, e.getEmployeeName());
            ps.setString(2, e.getGender());
            ps.setString(3, e.getDob());
            ps.setString(4, e.getEmail());
            ps.setString(5, e.getPhoneNo());
            ps.setString(6, e.getRole());
            ps.setString(7, e.getDepartment());
            ps.setDouble(8, e.getSalary());
            ps.setInt(9, e.getEmployeeID());
            return ps.executeUpdate() > 0;
        } catch(Exception ex) { ex.printStackTrace(); }
        return false;
    }

 // Assign role and store in both EmployeeDetails & AssignRole tables
    public boolean assignRole(EmployeeDetails e) {
        Connection con = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        boolean status = false;

        try {
            con = Dbc.getConnection();
            con.setAutoCommit(false); // transaction start

            // 1️⃣ Update EmployeeDetails (current role)
            ps1 = con.prepareStatement(
                "UPDATE EmployeeDetails SET role=?, department=? WHERE employeeID=?"
            );
            ps1.setString(1, e.getRole());
            ps1.setString(2, e.getDepartment());
            ps1.setInt(3, e.getEmployeeID());

            int updateCount = ps1.executeUpdate();

            // 2️⃣ Insert into AssignRole (history)
            ps2 = con.prepareStatement(
                "INSERT INTO AssignRole(employeeID, role, department) VALUES (?,?,?)"
            );
            ps2.setInt(1, e.getEmployeeID());
            ps2.setString(2, e.getRole());
            ps2.setString(3, e.getDepartment());

            int insertCount = ps2.executeUpdate();

            if (updateCount > 0 && insertCount > 0) {
                con.commit();
                status = true;
            } else {
                con.rollback();
            }

        } catch (Exception ex) {
            try { if (con != null) con.rollback(); } catch (Exception e1) {}
            ex.printStackTrace();
        } finally {
            try { if (ps1 != null) ps1.close(); } catch (Exception e1) {}
            try { if (ps2 != null) ps2.close(); } catch (Exception e1) {}
            try { if (con != null) con.close(); } catch (Exception e1) {}
        }

        return status;
    }

    @Override
    public boolean deleteEmployee(int id) {
        try (Connection con = Dbc.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM EmployeeDetails WHERE employeeID=?"
            );
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch(Exception ex) { ex.printStackTrace(); }
        return false;
    }

    @Override
    public EmployeeDetails getEmployeeById(int employeeID) {
        EmployeeDetails emp = null;
        try (Connection con = Dbc.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM EmployeeDetails WHERE employeeID=?"
            );
            ps.setInt(1, employeeID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                emp = new EmployeeDetails();
                emp.setEmployeeID(rs.getInt("employeeID"));
                emp.setEmployeeName(rs.getString("employeeName"));
                emp.setGender(rs.getString("gender"));
                emp.setDob(rs.getString("dob"));
                emp.setEmail(rs.getString("email"));
                emp.setPhoneNo(rs.getString("phoneNo"));
                emp.setRole(rs.getString("role"));
                emp.setDepartment(rs.getString("department"));
                emp.setSalary(rs.getDouble("salary"));
            }
        } catch(Exception ex) { ex.printStackTrace(); }
        return emp;
    }

    @Override
    public List<EmployeeDetails> getAllEmployees() {
        List<EmployeeDetails> list = new ArrayList<>();
        try (Connection con = Dbc.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM EmployeeDetails");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                EmployeeDetails e = new EmployeeDetails();
                e.setEmployeeID(rs.getInt("employeeID"));
                e.setEmployeeName(rs.getString("employeeName"));
                e.setGender(rs.getString("gender"));
                e.setDob(rs.getString("dob"));
                e.setEmail(rs.getString("email"));
                e.setPhoneNo(rs.getString("phoneNo"));
                e.setRole(rs.getString("role"));
                e.setDepartment(rs.getString("department"));
                e.setSalary(rs.getDouble("salary"));
                e.setStatus(rs.getString("status"));
                list.add(e);
            }
        } catch(Exception ex) { ex.printStackTrace(); }
        return list;
    }
    
    @Override
    public List<RoleAssignment> getAllRoleAssignments() {
        List<RoleAssignment> list = new ArrayList<>();
        String sql = "SELECT * FROM AssignRole"; 

        try (Connection conn = Dbc.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                RoleAssignment emp = new RoleAssignment();
                emp.setEmployeeID(rs.getInt("employeeID"));
                emp.setRole(rs.getString("role"));
                emp.setDepartment(rs.getString("department"));
                list.add(emp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Active employees: " + list);

        return list;
    }
    @Override
    public EmployeeDetails loginEmployeeDetails(String email, String password) {

        EmployeeDetails emp = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = Dbc.getConnection();

            String sql = """
                SELECT employeeID, employeeName, email, role, department
                FROM EmployeeDetails
                WHERE email=? AND password=? AND status='ACTIVE'
            """;

            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);

            rs = ps.executeQuery();

            if (rs.next()) {
                emp = new EmployeeDetails();
                emp.setEmployeeID(rs.getInt("employeeID"));
                emp.setEmployeeName(rs.getString("employeeName"));
                emp.setEmail(rs.getString("email"));
                emp.setRole(rs.getString("role"));
                emp.setDepartment(rs.getString("department"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (ps != null) ps.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
        return emp;
    }

    @Override
    public AttendanceSummary getAttendanceByEmployee(int employeeID) {
        AttendanceSummary summary = null;
        String sql = """
            SELECT e.employeeID, e.employeeName,
                   COUNT(a.attendanceDate) AS workingDays,
                   SUM(a.status='PRESENT') AS presents,
                   SUM(a.status='LEAVE') AS leaves
            FROM EmployeeDetails e
            LEFT JOIN Attendance a ON e.employeeID = a.employeeID
            WHERE e.employeeID=?
            GROUP BY e.employeeID, e.employeeName
        """;

        try (Connection con = Dbc.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, employeeID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                summary = new AttendanceSummary();
                summary.setEmployeeID(rs.getInt("employeeID"));
                summary.setEmployeeName(rs.getString("employeeName"));
                summary.setWorkingDays(rs.getInt("workingDays"));
                summary.setPresents(rs.getInt("presents"));
                summary.setLeaves(rs.getInt("leaves"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return summary;
    }

    @Override
    public List<AttendanceSummary> getAllAttendanceSummary() {
        List<AttendanceSummary> list = new ArrayList<>();
        String sql = """
            SELECT e.employeeID, e.employeeName,
                   COUNT(a.attendanceDate) AS workingDays,
                   SUM(a.status='PRESENT') AS presents,
                   SUM(a.status='LEAVE') AS leaves
            FROM EmployeeDetails e
            LEFT JOIN Attendance a ON e.employeeID = a.employeeID
            GROUP BY e.employeeID, e.employeeName
            ORDER BY e.employeeID
        """;

        try (Connection con = Dbc.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                AttendanceSummary summary = new AttendanceSummary();
                summary.setEmployeeID(rs.getInt("employeeID"));
                summary.setEmployeeName(rs.getString("employeeName"));
                summary.setWorkingDays(rs.getInt("workingDays"));
                summary.setPresents(rs.getInt("presents"));
                summary.setLeaves(rs.getInt("leaves"));
                list.add(summary);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public boolean isAttendanceMarked(int employeeID, LocalDate date) {
        String sql = "SELECT * FROM Attendance WHERE employeeID=? AND attendanceDate=?";
        try (Connection con = Dbc.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, employeeID);
            ps.setDate(2, java.sql.Date.valueOf(date));
            ResultSet rs = ps.executeQuery();
            return rs.next(); // true if record exists
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean markAttendance(int employeeID, LocalDate date, String status) {
        String sql = "INSERT INTO Attendance(employeeID, attendanceDate, status) VALUES(?,?,?)";
        try (Connection con = Dbc.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, employeeID);
            ps.setDate(2, java.sql.Date.valueOf(date));
            ps.setString(3, status);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean applyLeave(LeaveRequest leave) {
        String sql = """
            INSERT INTO LeaveRequest(employeeID, fromDate, toDate, reason)
            VALUES (?, ?, ?, ?)
        """;

        try (Connection con = Dbc.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, leave.getEmployeeID());
            ps.setDate(2, leave.getFromDate());
            ps.setDate(3, leave.getToDate());
            ps.setString(4, leave.getReason());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<LeaveRequest> getAllLeaveRequests() {
        List<LeaveRequest> list = new ArrayList<>();
        String sql = "SELECT * FROM LeaveRequest ORDER BY appliedOn DESC";

        try (Connection con = Dbc.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                LeaveRequest lr = new LeaveRequest();
                lr.setLeaveId(rs.getInt("leaveId"));
                lr.setEmployeeID(rs.getInt("employeeID"));
                lr.setFromDate(rs.getDate("fromDate"));
                lr.setToDate(rs.getDate("toDate"));
                lr.setReason(rs.getString("reason"));
                lr.setStatus(rs.getString("status"));
                list.add(lr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean approveLeave(int leaveId) {
        Connection con = null;
        try {
            con = Dbc.getConnection();
            con.setAutoCommit(false);

            // Get leave details
            PreparedStatement ps1 = con.prepareStatement(
                "SELECT employeeID, fromDate, toDate FROM LeaveRequest WHERE leaveId=?"
            );
            ps1.setInt(1, leaveId);
            ResultSet rs = ps1.executeQuery();

            if (!rs.next()) return false;

            int empId = rs.getInt("employeeID");
            Date from = rs.getDate("fromDate");
            Date to = rs.getDate("toDate");

            // Mark leave approved
            PreparedStatement ps2 = con.prepareStatement(
                "UPDATE LeaveRequest SET status='APPROVED' WHERE leaveId=?"
            );
            ps2.setInt(1, leaveId);
            ps2.executeUpdate();

            // Insert LEAVE into Attendance for each date
            LocalDate start = from.toLocalDate();
            LocalDate end = to.toLocalDate();

            PreparedStatement ps3 = con.prepareStatement(
                "INSERT IGNORE INTO Attendance(employeeID, attendanceDate, status) VALUES (?,?, 'LEAVE')"
            );

            while (!start.isAfter(end)) {
                ps3.setInt(1, empId);
                ps3.setDate(2, Date.valueOf(start));
                ps3.executeUpdate();
                start = start.plusDays(1);
            }

            con.commit();
            return true;

        } catch (Exception e) {
            try { if (con != null) con.rollback(); } catch (Exception ex) {}
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean rejectLeave(int leaveId) {
        try (Connection con = Dbc.getConnection();
             PreparedStatement ps = con.prepareStatement(
                 "UPDATE LeaveRequest SET status='REJECTED' WHERE leaveId=?"
             )) {

            ps.setInt(1, leaveId);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public List<LeaveRequest> getLeaveByEmployee(int empId) {
        List<LeaveRequest> list = new ArrayList<>();
        String sql = "SELECT * FROM LeaveRequest WHERE employeeID=? ORDER BY appliedOn DESC";

        try (Connection con = Dbc.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, empId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                LeaveRequest l = new LeaveRequest();
                l.setLeaveId(rs.getInt("leaveId"));
                l.setFromDate(rs.getDate("fromDate"));
                l.setToDate(rs.getDate("toDate"));
                l.setReason(rs.getString("reason"));
                l.setStatus(rs.getString("status"));
                list.add(l);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public PayrollDetails calculatePayroll(int employeeID, int month, int year) {

        EmployeeDetails emp = getEmployeeById(employeeID);
        AttendanceSummary att = getAttendanceByEmployee(employeeID);

        if (emp == null || att == null) return null;

        PayrollDetails p = new PayrollDetails();
        p.setEmployeeID(emp.getEmployeeID());
        p.setEmployeeName(emp.getEmployeeName());
        p.setMonth(month);
        p.setYear(year);

        p.setWorkingDays(att.getWorkingDays());
        p.setPresents(att.getPresents());
        p.setLeaves(att.getLeaves());

        p.setSalary(emp.getSalary());

        double perDaySalary = emp.getSalary() / att.getWorkingDays();
        double netSalary = perDaySalary * att.getPresents();

        p.setPerDaySalary(perDaySalary);
        p.setNetSalary(netSalary);

        return p;
    }

    
    public boolean savePayroll(PayrollDetails p) {

        String sql = """
            INSERT INTO Payroll
            (employeeID, month, year, workingDays, presents, leaves,
             salary, perDaySalary, netSalary)
            VALUES (?,?,?,?,?,?,?,?,?)
        """;

        try (Connection con = Dbc.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, p.getEmployeeID());
            ps.setInt(2, p.getMonth());
            ps.setInt(3, p.getYear());
            ps.setInt(4, p.getWorkingDays());
            ps.setInt(5, p.getPresents());
            ps.setInt(6, p.getLeaves());
            ps.setDouble(7, p.getSalary());
            ps.setDouble(8, p.getPerDaySalary());
            ps.setDouble(9, p.getNetSalary());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<PayrollDetails> getPayrollByEmployee(int employeeID) {

        List<PayrollDetails> list = new ArrayList<>();
        String sql = "SELECT * FROM Payroll WHERE employeeID=? ORDER BY year DESC, month DESC";

        try (Connection con = Dbc.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, employeeID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PayrollDetails p = new PayrollDetails();
                p.setEmployeeID(rs.getInt("employeeID"));
                p.setMonth(rs.getInt("month"));
                p.setYear(rs.getInt("year"));
                p.setWorkingDays(rs.getInt("workingDays"));
                p.setPresents(rs.getInt("presents"));
                p.setLeaves(rs.getInt("leaves"));
                p.setSalary(rs.getDouble("salary"));
                p.setPerDaySalary(rs.getDouble("perDaySalary"));
                p.setNetSalary(rs.getDouble("netSalary"));
                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<PayrollDetails> getPayrollByDepartment(String department) {

        List<PayrollDetails> list = new ArrayList<>();

        String sql =
            "SELECT p.*, e.employeeName " +
            "FROM Payroll p " +
            "JOIN EmployeeDetails e ON p.employeeID = e.employeeID " +
            "WHERE e.department = ?";

        try (Connection con = Dbc.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, department);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PayrollDetails p = new PayrollDetails();

                p.setEmployeeID(rs.getInt("employeeID"));
                p.setEmployeeName(rs.getString("employeeName"));
                p.setMonth(rs.getInt("month"));
                p.setYear(rs.getInt("year"));
                p.setWorkingDays(rs.getInt("workingDays"));
                p.setPresents(rs.getInt("presents"));
                p.setLeaves(rs.getInt("leaves"));
                p.setSalary(rs.getDouble("salary"));
                p.setPerDaySalary(rs.getDouble("perDaySalary"));
                p.setNetSalary(rs.getDouble("netSalary"));

                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

 // Get manager details by email and password from Manager table
    public EmployeeDetails getManagerByEmailAndPassword(String email, String password) {

        EmployeeDetails manager = null;

        String sql = """
            SELECT 
                Id AS employeeID,
                CONCAT(firstName, ' ', lastName) AS employeeName,
                email,
                department
            FROM Manager
            WHERE email = ? AND password = ?
        """;

        try (Connection con = Dbc.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                manager = new EmployeeDetails();
                manager.setEmployeeID(rs.getInt("employeeID"));
                manager.setEmployeeName(rs.getString("employeeName"));
                manager.setEmail(rs.getString("email"));
                manager.setDepartment(rs.getString("department")); // ✅ FROM DB
                manager.setRole("Manager"); // role is fine to set manually
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return manager;
    }
    
    public List<PayrollDetails> getAllPayroll() {

        List<PayrollDetails> list = new ArrayList<>();

        String sql = """
            SELECT 
                p.employeeID,
                e.employeeName,
                p.month,
                p.year,
                p.netSalary
            FROM Payroll p
            JOIN EmployeeDetails e ON p.employeeID = e.employeeID
            ORDER BY p.year DESC, p.month DESC
        """;

        try (Connection con = Dbc.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                PayrollDetails p = new PayrollDetails();
                p.setEmployeeID(rs.getInt("employeeID"));
                p.setEmployeeName(rs.getString("employeeName"));
                p.setMonth(rs.getInt("month"));
                p.setYear(rs.getInt("year"));
                p.setNetSalary(rs.getDouble("netSalary"));

                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void assignTask(ProjectTask task) {

        String sql = "INSERT INTO ProjectTask " +
                     "(employeeID, taskName, description, startDate, dueDate, status) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = Dbc.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, task.getEmployeeID());
            ps.setString(2, task.getTaskName());
            ps.setString(3, task.getDescription());
            ps.setString(4, task.getStartDate());
            ps.setString(5, task.getDueDate());
            ps.setString(6, task.getStatus());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateTaskStatus(int taskId, String status, String completedDate) {

        String sql = "UPDATE ProjectTask " +
                     "SET status = ?, completedDate = ? " +
                     "WHERE taskId = ?";

        try (Connection con = Dbc.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, status);
            ps.setString(2, completedDate);
            ps.setInt(3, taskId);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ProjectTask> getTasksForEmployee(int empId, int month, int year) {

        List<ProjectTask> list = new ArrayList<>();

        String sql = "SELECT * FROM ProjectTask " +
                     "WHERE employeeID = ? " +
                     "AND MONTH(startDate) = ? " +
                     "AND YEAR(startDate) = ?";

        try (Connection con = Dbc.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, empId);
            ps.setInt(2, month);
            ps.setInt(3, year);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ProjectTask task = new ProjectTask();
                task.setTaskId(rs.getInt("taskId"));
                task.setEmployeeID(rs.getInt("employeeID"));
                task.setTaskName(rs.getString("taskName"));
                task.setDescription(rs.getString("description"));
                task.setStartDate(rs.getString("startDate"));
                task.setDueDate(rs.getString("dueDate"));
                task.setCompletedDate(rs.getString("completedDate"));
                task.setStatus(rs.getString("status"));

                list.add(task);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public EmployeePerformance calculatePerformance(int empId, int month, int year) {

        EmployeePerformance perf = new EmployeePerformance();

        String sql = "SELECT dueDate, completedDate, status " +
                     "FROM ProjectTask " +
                     "WHERE employeeID = ? " +
                     "AND MONTH(startDate) = ? " +
                     "AND YEAR(startDate) = ?";

        int totalTasks = 0;
        int completedOnTime = 0;
        int completedLate = 0;

        try (Connection con = Dbc.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, empId);
            ps.setInt(2, month);
            ps.setInt(3, year);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                totalTasks++;

                String status = rs.getString("status");
                Date due = rs.getDate("dueDate");
                Date completed = rs.getDate("completedDate");

                if ("COMPLETED".equals(status) && completed != null) {
                    if (!completed.after(due)) {
                        completedOnTime++;
                    } else {
                        completedLate++;
                    }
                }
            }

            // ---------- SCORE CALCULATION ----------
            double score = 0;
            if (totalTasks > 0) {
                score = ((completedOnTime * 100) + (completedLate * 70))
                        / (totalTasks * 100.0) * 100;
            }

            // ---------- GRADE ----------
            String grade;
            if (score >= 90) grade = "A";
            else if (score >= 75) grade = "B";
            else if (score >= 60) grade = "C";
            else grade = "D";

            perf.setEmployeeID(empId);
            perf.setMonth(month);
            perf.setYear(year);
            perf.setTotalTasks(totalTasks);
            perf.setCompletedOnTime(completedOnTime);
            perf.setCompletedLate(completedLate);
            perf.setPerformanceScore(score);
            perf.setGrade(grade);

            savePerformance(perf);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return perf;
    }

    public void savePerformance(EmployeePerformance perf) {

        String sql = "INSERT INTO EmployeePerformance " +
                     "(employeeID, month, year, totalTasks, completedOnTime, completedLate, performanceScore, grade) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = Dbc.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, perf.getEmployeeID());
            ps.setInt(2, perf.getMonth());
            ps.setInt(3, perf.getYear());
            ps.setInt(4, perf.getTotalTasks());
            ps.setInt(5, perf.getCompletedOnTime());
            ps.setInt(6, perf.getCompletedLate());
            ps.setDouble(7, perf.getPerformanceScore());
            ps.setString(8, perf.getGrade());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<ProjectTask> getTasksByEmployeeId(int empId) {

        List<ProjectTask> list = new ArrayList<>();

        String sql = "SELECT * FROM ProjectTask WHERE employeeID = ?";

        try (Connection con = Dbc.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, empId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ProjectTask task = new ProjectTask();
                task.setTaskId(rs.getInt("taskId"));
                task.setEmployeeID(rs.getInt("employeeID"));
                task.setTaskName(rs.getString("taskName"));
                task.setDescription(rs.getString("description"));
                task.setStartDate(rs.getString("startDate"));
                task.setDueDate(rs.getString("dueDate"));
                task.setCompletedDate(rs.getString("completedDate"));
                task.setStatus(rs.getString("status"));
                list.add(task);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


    
}
