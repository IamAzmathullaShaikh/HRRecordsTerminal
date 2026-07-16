package com.Model;

public class EmployeePerformance {
    private int employeeID;
    private int month;
    private int year;

    private int totalTasks;
    private int completedOnTime;
    private int completedLate;

    private double performanceScore;
    private String grade;
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getTotalTasks() {
		return totalTasks;
	}
	public void setTotalTasks(int totalTasks) {
		this.totalTasks = totalTasks;
	}
	public int getCompletedOnTime() {
		return completedOnTime;
	}
	public void setCompletedOnTime(int completedOnTime) {
		this.completedOnTime = completedOnTime;
	}
	public int getCompletedLate() {
		return completedLate;
	}
	public void setCompletedLate(int completedLate) {
		this.completedLate = completedLate;
	}
	public double getPerformanceScore() {
		return performanceScore;
	}
	public void setPerformanceScore(double performanceScore) {
		this.performanceScore = performanceScore;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "EmployeePerformance [employeeID=" + employeeID + ", month=" + month + ", year=" + year + ", totalTasks="
				+ totalTasks + ", completedOnTime=" + completedOnTime + ", completedLate=" + completedLate
				+ ", performanceScore=" + performanceScore + ", grade=" + grade + "]";
	}

    // getters & setters
    
}
