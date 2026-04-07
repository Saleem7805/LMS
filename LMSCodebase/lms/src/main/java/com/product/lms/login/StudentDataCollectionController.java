package com.product.lms.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
public class StudentDataCollectionController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/student-data")
	public ResponseEntity<?> studentDetaCollection(@RequestBody StudentDataCollectionDTO sdc) {

	    StudentModel savedStudent = studentService.addStudentDataModel(sdc);

	    if (savedStudent != null) {
	        return ResponseEntity.status(HttpStatus.CREATED)
	                .body("Data inserted successfully");
	    } else {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                .body("No data inserted");
	    }
	}
}
 