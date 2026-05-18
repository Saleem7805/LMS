package com.product.lms.mentor;

public class UpdateMentorDTO {
	
	private String mentorId;
	private String mentorName;
	private String mentorQualification;
	private String mentorYoe;
	private String specializationDomain;
	private boolean studentAssigned;
	public String getMentorId() {
		return mentorId;
	}
	public void setMentorId(String mentorId) {
		this.mentorId = mentorId;
	}
	public String getMentorName() {
		return mentorName;
	}
	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}
	public String getMentorQualification() {
		return mentorQualification;
	}
	public void setMentorQualification(String mentorQualification) {
		this.mentorQualification = mentorQualification;
	}
	public String getMentorYoe() {
		return mentorYoe;
	}
	public void setMentorYoe(String mentorYoe) {
		this.mentorYoe = mentorYoe;
	}
	public String getSpecializationDomain() {
		return specializationDomain;
	}
	public void setSpecializationDomain(String specializationDomain) {
		this.specializationDomain = specializationDomain;
	}
	public boolean isStudentAssigned() {
		return studentAssigned;
	}
	public void setStudentAssigned(boolean studentAssigned) {
		this.studentAssigned = studentAssigned;
	}
	
	
	
	

}
