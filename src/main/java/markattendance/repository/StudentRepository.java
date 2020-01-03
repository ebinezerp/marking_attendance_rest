package markattendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import markattendance.model.Student;

public interface StudentRepository extends JpaRepository<Student, String> {
	@Query("select s from Student s where student_id=:student_id and password=:password")
	public Student login(@Param("student_id") String student_id, @Param("password") String password);
}
