package com.product.lms.mentor;

public class AddMentorDTO {
	
	
	
	private String mentorName; 
	private String mentorQualification;
	private String mentorYoe; 
	private String specializationDomain ;
	
	
	
	
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
	
	public AddMentorDTO(  String mentorName, String mentorQualification, String mentorYoe,
			String specializationDomain) {
		super();
		
		
		this.mentorName = mentorName;
		this.mentorQualification = mentorQualification;
		this.mentorYoe = mentorYoe;
		this.specializationDomain = specializationDomain;
		
	}
	public AddMentorDTO() {
		
	}
	
	

}
