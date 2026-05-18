package com.product.lms.students;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.lms.mentor.AddMentorDTO;
import com.product.lms.mentor.MentorModel;
import com.product.lms.mentor.MentorRepo;

@Service
public class AdminService {

    @Autowired
    private AdminRepo ar;

    @Autowired
    private MentorRepo mRepo;

    @Autowired
    private StudentRepo sRepo;

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

    public String assignMentorToStudent(
            String pibId,
            String mentorId) {

        Optional<MentorModel> mentorOptional =
                mRepo.findById(mentorId);

        Optional<StudentModel> studentOptional =
                sRepo.findById(pibId);

        if (mentorOptional.isEmpty()) {
            return "Mentor is not found";
        }

        if (studentOptional.isEmpty()) {
            return "Student is not found";
        }

        MentorModel mentor = mentorOptional.get();
        StudentModel student = studentOptional.get();

        if (student.getAssignedMentors() == null) {
            student.setAssignedMentors(new ArrayList<>());
        }

        if (mentor.getAssignedStudent() == null) {
            mentor.setAssignedStudent(new ArrayList<>());
        }

        if (student.getAssignedMentors()
                .contains(mentorId)) {

            return "Mentor already assigned";
        }

        student.getAssignedMentors().add(mentorId);
        mentor.getAssignedStudent().add(pibId);

        sRepo.save(student);
        mRepo.save(mentor);

        return "Mentor Assigned Successfully";
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
}