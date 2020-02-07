package markattendance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import markattendance.model.Batch;
import markattendance.model.Employee;

public interface BatchRepository extends JpaRepository<Batch, String> {

	public List<Batch> findByEmployee(Employee employee);
}
