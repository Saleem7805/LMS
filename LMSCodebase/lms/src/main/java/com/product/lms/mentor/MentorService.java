package com.product.lms.mentor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.lms.students.Activity;
import com.product.lms.students.StudentModel;
import com.product.lms.students.StudentRepo;

@Service 
public class MentorService {

    @Autowired
    MentorRepo mentorRepo;
    
    @Autowired
    StudentRepo sRepo;
    
    
    
    private String generateMentorId() {
        long count = mentorRepo.count() + 1;
        return String.format("MENT%03d", count); 
    }

    private String generatePassword(String name) {
        
        String namePart = name.length() >= 4
                ? name.substring(0, 4)
                : name;
       
        return namePart + "@" ;
        
    }


    

    public Optional<MentorModel> mentorLogin(MentorLoginDTO md) {

    	Optional<MentorModel> mm = mentorRepo.findById(md.getMentorId());

        if (mm.isPresent() && mm.get().getMpassword().equals(md.getMpassword())) {
            return mm;
        } else {
            return Optional.empty();
        }
    }
    
    public synchronized String assignMentorToStudent(
            String pibId) {

        Optional<StudentModel> studentOptional =
                sRepo.findById(pibId);

        if (studentOptional.isEmpty()) {
            return "Student not found";
        }

        StudentModel student = studentOptional.get();

        // Fetch all mentors
        List<MentorModel> mentors = mentorRepo.findAll();

        if (mentors.isEmpty()) {
            return "No mentors available";
        }

        // Select mentor with minimum assigned students
        MentorModel mentor = mentors.get(0);

        for (MentorModel m : mentors) {

            if (m.getNumberOfStudentsAssigned()
                    < mentor.getNumberOfStudentsAssigned()) {

                mentor = m;
            }
        }

        // Prevent duplicate assignment
        if (student.getAssignedMentors() != null
                && student.getAssignedMentors()
                .contains(mentor.getMentorId())) {

            return "Mentor already assigned";
        }

        // Initialize list if null
        if (student.getAssignedMentors() == null) {
            student.setAssignedMentors(
                    new ArrayList<>());
        }

        // Assign mentor
        student.getAssignedMentors()
                .add(mentor.getMentorId());

        mentor.getAssignedStudent()
                .add(pibId);

        // Increase counter
        mentor.setNumberOfStudentsAssigned(
                mentor.getNumberOfStudentsAssigned() + 1);

        // Save both
        sRepo.save(student);

        mentorRepo.save(mentor);

        return "Mentor Assigned Successfully to "
                + mentor.getMentorName();
    }
    
    public List<ViewAssignedStudentDTO> viewAssignedStudent(String mentorId) {

 	    MentorModel mentor = mentorRepo.findById(mentorId)
 	            .orElseThrow(() -> new RuntimeException("Mentor not found"));

 	    List<ViewAssignedStudentDTO> response = new ArrayList<>();

 	    for (String pibId : mentor.getAssignedStudent()) {

 	        StudentModel student = sRepo.findById(pibId)
 	                .orElse(null);

 	        if (student != null) {

 	            ViewAssignedStudentDTO dto =
 	                    new ViewAssignedStudentDTO();

 	            dto.setPibId(student.getPibId());
 	            dto.setStudentName(student.getName());
 	            dto.setCourseTaken(student.getCourseTaken());
 	            dto.setHighestQualification(
 	                    student.getHighestQualification());

 	            response.add(dto);
 	        }
 	    }

 	    return response;
 	}
    
    public MentorModel addPlan(
            String mentorId,
            Plan plan) {

        MentorModel mentor =
                mentorRepo.findById(mentorId).orElseThrow();

        mentor.getPlans().add(plan);

        return mentorRepo.save(mentor);
    }

    public List<Plan> viewPlans(String mentorId) {

        MentorModel mentor =
                mentorRepo.findById(mentorId).orElseThrow();

        return mentor.getPlans();
    }

    public List<String> viewActivities(
            String studentId) {

        StudentModel student =
        		sRepo.findById(studentId).orElseThrow();

        return student.getActiveSessions();
    }
}
