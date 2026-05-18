package com.product.lms.mentor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> viewMentor(@PathVariable String mentorId) {

        Optional<MentorModel> mentor = mRepo.findById(mentorId);

        if (mentor.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Mentor not found");
        }

        return ResponseEntity.ok(mentor.get());
    }
}