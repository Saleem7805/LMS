package com.product.lms.students;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.product.lms.mentor.AddMentorDTO;
import com.product.lms.mentor.MentorModel;
import com.product.lms.mentor.MentorRepo;
import com.product.lms.utility.EmailService;

@Service
public class AdminService {
	
	@Autowired
	CourseRepo cRepo;

    @Autowired
    private AdminRepo ar;

    @Autowired
    private MentorRepo mRepo;

    @Autowired
    private StudentRepo sRepo;

    @Autowired 
    private EmailService eService;
    private String generateMentorId() {
        long count = mRepo.count() + 1;
        return String.format("MENT%03d", count);
    }

    private String generatePassword(String name) {

        String namePart =
                name.length() >= 4
                        ? name.substring(0, 4)
                        : name;

        return namePart + "@123";
    }

    public MentorModel addMentor(AddMentorDTO dto) {

        MentorModel mentor = new MentorModel();

        String mentorId = generateMentorId();
        String password = generatePassword(dto.getMentorName());

        mentor.setMentorId(mentorId);
        mentor.setMpassword(password);

        mentor.setMentorName(dto.getMentorName());
        mentor.setMentorQualification(
                dto.getMentorQualification());

        mentor.setMentorYoe(dto.getMentorYoe());

        mentor.setSpecializationDomain(
                dto.getSpecializationDomain());

        mentor.setAssignedStudent(new ArrayList<>());

        return mRepo.save(mentor);
    }

    public List<MentorModel> displayMentor() {

        List<MentorModel> mentorModels =
                mRepo.findAll();

        if (!mentorModels.isEmpty()) {
            return mentorModels;
        }

        throw new RuntimeException("No Mentors Found");
    }

    private static int mentorIndex = 0;

    public synchronized String assignMentorToStudent(
            String pibId) {

        Optional<StudentModel> studentOptional =
                sRepo.findById(pibId);

        if (studentOptional.isEmpty()) {
            return "Student not found";
        }

        StudentModel student = studentOptional.get();

        // Fetch all mentors
        List<MentorModel> mentors = mRepo.findAll();

        if (mentors.isEmpty()) {
            return "No mentors available";
        }

        // Reset index if exceeds mentor count
        if (mentorIndex >= mentors.size()) {
            mentorIndex = 0;
        }

        // Get mentor sequentially
        MentorModel mentor = mentors.get(mentorIndex);

        // Initialize student mentor list
        if (student.getAssignedMentors() == null) {
            student.setAssignedMentors(
                    new ArrayList<>());
        }

        // Initialize mentor student list
        if (mentor.getAssignedStudent() == null) {
            mentor.setAssignedStudent(
                    new ArrayList<>());
        }

        // Prevent duplicate assignment
        if (student.getAssignedMentors()
                .contains(mentor.getMentorId())) {

            return "Mentor already assigned";
        }

        // Assign mentor
        student.getAssignedMentors()
                .add(mentor.getMentorId());

        mentor.getAssignedStudent()
                .add(pibId);

        // Save updates
        sRepo.save(student);

        mRepo.save(mentor);

        // Move to next mentor
        mentorIndex++;

        return "Mentor Assigned Successfully to "
                + mentor.getMentorName();
    }

    public Optional<MentorModel> displayMentorById(
            String mentorId) {

        Optional<MentorModel> mentorModels =
                mRepo.findById(mentorId);

        if (mentorModels.isPresent()) {
            return mentorModels;
        }

        throw new RuntimeException("No Mentor Id Found");
    }

    public String updateMentor(MentorModel mm) {

        Optional<MentorModel> updateMentorModels =
                mRepo.findById(mm.getMentorId());

        if (updateMentorModels.isPresent()) {

            MentorModel mentorModel =
                    updateMentorModels.get();

            mentorModel.setMpassword(mm.getMpassword());
            mentorModel.setMentorName(mm.getMentorName());

            mentorModel.setMentorQualification(
                    mm.getMentorQualification());

            mentorModel.setMentorYoe(
                    mm.getMentorYoe());

            mentorModel.setSpecializationDomain(
                    mm.getSpecializationDomain());

            mentorModel.setAssignedStudent(
                    mm.getAssignedStudent());

            mRepo.save(mentorModel);

            return "Mentor Updated Successfully";
        }

        throw new RuntimeException("Mentor Not Found");
    }

    public String deleteMentor(String mentorId) {

        Optional<MentorModel> mentor =
                mRepo.findById(mentorId);

        if (mentor.isPresent()) {

            mRepo.deleteById(mentorId);

            return "Mentor Deleted Successfully";
        }

        throw new RuntimeException("Mentor Not Found");
    }
    
    
    public String loginAdmin(AdminDTO adminDTO) {

        AdminModel admin =
                ar.findByUsername(adminDTO.getUsername());

        if (admin == null) {
            return "User not found!";
        }

        if (admin.getPassword()
                .equals(adminDTO.getPassword())) {

            return "Login Success";
        }

        return "Invalid Password!";
    }
    
    
    
        // Send email
        
        Optional<StudentModel> forgetPassword(String pibId) {

            StudentModel s = sRepo.findByPibId(pibId);

            if (s == null) {
                return Optional.empty();
            }

            String mail = s.getEmailId();

            // Check email exists
            if (mail == null || mail.isBlank()) {

                throw new RuntimeException(
                        "Student email is missing for PIB ID: " + pibId);
            }

            // Generate password
            String newPassword1 = UUID.randomUUID()
                    .toString()
                    .replace("-", "")
                    .substring(0, 8);

            // Save password
            s.setPassword(newPassword1);

            sRepo.save(s);

            // Send email
            eService.sendPasswordMail(mail, newPassword1);

            return Optional.of(s);
        }
        
        public Course addCourse(Course course) {

            if (course.getCourseId() != null && !course.getCourseId().isEmpty()) {
                return cRepo.save(course);
            }

            throw new RuntimeException("Course ID cannot be null or empty");
        }
        
        public List<AdminModel> viewAdmins() {
            return ar.findAll();
        }

}
