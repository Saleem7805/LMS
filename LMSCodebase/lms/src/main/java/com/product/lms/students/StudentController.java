package com.product.lms.students;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.product.lms.mentor.MentorModel;
import com.product.lms.mentor.MentorRepo;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    StudentRepo sRepo;

    @Autowired
    MentorRepo mRepo;

    @PostMapping("/studentLogin")
    public Optional<String> studentLogin(
            @RequestBody StudentLoginDTO dto) {

        return studentService.studentLogin(dto);
    }

    @PostMapping("/addStudentInfo")
    public ResponseEntity<?> studentDetaCollection(
            @RequestParam("pid") String pid,
            @RequestBody ProfileUpdate sdc) {

        StudentModel savedStudent =
                studentService.addStudentInfo(pid, sdc);

        if (savedStudent != null) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Profile added successfully");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Student not found or data not saved");
    }

    @GetMapping("/viewAssignedMentor/{studentId}")
    public ResponseEntity<?> viewStudent(
            @PathVariable String studentId) {

        Optional<StudentModel> student =
                sRepo.findById(studentId);

        if (student.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Student not found");
        }

        List<MentorModel> mentors =
                mRepo.findAllById(
                        student.get().getAssignedMentors());

        if (mentors.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No mentors assigned yet");
        }

        return ResponseEntity.ok(mentors);
    }
}