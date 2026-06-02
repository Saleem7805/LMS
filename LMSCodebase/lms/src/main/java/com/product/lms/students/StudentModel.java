package com.product.lms.students;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Student")
public class StudentModel {

    @Id
    @Field("pibid")
    private String pibId;

    @Field("enrollmentdate")
    private String enrollmentDate;

    @Field("coursestartdate")
    private String courseStartDate;

    @Field("coursetaken")
    private String courseTaken;

    @Field("selectedlanguage")
    private String selectedLanguage;

    @Field("assignedmentor")
    private String assignedMentor;

    @Field("enrollmenttype")
    private String enrollmentType;

    @Field("phonenumber")
    private String phoneNumber;

    @Field("emailid")
    private String emailId;

    @Field("additionalinfo")
    private String additionalInfo;

    private String role;

    private String password;

    private boolean firstLogin = true;

    private String otp;

    private LocalDateTime otpExpiry;

    private boolean passwordResetRequested;

    private List<String> activeSessions = new ArrayList<>();

    private List<String> assignedMentors = new ArrayList<>();

    // =========================================
    // 2.1 Basic Information
    // =========================================

    private String name;
    private String city;
    private String timeDifference;

    // =========================================
    // 2.2 Educational Background
    // =========================================

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
    
    
    private List<Activity> activities = new ArrayList<>();

    // =========================================
    // GETTERS & SETTERS
    // =========================================

    public String getPibId() {
        return pibId;
    }

    public void setPibId(String pibId) {
        this.pibId = pibId;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
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

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(boolean firstLogin) {
        this.firstLogin = firstLogin;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public LocalDateTime getOtpExpiry() {
        return otpExpiry;
    }

    public void setOtpExpiry(LocalDateTime otpExpiry) {
        this.otpExpiry = otpExpiry;
    }

    public boolean isPasswordResetRequested() {
        return passwordResetRequested;
    }

    public void setPasswordResetRequested(boolean passwordResetRequested) {
        this.passwordResetRequested = passwordResetRequested;
    }

    public List<String> getActiveSessions() {
        return activeSessions;
    }

    public void setActiveSessions(List<String> activeSessions) {
        this.activeSessions = activeSessions;
    }

    public List<String> getAssignedMentors() {
        return assignedMentors;
    }

    public void setAssignedMentors(List<String> assignedMentors) {
        this.assignedMentors = assignedMentors;
    }

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

    public void setToolsAndTechnologiesAlreadyStudiedInDS(
            List<String> toolsAndTechnologiesAlreadyStudiedInDS) {
        this.toolsAndTechnologiesAlreadyStudiedInDS =
                toolsAndTechnologiesAlreadyStudiedInDS;
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

    public void setFresherOrWorkingProfessional(
            String fresherOrWorkingProfessional) {
        this.fresherOrWorkingProfessional =
                fresherOrWorkingProfessional;
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
    
    private List<String> projectEntries = new ArrayList<>();

    public List<String> getProjectEntries() {
        return projectEntries;
    }

    public void setProjectEntries(List<String> projectEntries) {
        this.projectEntries = projectEntries;
    }
}