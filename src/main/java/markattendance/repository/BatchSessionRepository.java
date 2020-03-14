package markattendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import markattendance.model.BatchSession;

public interface BatchSessionRepository extends JpaRepository<BatchSession, Integer> {
	
}
