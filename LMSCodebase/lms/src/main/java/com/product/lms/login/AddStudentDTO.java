package com.product.lms.login;

public class AddStudentDTO {
	
	private String enrollmentDate;
	private String name;
	private String role;
	private String courseStartDate;
	private String courseTaken;
	private String selectedLanguage;
	private String enrollmentType;
	private String phoneNumber;
	private String emailId;
	private String password;

	
	public AddStudentDTO(String enrollmentDate, String name, String role, String courseStartDate, String courseTaken,
			String selectedLanguage, String enrollmentType, String phoneNumber, String emailId, String password) {
		super();
		this.enrollmentDate = enrollmentDate;
		this.name = name;
		this.role = role;
		this.courseStartDate = courseStartDate;
		this.courseTaken = courseTaken;
		this.selectedLanguage = selectedLanguage;
		this.enrollmentType = enrollmentType;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.password = password;
		
	}
	public AddStudentDTO() {
		// TODO Auto-generated constructor stub
	}
	public String getEnrollmentDate() {
		return enrollmentDate;
	}
	public void setEnrollmentDate(String enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getCourseStartDate() {
		return courseStartDate;
	}
	public void setCourseStartDate(String courseStartDate) {
		this.courseStartDate = courseStartDate;
	}
	public String getCourseTaken() {
		return courseTaken;
	}
	public void setCourseTaken(String courseTaken) {
		this.courseTaken = courseTaken;
	}
	public String getSelectedLanguage() {
		return selectedLanguage;
	}
	public void setSelectedLanguage(String selectedLanguage) {
		this.selectedLanguage = selectedLanguage;
	}
	public String getEnrollmentType() {
		return enrollmentType;
	}
	public void setEnrollmentType(String enrollmentType) {
		this.enrollmentType = enrollmentType;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	

}
