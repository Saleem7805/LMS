package com.product.lms.mentor;

public class ViewAssignedStudentDTO {
	
	private String pibId;
    private String studentName;
    private String courseTaken;
    private String highestQualification;
	public ViewAssignedStudentDTO(String pibId, String studentName, String courseTaken, String highestQualification) {
		super();
		this.pibId = pibId;
		this.studentName = studentName;
		this.courseTaken = courseTaken;
		this.highestQualification = highestQualification;
	}
	public ViewAssignedStudentDTO() {
		// TODO Auto-generated constructor stub
	}
	public String getPibId() {
		return pibId;
	}
	public void setPibId(String pibId) {
		this.pibId = pibId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getCourseTaken() {
		return courseTaken;
	}
	public void setCourseTaken(String courseTaken) {
		this.courseTaken = courseTaken;
	}
	public String getHighestQualification() {
		return highestQualification;
	}
	public void setHighestQualification(String highestQualification) {
		this.highestQualification = highestQualification;
	}
    
    

}
