package com.product.lms.students;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.product.lms.mentor.AddMentorDTO;
import com.product.lms.mentor.MentorModel;
import com.product.lms.mentor.MentorService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    MentorService mentorService;

    @PostMapping("/adminLogin")
    public ResponseEntity<String> loginAdmin(
            @RequestBody AdminDTO adminDTO) {

        String result = adminService.loginAdmin(adminDTO);

        if (result.equals("Login Success")) {
            return ResponseEntity.ok(result);
        }

        else if (result.equals("User not found!")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(result);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(result);
    }

    @PostMapping("/assignMentor/{mentorId}/{pibId}")
    public ResponseEntity<?> assignMentor(
            @PathVariable String mentorId,
            @PathVariable String pibId) {

        return ResponseEntity.ok(
                adminService.assignMentorToStudent(pibId, mentorId));
    }

    @PostMapping("/addMentor")
    public ResponseEntity<?> addMentor(
            @RequestBody AddMentorDTO md) {

        MentorModel saved = adminService.addMentor(md);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(saved);
    }

    @GetMapping("/getAllMentors")
    public ResponseEntity<?> getAllMentors() {

        List<MentorModel> mentor =
                adminService.displayMentor();

        return ResponseEntity.ok(mentor);
    }

    @GetMapping("/getAllMentors/{id}")
    public ResponseEntity<?> getAllMentorById(
            @PathVariable("id") String mentorId) {

        Optional<MentorModel> mentorModels =
                adminService.displayMentorById(mentorId);

        return ResponseEntity.ok(mentorModels);
    }

    @PutMapping("/updateMentor")
    public ResponseEntity<?> updateMentor(
            @RequestBody MentorModel mm) {

        String response =
                adminService.updateMentor(mm);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/deleteMentor/{mentorId}")
    public ResponseEntity<?> deleteMentor(
            @PathVariable String mentorId) {

        String response =
                adminService.deleteMentor(mentorId);

        return ResponseEntity.ok(response);
    }
}