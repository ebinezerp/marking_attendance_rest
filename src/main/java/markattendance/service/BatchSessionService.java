package markattendance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import markattendance.model.BatchSession;
import markattendance.repository.BatchSessionRepository;

@Service
public class BatchSessionService {

	@Autowired
	private BatchSessionRepository batchSessionRepository;

	public boolean update(List<BatchSession> batchSessions) {
		try {
			batchSessionRepository.saveAll(batchSessions);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
