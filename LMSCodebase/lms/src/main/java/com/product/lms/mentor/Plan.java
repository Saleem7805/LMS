package com.product.lms.mentor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Plan")
public class Plan {
	@Id
	 private String planId;

	 private String courseId;

	 private String pibId; 

	 private String startDate;

	 private String endDate;

	 private String mentorId;

	 public String getPlanId() {
		 return planId;
	 }

	 public void setPlanId(String planId) {
		 this.planId = planId;
	 }

	 public String getCourseId() {
		 return courseId;
	 }

	 public void setCourseId(String courseId) {
		 this.courseId = courseId;
	 }

	 public String getPibId() {
		 return pibId;
	 }

	 public void setPibId(String pibId) {
		 this.pibId = pibId;
	 }

	 public String getStartDate() {
		 return startDate;
	 }

	 public void setStartDate(String startDate) {
		 this.startDate = startDate;
	 }

	 public String getEndDate() {
		 return endDate;
	 }

	 public void setEndDate(String endDate) {
		 this.endDate = endDate;
	 }

	 public String getMentorId() {
		 return mentorId;
	 }

	 public void setMentorId(String mentorId) {
		 this.mentorId = mentorId;
	 }
	 
	 

}
