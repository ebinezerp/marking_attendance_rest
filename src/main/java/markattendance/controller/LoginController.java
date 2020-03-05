package markattendance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import markattendance.model.Employee;
import markattendance.service.EmployeeService;
import markattendance.service.StudentService;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/login/std")
	private ResponseEntity<Boolean> login(@RequestParam("studentId") String studentId,
			@RequestParam("password") String password) {
		return new ResponseEntity<Boolean>(studentService.login(studentId, password), HttpStatus.OK);
	}

	@PostMapping("/login/faculty")
	public ResponseEntity<Employee> loginFaculty(@RequestBody Employee employee) {
		employee = employeeService.getEmployee(employee.getEmpCode(), employee.getCenterCode(), employee.getPassword(),
				"tech-mentor");

		if (employee != null) {
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} else {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/")
	public String index() {
		return "hello world";
	}
}
