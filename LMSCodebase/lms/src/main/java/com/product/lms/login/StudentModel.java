package com.product.lms.login;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Student")
public class StudentModel {
	     @Id 
	     @Field("_id")
	    private String pibId;
	    private String password; 
	    private String enrollmentDate;
	    private String name;
	    private String role;
	    private String courseStartDate;
	    private String courseTaken;
	    private String selectedLanguage;
	    private String assignedMentor;
	    private String enrollmentType;
	    private String phoneNumber;
	    private String emailId;
	    private String otherFixedInformation;
	    
//	    Adding STUDENT INFORMATION COLLECTION PAGE
	    private String city;
	    private String time_Difference;
	    private String Highest_Qualification ;
	    private String year_of_Graduation ;
	    public String BackgroundType ;
	    
	    private String background;
	    
	    private String domain_Or_stream_of_Work ;
	    private String work_Experience;
	    
	    
	    // Awareness of Programming (Yes/No)
	    private String programmingAwareness;

	    // Tools Familiar With (Checkbox)
	    private String toolsFamiliarWith;

	    // Tools & Technologies in Data Science (Checkbox)
	    private String dsTools;

	    // Worked on Projects (Yes/No)
	    private String workedOnProjects;

	    // Project Description
	    private String projectDescription;
	    
	    
	    public String ProfessionalStatus ;

	    // Career Gap (Yes/No)
	    private String careerGap;

	    // Years of Career Gap
	    private Double yearsOfCareerGap;

	    // Current Role
	    private String currentRole;

	    // Role Description
	    private String roleDescription;

	    // Current Responsibilities
	    private String currentResponsibilities;
	    
	    // Project Name / Description
	    private String projectName;

	    // Tools & Technologies Used
	    private String toolsAndTechnologies;
	    
	    public String CareerIntent ;
	    
	    public String TargetRole ;
	    // Resume File Upload (store file path or URL)
	    private String resumeUrl;

	    // Career Intent
	    
	    // Targeted Role
	    private String targetedRole;

	    // Expected Job Timeline (in months)
	    private Integer expectedJobTimeline;

	    // Current CTC
	    private BigDecimal currentCTC;

	    // Expected CTC
	    private BigDecimal expectedCTC;

	    // Preferred Job Location
	    private String preferredJobLocation;

	    // Current Job Location
	    private String currentJobLocation;

	    // Social Profiles
	    private String linkedInUrl;
	    private String hackerRankUrl;
	    private String githubUrl;
	    private String naukriUrl;



	   
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
		
