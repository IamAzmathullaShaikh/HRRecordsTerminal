package com.Model;

public class RoleAssignment {

    private int employeeID;
    private String role;
    private String department;

    // Default constructor
    public RoleAssignment() {}

    // Parameterized constructor
    public RoleAssignment(int employeeID, String role, String department) {
        this.employeeID = employeeID;
        this.role = role;
        this.department = department;
    }

    // Getters and Setters
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // toString method
    @Override
    public String toString() {
        return "RoleAssignmentModel [employeeID=" + employeeID + ", role=" + role + ", department=" + department + "]";
    }
}
