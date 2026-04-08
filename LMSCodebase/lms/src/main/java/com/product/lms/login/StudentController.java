package com.product.lms.login;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/students")
public class StudentController {
    @Autowired
     StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/login")
    public Optional <StudentModel> login(@RequestBody StudentDTO dto)
    {
    	return studentService.login(dto);
    }
    
    @PostMapping("/addInfo")
    public ResponseEntity<?> studentDetaCollection(
            @RequestParam("pid") String pid,
            @RequestBody StudentDataCollectionDTO sdc) {

        StudentModel savedStudent = studentService.addStudentDataModel(pid, sdc);

        if (savedStudent != null) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Profile added successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Student not found or data not saved");
        }
    }
	}
