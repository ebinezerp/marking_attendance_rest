package markattendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import markattendance.model.SessionLocation;

public interface SessionLocationRepository extends JpaRepository<SessionLocation, Integer>{

}
