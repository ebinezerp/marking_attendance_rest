package markattendance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import markattendance.model.Employee;
import markattendance.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee getEmployee(String empCode) {
		try {
			return employeeRepository.getOne(empCode);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Employee getEmployee(String empCode, String centerCode, String password, String role) {
		try {
			return employeeRepository.findByCenterCodeAndEmpCodeAndPasswordAndRole(centerCode, empCode, password, role);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
