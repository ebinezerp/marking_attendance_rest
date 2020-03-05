package markattendance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import markattendance.model.Batch;
import markattendance.model.Employee;
import markattendance.repository.BatchRepository;
import markattendance.repository.EmployeeRepository;

@Service
public class BatchService {
	@Autowired
	private BatchRepository batchRepository;

	public List<Batch> getBatchEmployee(Employee employee) {
		try {
			return batchRepository.findByEmployee(employee);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Batch getBatch(String batchCode) {
		try {
			return batchRepository.getOne(batchCode);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
