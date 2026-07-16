package com.Model;

public class ApplicantModel {

	private String firstName;
	private String lastName;
	private String gender;
	private String dob;
	private String maritalStatus;
	private String country;
	private String phno;
	private String email;
	private String password;
	private String resume;
	private String jobTitle;
	private int passoutYear;
	
	public ApplicantModel() {}

	public ApplicantModel(String firstName, String lastName, String gender, String dob, String maritalStatus,
			String country, String phno, String email, String password, String resume, String jobTitle,
			int passoutYear) {
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
		this.resume = resume;
		this.jobTitle = jobTitle;
		this.passoutYear = passoutYear;
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

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public int getPassoutYear() {
		return passoutYear;
	}

	public void setPassoutYear(int passoutYear) {
		this.passoutYear = passoutYear;
	}

	@Override
	public String toString() {
		return "ApplicantModel [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", dob="
				+ dob + ", maritalStatus=" + maritalStatus + ", country=" + country + ", phno=" + phno + ", email="
				+ email + ", password=" + password + ", resume=" + resume + ", jobTitle=" + jobTitle + ", passoutYear="
				+ passoutYear + "]";
	}
	
	

}