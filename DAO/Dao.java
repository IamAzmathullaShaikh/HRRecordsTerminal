package com.DAO;

import java.sql.SQLException;
import java.util.List;
import com.Model.PayrollDetails;
import com.Model.ProjectTask;
import com.Model.ApplicantModel;
import com.Model.AttendanceSummary;
import com.Model.EmployeeDetails;
import com.Model.EmployeeModel;
import com.Model.EmployeePerformance;
import com.Model.ManagerModel;
import com.Model.RoleAssignment;
import com.Model.HRregisterModel;
import com.Model.LeaveRequest;

public interface Dao {

    // User registration & login
    boolean registerUser(HRregisterModel user) throws SQLException;
    boolean loginUser(String email, String password);

    // Manager registration & login
    boolean registerManager(ManagerModel mr) throws SQLException;
    boolean loginManager(String email, String password);

    // Applicant registration
    boolean registerApplicant(ApplicantModel applicant) throws SQLException;

    // Employee registration & login
    boolean registerEmployee(EmployeeModel er) throws SQLException;
    //boolean loginEmployee(String email, String password);
    EmployeeDetails loginEmployee(int employeeID, String email, String password);

    EmployeeDetails loginEmployeeDetails(String email, String password);
 // ================= EmployeeDetails CRUD =================

    // Add employee details
    boolean addEmployee(EmployeeDetails e);
    boolean updateEmployee(EmployeeDetails e);
    boolean deleteEmployee(int id);
    EmployeeDetails getEmployeeById(int id);
    List<EmployeeDetails> getAllEmployees();
    boolean assignRole(EmployeeDetails e);
 // In Dao interface
    List<RoleAssignment> getAllRoleAssignments();
    
 // Check if attendance for a given employee and date already exists
    boolean isAttendanceMarked(int employeeID, java.time.LocalDate date);

    // Insert attendance record
    boolean markAttendance(int employeeID, java.time.LocalDate date, String status);

  
 // For HR: get all employees attendance summary
    List<AttendanceSummary> getAllAttendanceSummary();

    // For Employee: get one employee's attendance summary
    AttendanceSummary getAttendanceByEmployee(int employeeID);

    //leave
    boolean applyLeave(LeaveRequest leave);

    List<LeaveRequest> getAllLeaveRequests();

    boolean approveLeave(int leaveId);

    boolean rejectLeave(int leaveId);
    
    public List<LeaveRequest> getLeaveByEmployee(int empId);
    
    //payroll
    public PayrollDetails calculatePayroll(int employeeID, int month, int year);
    
    public boolean savePayroll(PayrollDetails p);
    
    public List<PayrollDetails> getPayrollByEmployee(int employeeID);
    
    public List<PayrollDetails> getPayrollByDepartment(String department);
    
    public EmployeeDetails getManagerByEmailAndPassword(String email, String password);
    
    public List<PayrollDetails> getAllPayroll();
    
    public void assignTask(ProjectTask task);

    public void updateTaskStatus(int taskId, String status, String completedDate);

    public List<ProjectTask> getTasksForEmployee(int empId, int month, int year);

    public EmployeePerformance calculatePerformance(int empId, int month, int year);

    public void savePerformance(EmployeePerformance perf);
    
    public List<ProjectTask> getTasksByEmployeeId(int empId);

}
