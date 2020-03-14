package markattendance.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString.Exclude;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionLocation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private double longitude;
	private double latitude;
	@OneToMany(mappedBy = "sessionLocation")
	@JsonIgnore
	@Exclude
	private List<BatchSession> batchSessions;

}
