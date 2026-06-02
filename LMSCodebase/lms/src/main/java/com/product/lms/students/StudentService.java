package com.product.lms.students;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.product.lms.mentor.MentorModel;
import com.product.lms.mentor.MentorRepo;

@Service
public class StudentService {

    @Autowired
    StudentRepo sr;
    
    @Autowired 
    MentorRepo mentorRepo;
  
   

    
    
    public String logout(String pibId, String sessionId) {

        Optional<StudentModel> optionalUser =
                sr.findById(pibId);

        if(optionalUser.isEmpty()) {
            return "Student not found";
        }

        StudentModel user = optionalUser.get();

        if(user.getActiveSessions() != null) {

            user.getActiveSessions().remove(sessionId);

            sr.save(user);
        }

        return "Logout successful";
    }
    
    public String resetPassword(ResetPasswordDTO dto) {

        Optional<StudentModel> optionalUser = sr.findById(dto.getPibId());

        // check user exists or not
        if (optionalUser.isEmpty()) {
            return "User not found!";
        }

        // get actual object from Optional
        StudentModel user = optionalUser.get();

        // check old password
        if (!user.getPassword().equals(dto.getOldPassword())) {
            return "Old password is incorrect!";
        }

        // check first login
        if (!user.isFirstLogin()) {
            return "Password already reset!";
        }

        // set new password
        user.setPassword(dto.getNewPassword());

        // update first login flag
        user.setFirstLogin(false);

        // save updated user
        sr.save(user);

        return "Password reset successful!";
    }
 	
    
    
    
   
    
    
    
    
 	private String generatePibId(StudentDataCollection dto) {
        

         return "PIBS" + dto.getEnrollmentDate();
     }
 	
 	
 	
 	public StudentLoginDTO studentLogin(StudentLoginDTO std) {

 	    Optional<StudentModel> optionalUser =
 	            sr.findById(std.getPibId());

 	    if(optionalUser.isPresent() &&
 	       optionalUser.get().getPassword()
 	               .equals(std.getPassword())) {

 	        StudentModel user = optionalUser.get();

 	        // initialize list if null
 	        if(user.getActiveSessions() == null) {

 	            user.setActiveSessions(
 	                    new ArrayList<>());
 	        }

 	        // CHECK LOGIN LIMIT
 	        if(user.getActiveSessions().size() >= 2) {

 	            StudentLoginDTO response =
 	                    new StudentLoginDTO();

 	            response.setMessage(
 	                    "Maximum 2 devices allowed. Third login denied."
 	            );

 	            return response;
 	        }
 	        
 	        
 	        
 	   

 	        // GENERATE SESSION ID
 	        String sessionId =
 	                UUID.randomUUID().toString();

 	        // SAVE SESSION
 	        user.getActiveSessions().add(sessionId);

 	        sr.save(user);

 	        StudentLoginDTO response =
 	                new StudentLoginDTO();

 	        response.setMessage(
 	                "Student Login Successfully"
 	        );

 	        response.setSessionId(sessionId);

 	        return response;
 	    }

 	    StudentLoginDTO response =
 	            new StudentLoginDTO();

 	    response.setMessage(
 	            "Please enter correct credentials"
 	    );

 	    return response;
 	}
 	
 	public StudentAdditionalInformationDTO getStudentAdditionalInfo(String pibId) {

 	    StudentModel student = sr.findByPibId(pibId);

 	    StudentAdditionalInformationDTO dto = new StudentAdditionalInformationDTO();

 	    dto.setPibId(student.getPibId());
 	    dto.setEnrollmentDate(student.getEnrollmentDate());
 	    dto.setCourseStartDate(student.getCourseStartDate());
 	    dto.setCourseTaken(student.getCourseTaken());
 	    dto.setSelectedLanguage(student.getSelectedLanguage());
 	    dto.setAssignedMentor(student.getAssignedMentor());
 	    dto.setEnrollmentType(student.getEnrollmentType());
 	    dto.setPhoneNumber(student.getPhoneNumber());
 	    dto.setEmailId(student.getEmailId());
 	    dto.setAdditionalInfo(student.getAdditionalInfo());

 	    return dto;
 	}
 	
