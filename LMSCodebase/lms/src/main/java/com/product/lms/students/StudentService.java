package com.product.lms.students;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.lms.mentor.MentorModel;

@Service
public class StudentService {

    @Autowired
    StudentRepo sr;
    public Optional<String> studentLogin(StudentLoginDTO std) {
        Optional<StudentModel> user = sr.findById(std.getPibId());
        
        if(user.isPresent() && user.get().getPassword().equals(std.getPassword()))
        {
        	return Optional.of("Student Login Sucessfully");
        }
        
        return Optional.of("Please enter correct credentials");
       }
    
 	
 	
    public StudentModel addStudentInfo(String pid, ProfileUpdate dto) {

        // ✅ Fetch EXISTING student by pid from DB
        StudentModel student = sr.findById(pid).orElse(null);

        // ✅ If not found return null
        if (student == null) {
            return null;
        }

        // ✅ Update fields on existing student
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

        // ✅ Saves back to SAME document in DB
        return sr.save(student);
    }
    
    
 	private String generatePibId(ProfileUpdate dto) {
        

         return "PIBS" + dto.getEnrollmentDate();
     }
 	
 	
}