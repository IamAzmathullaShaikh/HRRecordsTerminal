package com.Model;


public class AttendanceSummary {
    private int employeeID;
    private String employeeName;
    private int workingDays;
    private int presents;
    private int leaves;

    // Constructor
    public AttendanceSummary() {}

    // Getters and Setters
    public int getEmployeeID() { return employeeID; }
    public void setEmployeeID(int employeeID) { this.employeeID = employeeID; }

    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }

    public int getWorkingDays() { return workingDays; }
    public void setWorkingDays(int workingDays) { this.workingDays = workingDays; }

    public int getPresents() { return presents; }
    public void setPresents(int presents) { this.presents = presents; }

    public int getLeaves() { return leaves; }
    public void setLeaves(int leaves) { this.leaves = leaves; }
}
