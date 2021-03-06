package markattendance.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Registration {

	@Id
	private String registrationNo;
	@OneToOne
	private Student student;
	@ManyToOne
	private Course course;
	@ManyToOne
	private Batch batch;

}
