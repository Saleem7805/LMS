package com.product.lms.mentor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Mentor")
public class MentorModel {
	
	@Id
	
	@Field("_id")
	private String mentorId;
	private String mpassword ;
	private String mentorName; 
	private String mentorQualification;
	private String mentorYoe; 
	private String specializationDomain ;
	private List<String> assignedStudent = new ArrayList<>();
	
	private List<String> assignedMentor = new ArrayList<>();
	
	
	public MentorModel(String mentorId, String mpassword, String mentorName, String mentorQualification,
			String mentorYoe, String specializationDomain, List<String> assignedStudent,List<String> assignedMentor) {
		super();
		this.mentorId = mentorId;
		this.mpassword = mpassword;
		this.mentorName = mentorName;
		this.mentorQualification = mentorQualification;
		this.mentorYoe = mentorYoe;
		this.specializationDomain = specializationDomain;
		this.assignedStudent = assignedStudent;
		this.assignedMentor=assignedMentor;
	}

	public MentorModel() {
		// TODO Auto-generated constructor stub
	}

	public String getMentorId() {
		return mentorId;
	}

	public void setMentorId(String mentorId) {
		this.mentorId = mentorId;
	}

	public String getMpassword() {
		return mpassword;
	}

	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
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

	public List<String> getAssignedStudent() {
		return assignedStudent;
	}

	public void setAssignedStudent(List<String> assignedStudent) {
		this.assignedStudent = assignedStudent;
	}

	public List<String> getAssignedMentor() {
		return assignedMentor;
	}

	public void setAssignedMentor(List<String> assignedMentor) {
		this.assignedMentor = assignedMentor;
	}

	

	

	

	
	

}
