package com.Model;

public class PayrollDetails {

    private int employeeID;
    private String employeeName;
    private int month;
    private int year;

    private int workingDays;
    private int presents;
    private int leaves;

    private double salary;
    private double perDaySalary;
    private double netSalary;

    public PayrollDetails() {}

    public int getEmployeeID() { return employeeID; }
    public void setEmployeeID(int employeeID) { this.employeeID = employeeID; }

    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }

    public int getMonth() { return month; }
    public void setMonth(int month) { this.month = month; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public int getWorkingDays() { return workingDays; }
    public void setWorkingDays(int workingDays) { this.workingDays = workingDays; }

    public int getPresents() { return presents; }
    public void setPresents(int presents) { this.presents = presents; }

    public int getLeaves() { return leaves; }
    public void setLeaves(int leaves) { this.leaves = leaves; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public double getPerDaySalary() { return perDaySalary; }
    public void setPerDaySalary(double perDaySalary) { this.perDaySalary = perDaySalary; }

    public double getNetSalary() { return netSalary; }
    public void setNetSalary(double netSalary) { this.netSalary = netSalary; }
}
