package markattendance.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Batch {

	@Id
	private String batchCode;
	@ToString.Exclude
	@ManyToOne
	@JsonIgnore
	private Employee employee;
	@OneToMany(mappedBy = "batch")
	private List<BatchSession> batchSessions;
	@OneToMany(mappedBy = "batch")
	@JsonIgnore
	private List<Registration> registrations;

}
