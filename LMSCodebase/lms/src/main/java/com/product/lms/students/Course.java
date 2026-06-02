package com.product.lms.students;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Course")
public class Course {
	
	 @Id
	 private String courseId;
	 private String courseName;
	 private String courseDescription;
	 private List<String>chapters=new ArrayList<>();
	 
	 
	 public String getCourseId() {
		 return courseId;
	 }
	 public void setCourseId(String courseId) {
		 this.courseId = courseId;
	 }
	 public String getCourseName() {
		 return courseName;
	 }
	 public void setCourseName(String courseName) {
		 this.courseName = courseName;
	 }
	 public String getCourseDescription() {
		 return courseDescription;
	 }
	 public void setCourseDescription(String courseDescription) {
		 this.courseDescription = courseDescription;
	 }
	 
	 
	    

}
