package com.Model;

public class AddEmployeeDetails {

    private int employeeID;
    private String employeeName;
    private String gender;
    private String dob;
    private String email;
    private String phoneNo;
    private String role;
    private String department;
    private double salary;

    public AddEmployeeDetails() {}

    public AddEmployeeDetails(int employeeID, String employeeName, String gender, String dob,
                           String email, String phoneNo, String role, String department, double salary) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.gender = gender;
        this.dob = dob;
        this.email = email;
        this.phoneNo = phoneNo;
        this.role = role;
        this.department = department;
        this.salary = salary;
    }

    // Getters and Setters
    public int getEmployeeID() { return employeeID; }
    public void setEmployeeID(int employeeID) { this.employeeID = employeeID; }
    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhoneNo() { return phoneNo; }
    public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
}