		public String getAssignedMentor() {
			return assignedMentor;
		}
		public void setAssignedMentor(String assignedMentor) {
			this.assignedMentor = assignedMentor;
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
		
		
		public String getOtherFixedInformation() {
			return otherFixedInformation;
		}
		public void setOtherFixedInformation(String otherFixedInformation) {
			this.otherFixedInformation = otherFixedInformation;
		}
		
		
		public String getPibId() {
			return pibId;
		}
		public void setPibId(String pibId) {
			this.pibId = pibId;
		}
		
		
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getTime_Difference() {
			return time_Difference;
		}
		public void setTime_Difference(String time_Difference) {
			this.time_Difference = time_Difference;
		}
		public String getHighest_Qualification() {
			return Highest_Qualification;
		}
		public void setHighest_Qualification(String highest_Qualification) {
			Highest_Qualification = highest_Qualification;
		}
		public String getYear_of_Graduation() {
			return year_of_Graduation;
		}
		public void setYear_of_Graduation(String year_of_Graduation) {
			this.year_of_Graduation = year_of_Graduation;
		}
		public String getBackground() {
			return background;
		}
		public void setBackground(String background) {
			this.background = background;
		}
		public String getDomain_Or_stream_of_Work() {
			return domain_Or_stream_of_Work;
		}
		public void setDomain_Or_stream_of_Work(String domain_Or_stream_of_Work) {
			this.domain_Or_stream_of_Work = domain_Or_stream_of_Work;
		}
		public String getWork_Experience() {
			return work_Experience;
		}
		public void setWork_Experience(String work_Experience) {
			this.work_Experience = work_Experience;
		}
		public String getProgrammingAwareness() {
			return programmingAwareness;
		}
		public void setProgrammingAwareness(String programmingAwareness) {
			this.programmingAwareness = programmingAwareness;
		}
		public String getToolsFamiliarWith() {
			return toolsFamiliarWith;
		}
		public void setToolsFamiliarWith(String toolsFamiliarWith) {
			this.toolsFamiliarWith = toolsFamiliarWith;
		}
		public String getDsTools() {
			return dsTools;
		}
		public void setDsTools(String dsTools) {
			this.dsTools = dsTools;
		}
		public String getWorkedOnProjects() {
			return workedOnProjects;
		}
		public void setWorkedOnProjects(String workedOnProjects) {
			this.workedOnProjects = workedOnProjects;
		}
		public String getProjectDescription() {
			return projectDescription;
		}
		public void setProjectDescription(String projectDescription) {
			this.projectDescription = projectDescription;
		}
		public String getCareerGap() {
			return careerGap;
		}
		public void setCareerGap(String careerGap) {
			this.careerGap = careerGap;
		}
		public Double getYearsOfCareerGap() {
			return yearsOfCareerGap;
		}
		public void setYearsOfCareerGap(Double yearsOfCareerGap) {
			this.yearsOfCareerGap = yearsOfCareerGap;
		}
		public String getCurrentRole() {
			return currentRole;
		}
		public void setCurrentRole(String currentRole) {
			this.currentRole = currentRole;
		}
		public String getRoleDescription() {
			return roleDescription;
		}
		public void setRoleDescription(String roleDescription) {
			this.roleDescription = roleDescription;
		}
		public String getCurrentResponsibilities() {
			return currentResponsibilities;
		}
		public void setCurrentResponsibilities(String currentResponsibilities) {
			this.currentResponsibilities = currentResponsibilities;
		}
		public String getProjectName() {
			return projectName;
		}
		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}
		public String getToolsAndTechnologies() {
			return toolsAndTechnologies;
		}
		public void setToolsAndTechnologies(String toolsAndTechnologies) {
			this.toolsAndTechnologies = toolsAndTechnologies;
		}
		public String getResumeUrl() {
			return resumeUrl;
		}
		public void setResumeUrl(String resumeUrl) {
			this.resumeUrl = resumeUrl;
		}
		
		
		public String getTargetedRole() {
			return targetedRole;
		}
		public void setTargetedRole(String  targetedRole) {
			this.targetedRole = targetedRole;
		}
		public Integer getExpectedJobTimeline() {
			return expectedJobTimeline;
		}
		public void setExpectedJobTimeline(Integer expectedJobTimeline) {
			this.expectedJobTimeline = expectedJobTimeline;
		}
		public BigDecimal getCurrentCTC() {
			return currentCTC;
		}
		public void setCurrentCTC(BigDecimal currentCTC) {
			this.currentCTC = currentCTC;
		}
		public BigDecimal getExpectedCTC() {
			return expectedCTC;
		}
		public void setExpectedCTC(BigDecimal expectedCTC) {
			this.expectedCTC = expectedCTC;
		}
		public String getPreferredJobLocation() {
			return preferredJobLocation;
		}
		public void setPreferredJobLocation(String preferredJobLocation) {
			this.preferredJobLocation = preferredJobLocation;
		}
		public String getCurrentJobLocation() {
			return currentJobLocation;
		}
		public void setCurrentJobLocation(String currentJobLocation) {
			this.currentJobLocation = currentJobLocation;
		}
		public String getLinkedInUrl() {
			return linkedInUrl;
		}
		public void setLinkedInUrl(String linkedInUrl) {
			this.linkedInUrl = linkedInUrl;
		}
		public String getHackerRankUrl() {
			return hackerRankUrl;
		}
		public void setHackerRankUrl(String hackerRankUrl) {
			this.hackerRankUrl = hackerRankUrl;
		}
		public String getGithubUrl() {
			return githubUrl;
		}
		public void setGithubUrl(String githubUrl) {
			this.githubUrl = githubUrl;
		}
		public String getNaukriUrl() {
			return naukriUrl;
		}
		public void setNaukriUrl(String naukriUrl) {
			this.naukriUrl = naukriUrl;
		}
}
