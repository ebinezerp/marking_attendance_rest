package markattendance.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@Id
	private String empCode;
	@Column(nullable = false)
	private String centerCode;
	@Column(nullable = false)
	private String password;
	
	private String role;
	@OneToMany(mappedBy = "employee")
	private List<Batch> batches;

}