 	public StudentModel addStudentCollectionData(
 	        String pid,
 	        StudentDataCollection dto) {

 	    // Fetch existing student
 	    StudentModel student = sr.findById(pid).orElse(null);

 	    // If student not found
 	    if (student == null) {
 	        return null;
 	    }

 	    // =========================================
 	    // 2.1 Basic Information
 	    // =========================================

 	    student.setName(dto.getName());
 	    student.setCity(dto.getCity());
 	    student.setTimeDifference(dto.getTimeDifference());

 	    // =========================================
 	    // 2.2 Educational Background
 	    // =========================================

 	    student.setHighestQualification(
 	            dto.getHighestQualification());

 	    student.setYearOfGraduation(
 	            dto.getYearOfGraduation());

 	    student.setItOrNonItBackground(
 	            dto.getItOrNonItBackground());

 	    student.setDomainOrStreamOfWork(
 	            dto.getDomainOrStreamOfWork());

 	    student.setWorkExperience(
 	            dto.getWorkExperience());

 	    // =========================================
 	    // 2.3 Technical Details
 	    // =========================================

 	    student.setAwarenessOfProgramming(
 	            dto.getAwarenessOfProgramming());

 	    student.setToolsFamiliarWith(
 	            dto.getToolsFamiliarWith());

 	    student.setToolsAndTechnologiesAlreadyStudiedInDS(
 	            dto.getToolsAndTechnologiesAlreadyStudiedInDS());

 	    student.setWorkedOnProjects(
 	            dto.getWorkedOnProjects());

 	    student.setProjectDescription(
 	            dto.getProjectDescription());

 	    // =========================================
 	    // 2.4 Professional Details
 	    // =========================================

 	    student.setFresherOrWorkingProfessional(
 	            dto.getFresherOrWorkingProfessional());

 	    student.setCurrentJobStatus(
 	            dto.getCurrentJobStatus());

 	    student.setCareerGap(
 	            dto.getCareerGap());

 	    student.setYearsOfCareerGap(
 	            dto.getYearsOfCareerGap());

 	    student.setCurrentRole(
 	            dto.getCurrentRole());

 	    student.setRoleDescription(
 	            dto.getRoleDescription());

 	    student.setCurrentResponsibilities(
 	            dto.getCurrentResponsibilities());

 	    // =========================================
 	    // 2.4.1 Project Entries
 	    // =========================================

 	    student.setProjectEntries(
 	            dto.getProjectEntries());

 	    // =========================================
 	    // 2.5 Resume Upload
 	    // =========================================

 	    student.setResumeFileUrl(
 	            dto.getResumeFileUrl());

 	    // =========================================
 	    // 2.6 Career Intent & Goals
 	    // =========================================

 	    student.setCareerIntent(
 	            dto.getCareerIntent());

 	    student.setTargetedRole(
 	            dto.getTargetedRole());

 	    student.setExpectedJobTimeline(
 	            dto.getExpectedJobTimeline());

 	    student.setCurrentCTC(
 	            dto.getCurrentCTC());

 	    student.setExpectedCTC(
 	            dto.getExpectedCTC());

 	    student.setPreferredJobLocation(
 	            dto.getPreferredJobLocation());

 	    student.setCurrentJobLocation(
 	            dto.getCurrentJobLocation());

 	    // =========================================
 	    // 2.7 Profile Links
 	    // =========================================

 	    student.setLinkedInUrl(
 	            dto.getLinkedInUrl());

 	    student.setHackerRankUrl(
 	            dto.getHackerRankUrl());

 	    student.setGitHubUrl(
 	            dto.getGitHubUrl());

 	    student.setNaukriUrl(
 	            dto.getNaukriUrl());

 	    // Save updated document
 	    return sr.save(student);
 	}
 	
 	public List<ViewAssignedMentorDTO> viewAssignedMentor(String pibId) {

 	    List<MentorModel> mentors =
 	            mentorRepo.findByAssignedStudentContaining(pibId);

 	    List<ViewAssignedMentorDTO> response = new ArrayList<>();

 	    for (MentorModel mentor : mentors) {

 	        ViewAssignedMentorDTO dto = new ViewAssignedMentorDTO();

 	        dto.setMentorId(mentor.getMentorId());
 	        dto.setMentorName(mentor.getMentorName());
 	        dto.setMentorQualification(mentor.getMentorQualification());
 	        dto.setMentorYoe(mentor.getMentorYoe());
 	        dto.setSpecializationDomain(mentor.getSpecializationDomain());

 	        response.add(dto);
 	    }

 	    return response;
 	}
 	public StudentModel addActivity(
            String studentId,
            String activity) {

        StudentModel student =
        		sr.findById(studentId).orElseThrow();

        student.getActiveSessions().add(activity);

        return sr.save(student);
    }

    public List<String> viewActivities(
            String studentId) {

        StudentModel student =
        		sr.findById(studentId).orElseThrow();

        return student.getActiveSessions();
    }
    public String uploadResume(String pibId, MultipartFile file) {

        StudentModel student = sr.findByPibId(pibId);

        if (student == null) {
            throw new RuntimeException("Student not found");
        }

        try {
            // Define upload directory
            String uploadDir = "uploads/resumes/";
            Files.createDirectories(Paths.get(uploadDir));

            // Save file with unique name
            String fileName = pibId + "_" + file.getOriginalFilename();
            Path filePath = Paths.get(uploadDir + fileName);
            Files.write(filePath, file.getBytes());

            // Save URL/path to student
            student.setResumeFileUrl(filePath.toString());
            sr.save(student);

            return "Resume uploaded successfully: " + fileName;

        } catch (Exception e) {
            throw new RuntimeException("File upload failed: " + e.getMessage());
        }
    }
   
 	
}