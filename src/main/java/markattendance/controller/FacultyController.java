package markattendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import markattendance.model.Batch;
import markattendance.model.BatchSession;
import markattendance.model.Employee;
import markattendance.model.SessionLocation;
import markattendance.repository.SessionLocationRepository;
import markattendance.service.BatchService;
import markattendance.service.BatchSessionService;
import markattendance.service.EmployeeService;
import markattendance.service.SessionLocationService;

@RestController
@RequestMapping("/faculty")
@CrossOrigin(origins = "*")
public class FacultyController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private BatchService batchService;
	@Autowired
	private BatchSessionService batchSessionService;
	@Autowired
	private SessionLocationService sessionLocationService;

	@GetMapping("/{empCode}/batches")
	public ResponseEntity<List<Batch>> getBatches(@PathVariable("empCode") String empCode) {
		System.out.println(empCode);
		Employee employee = employeeService.getEmployee(empCode);
		if (employee == null) {
			return new ResponseEntity<List<Batch>>(HttpStatus.NOT_FOUND);
		} else {
			List<Batch> batches = batchService.getBatchEmployee(employee);
			return new ResponseEntity<List<Batch>>(batches, HttpStatus.OK);
		}
	}

	@PostMapping("/activate")
	public ResponseEntity<Boolean> activate(@RequestBody List<BatchSession> batchSessions,
			@RequestParam("batchCode") String batchCode) {
		Batch batch = batchService.getBatch(batchCode);

		System.out.println(batchSessions.get(0).getSessionLocation());
		SessionLocation sessionLocation = batchSessions.get(0).getSessionLocation();
		if (sessionLocationService.save(sessionLocation)) {
			for (BatchSession batchSession : batchSessions) {
				batchSession.setBatch(batch);
				batchSession.setTriggerd(true);
				batchSession.setSessionLocation(sessionLocation);
			}

			if (batchSessionService.update(batchSessions)) {
				return new ResponseEntity<Boolean>(true, HttpStatus.OK);
			} else {
				return new ResponseEntity<Boolean>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return new ResponseEntity<Boolean>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
