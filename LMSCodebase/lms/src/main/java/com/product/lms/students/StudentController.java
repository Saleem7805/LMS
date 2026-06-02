package com.product.lms.students;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
    
    @Autowired
    AdminService adminService;
    
    

    @PostMapping("/studentLogin")
    public StudentLoginDTO studentLogin(
            @RequestBody StudentLoginDTO dto) {

        return studentService.studentLogin(dto);
    }
    
    @PostMapping("/reset-password")
    public String resetPassword(@RequestBody ResetPasswordDTO dto) {

        return studentService.resetPassword(dto);
    }
    
    @PostMapping("/logout")
    public String logout(
            @RequestParam String pibId,
            @RequestParam String sessionId) {

        return studentService.logout(pibId, sessionId);
    }
   

    @PostMapping("/addStudentCollectionData/{pid}")
    public StudentModel addStudentCollectionData(
            @PathVariable String pid,
            @RequestBody StudentDataCollection dto) {

        return studentService.addStudentCollectionData(pid, dto);
    }

    @GetMapping("/viewAssignedMentor/{pibId}")
    public List<ViewAssignedMentorDTO> viewAssignedMentor(
            @PathVariable String pibId) {

        return studentService.viewAssignedMentor(pibId);
    }
    
    // VIEW AUTO-POPULATED DATA
    @GetMapping("/viewAdditionalInfo/{pibId}")
    public StudentAdditionalInformationDTO viewAdditionalInfo(
            @PathVariable String pibId) {

        return studentService.getStudentAdditionalInfo(pibId);
    }
    
    @PostMapping("/addActivity/{studentId}")
    public StudentModel addActivity(
            @PathVariable String studentId,
            @RequestBody String activity) {

        return studentService.addActivity(
                studentId,
                activity);
    }

    @GetMapping("/viewActivities/{studentId}")
    public List<String> viewActivities(
            @PathVariable String studentId) {

        return studentService.viewActivities(studentId);
    }
    
    @PostMapping(value = "/uploadResume/{pibId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadResume(
            @PathVariable String pibId,
            @RequestParam("file") MultipartFile file) {
        
        String result = studentService.uploadResume(pibId, file);
        return ResponseEntity.ok(result);
    }
    
    
}