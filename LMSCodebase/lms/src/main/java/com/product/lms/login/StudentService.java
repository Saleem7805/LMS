package com.product.lms.login;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepo sr;
    public Optional<StudentModel> login(StudentDTO std) {
        Optional<StudentModel> user = sr.findById(std.getPibId());
        
        if(user.isPresent() && user.get().getPassword().equals(std.getPassword()))
        {
        	return user;
        }
        
        return Optional.empty();
       }
    
 	
 	
 	public StudentModel addStudent(AddStudentDTO dto) {
 		
 		StudentModel student = new StudentModel();
 		
 		student.setEnrollmentDate(dto.getEnrollmentDate());
 		student.setName(dto.getName());
 		student.setCourseTaken(dto.getCourseTaken());
 		student.setPhoneNumber(dto.getPhoneNumber());
 		student.setRole(dto.getRole());
 		student.setPassword(dto.getPassword());
 		student.setEmailId(dto.getEmailId());
 		
 		String pass = generatePibId(dto);
 		student.setPibId(pass);
 		return sr.save(student);
 		

 	}
 	
 	private String generatePibId(AddStudentDTO dto) {
        

         return "PIBS" + dto.getEnrollmentDate();
     }
 	
 	
 	public StudentModel addStudentDataModel(String pid, StudentDataCollectionDTO dto) {

 	    return sr.findById(pid).map(student -> {

 	        // 🔹 Basic Info
 	        student.setCity(dto.getCity());
 	        student.setTime_Difference(dto.getTime_Difference());
 	        student.setHighest_Qualification(dto.getHighest_Qualification());
 	        student.setYear_of_Graduation(dto.getYear_of_Graduation());
 	        student.setBackground(dto.getBackground());

 	        // 🔹 Work Info
 	        student.setWork_Experience(dto.getWork_Experience());

 	        // 🔹 Technical Awareness
 	        student.setProgrammingAwareness(dto.getProgrammingAwareness());
 	        student.setToolsFamiliarWith(dto.getToolsFamiliarWith());
 	        student.setDsTools(dto.getDsTools());

 	        // 🔹 Projects
 	        student.setWorkedOnProjects(dto.getWorkedOnProjects());
 	        student.setProjectDescription(dto.getProjectDescription());

 	        // 🔹 Professional Info
 	        student.setCareerGap(dto.getCareerGap());
 	        student.setYearsOfCareerGap(dto.getYearsOfCareerGap());

 	        student.setCurrentRole(dto.getCurrentRole());
 	        student.setRoleDescription(dto.getRoleDescription());
 	        student.setCurrentResponsibilities(dto.getCurrentResponsibilities());

 	        // 🔹 Project Details
 	        student.setProjectName(dto.getProjectName());
 	        student.setToolsAndTechnologies(dto.getToolsAndTechnologies());

 	        // 🔹 Career Info
 	        student.setTargetedRole(dto.getTargetedRole());
 	        student.setExpectedJobTimeline(dto.getExpectedJobTimeline());

 	        student.setCurrentCTC(dto.getCurrentCTC());
 	        student.setExpectedCTC(dto.getExpectedCTC());

 	        student.setPreferredJobLocation(dto.getPreferredJobLocation());
 	        student.setCurrentJobLocation(dto.getCurrentJobLocation());

 	        // 🔹 Social Links
 	        student.setLinkedInUrl(dto.getLinkedInUrl());
 	        student.setHackerRankUrl(dto.getHackerRankUrl());
 	        student.setGithubUrl(dto.getGithubUrl());
 	        student.setNaukriUrl(dto.getNaukriUrl());

 	        // ✅ Save updated student
 	        return sr.save(student);

 	    }).orElse(null); // if pid not found
 	}
}