package markattendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import markattendance.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

	public Employee findByCenterCodeAndEmpCodeAndPasswordAndRole(String centerCode, String empCode, String password,
			String role);

}
