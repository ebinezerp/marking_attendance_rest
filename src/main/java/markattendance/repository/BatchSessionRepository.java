package markattendance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import markattendance.model.BatchSession;

public interface BatchSessionRepository extends JpaRepository<BatchSession, Integer> {

	@Query("update BatchSession set triggerd = true,attendance_code=:attendanceCode where session_id in :sessionIds")
	public void activateSession(@Param("sessionIds") List<String> sessionIds,
			@Param("attendanceCode") String attendanceCode);

}
