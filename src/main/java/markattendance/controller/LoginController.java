package markattendance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import markattendance.service.StudentService;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/login")
	private ResponseEntity<Boolean> login(@RequestParam("student_id") String studentId,
			@RequestParam("password") String password) {
		return new ResponseEntity<Boolean>(studentService.login(studentId, password), HttpStatus.OK);
	}
}
