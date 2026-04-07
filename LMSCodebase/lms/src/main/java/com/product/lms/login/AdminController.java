package com.product.lms.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AdminController 
{
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/addStudent")
	 public StudentModel add(@RequestBody AddStudentDTO addStudentDTO) {

        return studentService.addStudent(addStudentDTO);
    }

}
