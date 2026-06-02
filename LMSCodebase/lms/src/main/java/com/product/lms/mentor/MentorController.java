package com.product.lms.mentor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.product.lms.students.Activity;

@RestController
@RequestMapping("/mentor")
public class MentorController {

    @Autowired
    MentorService mentorService;

    @Autowired
    MentorRepo mRepo;

    @PostMapping("/mentorLogin")
    public ResponseEntity<?> mentorLogin(@RequestBody MentorLoginDTO md) {

        Optional<MentorModel> mm = mentorService.mentorLogin(md);

        if (mm.isPresent()) {
            return ResponseEntity.ok("Login Successfully");
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Invalid Credentials");
    }

    @GetMapping("/viewAssignedStudent/{mentorId}")
    public List<ViewAssignedStudentDTO> viewAssignedStudent(
            @PathVariable String mentorId) {

        return mentorService.viewAssignedStudent(mentorId);
    }
    
    @PostMapping("/addPlan/{mentorId}")
    public MentorModel addPlan(
            @PathVariable String mentorId,
            @RequestBody Plan plan) {

        return mentorService.addPlan(mentorId, plan);
    }

    @GetMapping("/viewPlans/{mentorId}")
    public List<Plan> viewPlans(
            @PathVariable String mentorId) {

        return mentorService.viewPlans(mentorId);
    }

    @GetMapping("/viewActivities/{studentId}")
    public List<String> viewActivities(
            @PathVariable String studentId) {

        return mentorService.viewActivities(studentId);
    }
}