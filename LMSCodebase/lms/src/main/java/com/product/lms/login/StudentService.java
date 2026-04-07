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
 	
 	
 	public StudentModel addStudentDataModel(StudentDataCollectionDTO dto) {

 	    StudentModel studentModel = new StudentModel();

 	    // Basic Info
 	    studentModel.setCity(dto.getCity());
 	    studentModel.setTime_Difference(dto.getTime_Difference());
 	    studentModel.setHighest_Qualification(dto.getHighest_Qualification());
 	    studentModel.setYear_of_Graduation(dto.getYear_of_Graduation());
 	    studentModel.setBackground(dto.getBackgroundType());
 	    studentModel.setBackground(dto.getBackground());

 	    // Work Info
 	    
 	    studentModel.setWork_Experience(dto.getWork_Experience());

 	    // Technical Awareness
 	    studentModel.setProgrammingAwareness(dto.getProgrammingAwareness());
 	    studentModel.setToolsFamiliarWith(dto.getToolsFamiliarWith());
 	    studentModel.setDsTools(dto.getDsTools());

 	    // Projects
 	    studentModel.setWorkedOnProjects(dto.getWorkedOnProjects());
 	    studentModel.setProjectDescription(dto.getProjectDescription());

 	    // Professional Info
 	   
 	    studentModel.setCareerGap(dto.getCareerGap());
 	    studentModel.setYearsOfCareerGap(dto.getYearsOfCareerGap());

 	    studentModel.setCurrentRole(dto.getCurrentRole());
 	    studentModel.setRoleDescription(dto.getRoleDescription());
 	    studentModel.setCurrentResponsibilities(dto.getCurrentResponsibilities());

 	    // Project Details
 	    studentModel.setProjectName(dto.getProjectName());
 	    studentModel.setToolsAndTechnologies(dto.getToolsAndTechnologies());

 	    // Career Info
 	    
 	    studentModel.setTargetedRole(dto.getTargetedRole());
 	    studentModel.setExpectedJobTimeline(dto.getExpectedJobTimeline());

 	    studentModel.setCurrentCTC(dto.getCurrentCTC());
 	    studentModel.setExpectedCTC(dto.getExpectedCTC());

 	    studentModel.setPreferredJobLocation(dto.getPreferredJobLocation());
 	    studentModel.setCurrentJobLocation(dto.getCurrentJobLocation());

 	    // Social Links
 	    studentModel.setLinkedInUrl(dto.getLinkedInUrl());
 	    studentModel.setHackerRankUrl(dto.getHackerRankUrl());
 	    studentModel.setGithubUrl(dto.getGithubUrl());
 	    studentModel.setNaukriUrl(dto.getNaukriUrl());

 	    // Resume
 	    

 	    return sr.save(studentModel);
 	    
 	}
 	
}