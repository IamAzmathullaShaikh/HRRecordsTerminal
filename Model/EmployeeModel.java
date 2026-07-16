package com.Model;

public class EmployeeModel {

	private String firstName;
	private String lastName;
	private String gender;
	private String dob;
	private String maritalStatus;
	private String country;
	private String phno;
	private String email;
	private String password;
	
	public EmployeeModel() {}

	public EmployeeModel(String firstName, String lastName, String gender, String dob, String maritalStatus,
			String country, String phno, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.maritalStatus = maritalStatus;
		this.country = country;
		this.phno = phno;
		this.email = email;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "EmployeeModel [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", dob="
				+ dob + ", maritalStatus=" + maritalStatus + ", country=" + country + ", phno=" + phno + ", email="
				+ email + ", password=" + password + "]";
	}
	
	
	
}
