package com.product.lms.students;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



public class StudentDataCollection {
	private String name;
    private String city;
    private String timeDifference;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTimeDifference() {
		return timeDifference;
	}
	public void setTimeDifference(String timeDifference) {
		this.timeDifference = timeDifference;
	}
	public String getHighestQualification() {
		return highestQualification;
	}
	public void setHighestQualification(String highestQualification) {
		this.highestQualification = highestQualification;
	}
	public String getYearOfGraduation() {
		return yearOfGraduation;
	}
	public void setYearOfGraduation(String yearOfGraduation) {
		this.yearOfGraduation = yearOfGraduation;
	}
	public String getItOrNonItBackground() {
		return itOrNonItBackground;
	}
	public void setItOrNonItBackground(String itOrNonItBackground) {
		this.itOrNonItBackground = itOrNonItBackground;
	}
	public String getDomainOrStreamOfWork() {
		return domainOrStreamOfWork;
	}
	public void setDomainOrStreamOfWork(String domainOrStreamOfWork) {
		this.domainOrStreamOfWork = domainOrStreamOfWork;
	}
	public String getWorkExperience() {
		return workExperience;
	}
	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience;
	}
	public String getAwarenessOfProgramming() {
		return awarenessOfProgramming;
	}
	public void setAwarenessOfProgramming(String awarenessOfProgramming) {
		this.awarenessOfProgramming = awarenessOfProgramming;
	}
	public List<String> getToolsFamiliarWith() {
		return toolsFamiliarWith;
	}
	public void setToolsFamiliarWith(List<String> toolsFamiliarWith) {
		this.toolsFamiliarWith = toolsFamiliarWith;
	}
	public List<String> getToolsAndTechnologiesAlreadyStudiedInDS() {
		return toolsAndTechnologiesAlreadyStudiedInDS;
	}
	public void setToolsAndTechnologiesAlreadyStudiedInDS(List<String> toolsAndTechnologiesAlreadyStudiedInDS) {
		this.toolsAndTechnologiesAlreadyStudiedInDS = toolsAndTechnologiesAlreadyStudiedInDS;
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
	public String getFresherOrWorkingProfessional() {
		return fresherOrWorkingProfessional;
	}
	public void setFresherOrWorkingProfessional(String fresherOrWorkingProfessional) {
		this.fresherOrWorkingProfessional = fresherOrWorkingProfessional;
	}
	public String getCurrentJobStatus() {
		return currentJobStatus;
	}
	public void setCurrentJobStatus(String currentJobStatus) {
		this.currentJobStatus = currentJobStatus;
	}
	public String getCareerGap() {
		return careerGap;
	}
	public void setCareerGap(String careerGap) {
		this.careerGap = careerGap;
	}
	public String getYearsOfCareerGap() {
		return yearsOfCareerGap;
	}
	public void setYearsOfCareerGap(String yearsOfCareerGap) {
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
	public String getResumeFileUrl() {
		return resumeFileUrl;
	}
	public void setResumeFileUrl(String resumeFileUrl) {
		this.resumeFileUrl = resumeFileUrl;
	}
	public String getCareerIntent() {
		return careerIntent;
	}
	public void setCareerIntent(String careerIntent) {
		this.careerIntent = careerIntent;
	}
	public String getTargetedRole() {
		return targetedRole;
	}
	public void setTargetedRole(String targetedRole) {
		this.targetedRole = targetedRole;
	}
	public String getExpectedJobTimeline() {
		return expectedJobTimeline;
	}
	public void setExpectedJobTimeline(String expectedJobTimeline) {
		this.expectedJobTimeline = expectedJobTimeline;
	}
	public String getCurrentCTC() {
		return currentCTC;
	}
	public void setCurrentCTC(String currentCTC) {
		this.currentCTC = currentCTC;
	}
	public String getExpectedCTC() {
		return expectedCTC;
	}
	public void setExpectedCTC(String expectedCTC) {
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
	public String getGitHubUrl() {
		return gitHubUrl;
	}
	public void setGitHubUrl(String gitHubUrl) {
		this.gitHubUrl = gitHubUrl;
	}
	public String getNaukriUrl() {
		return naukriUrl;
	}
	public void setNaukriUrl(String naukriUrl) {
		this.naukriUrl = naukriUrl;
	}
	private String highestQualification;
    private String yearOfGraduation;
    private String itOrNonItBackground;
    private String domainOrStreamOfWork;
    private String workExperience;

    // =========================================
    // 2.3 Technical Details
    // =========================================

    private String awarenessOfProgramming;

    private List<String> toolsFamiliarWith = new ArrayList<>();

    private List<String> toolsAndTechnologiesAlreadyStudiedInDS = new ArrayList<>();

    private String workedOnProjects;
    private String projectDescription;

    // =========================================
    // 2.4 Professional Details
    // =========================================

    private String fresherOrWorkingProfessional;
    private String currentJobStatus;

    private String careerGap;
    private String yearsOfCareerGap;

    private String currentRole;
    private String roleDescription;
    private String currentResponsibilities;

    // =========================================
    // 2.4.1 Project Entries
    // =========================================

       // =========================================
    // 2.5 Resume Upload
    // =========================================

    private String resumeFileUrl;

    // =========================================
    // 2.6 Career Intent & Goals
    // =========================================

    private String careerIntent;
    private String targetedRole;
    private String expectedJobTimeline;

    private String currentCTC;
    private String expectedCTC;

    private String preferredJobLocation;
    private String currentJobLocation;

    // =========================================
    // 2.7 Profile Links
    // =========================================

    private String linkedInUrl;
    private String hackerRankUrl;
    private String gitHubUrl;
    private String naukriUrl;
    
    private List<String> projectEntries = new ArrayList<>();

    public List<String> getProjectEntries() {
        return projectEntries;
    }

    public void setProjectEntries(List<String> projectEntries) {
        this.projectEntries = projectEntries;
    }

    public String getEnrollmentDate() {

        // Generate unique UUID
        String uuid = UUID.randomUUID().toString();

        // Example: combine date + UUID
       String enrollmentDate = LocalDate.now() + "-" + uuid;

        return enrollmentDate;
    }
    
    public StudentDataCollection() {

    }
	public StudentDataCollection(String name, String city, String timeDifference, String highestQualification,
			String yearOfGraduation, String itOrNonItBackground, String domainOrStreamOfWork, String workExperience,
			String awarenessOfProgramming, List<String> toolsFamiliarWith,
			List<String> toolsAndTechnologiesAlreadyStudiedInDS, String workedOnProjects, String projectDescription,
			String fresherOrWorkingProfessional, String currentJobStatus, String careerGap, String yearsOfCareerGap,
			String currentRole, String roleDescription, String currentResponsibilities, String resumeFileUrl,
			String careerIntent, String targetedRole, String expectedJobTimeline, String currentCTC, String expectedCTC,
			String preferredJobLocation, String currentJobLocation, String linkedInUrl, String hackerRankUrl,
			String gitHubUrl, String naukriUrl, List<String> projectEntries) {
		super();
		this.name = name;
		this.city = city;
		this.timeDifference = timeDifference;
		this.highestQualification = highestQualification;
		this.yearOfGraduation = yearOfGraduation;
		this.itOrNonItBackground = itOrNonItBackground;
		this.domainOrStreamOfWork = domainOrStreamOfWork;
		this.workExperience = workExperience;
		this.awarenessOfProgramming = awarenessOfProgramming;
		this.toolsFamiliarWith = toolsFamiliarWith;
		this.toolsAndTechnologiesAlreadyStudiedInDS = toolsAndTechnologiesAlreadyStudiedInDS;
		this.workedOnProjects = workedOnProjects;
		this.projectDescription = projectDescription;
		this.fresherOrWorkingProfessional = fresherOrWorkingProfessional;
		this.currentJobStatus = currentJobStatus;
		this.careerGap = careerGap;
		this.yearsOfCareerGap = yearsOfCareerGap;
		this.currentRole = currentRole;
		this.roleDescription = roleDescription;
		this.currentResponsibilities = currentResponsibilities;
		this.resumeFileUrl = resumeFileUrl;
		this.careerIntent = careerIntent;
		this.targetedRole = targetedRole;
		this.expectedJobTimeline = expectedJobTimeline;
		this.currentCTC = currentCTC;
		this.expectedCTC = expectedCTC;
		this.preferredJobLocation = preferredJobLocation;
		this.currentJobLocation = currentJobLocation;
		this.linkedInUrl = linkedInUrl;
		this.hackerRankUrl = hackerRankUrl;
		this.gitHubUrl = gitHubUrl;
		this.naukriUrl = naukriUrl;
		this.projectEntries = projectEntries;
	}



}
