package markattendance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import markattendance.model.SessionLocation;
import markattendance.repository.SessionLocationRepository;

@Service
public class SessionLocationService {
	
	@Autowired
	private SessionLocationRepository sessionLocationRepository;
	
	public boolean save(SessionLocation sessionLocation) {
		try {
			sessionLocationRepository.save(sessionLocation);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
