package markattendance.service;

import java.util.List;

import org.springframework.stereotype.Service;

import markattendance.repository.BatchSessionRepository;

@Service
public class BatchSessionService {

	private BatchSessionRepository batchSessionRepository;

	public boolean activateAttendance(List<String> sessionIds, String code) {
		try {
			batchSessionRepository.activateSession(sessionIds, code);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
