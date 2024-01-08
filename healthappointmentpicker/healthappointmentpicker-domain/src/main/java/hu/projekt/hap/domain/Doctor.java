package hu.projekt.hap.domain;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Doctor extends AppUser{
	
	private int yearOfGraduation;
	
	@ElementCollection
	private List<LocalDateTime> bookableTimes;
	
	@Enumerated(EnumType.STRING)
	private ConsultationCategory specialization;
	
	@ManyToMany
	private List<Patient> patients;

	public Doctor() {
		
	}
	
	public Doctor(String email, String pw, String name, int yog, List<LocalDateTime> bookableTimes, ConsultationCategory specialization, List<Patient> patients, Role role) {
		this.email = email;
		this.password = pw;
		this.name = name;
		this.role = role;
		this.yearOfGraduation = yog;
		this.bookableTimes = bookableTimes;
		this.specialization = specialization;
		this.patients = patients;
	}

	public int getYearOfGraduation() {
		return yearOfGraduation;
	}

	public void setYearOfGraduation(int yearOfGraduation) {
		this.yearOfGraduation = yearOfGraduation;
	}

	public List<LocalDateTime> getBookableTimes() {
		return bookableTimes;
	}

	public void setBookableTimes(List<LocalDateTime> bookableTimes) {
		this.bookableTimes = bookableTimes;
	}

	public ConsultationCategory getSpecialization() {
		return specialization;
	}

	public void setSpecialization(ConsultationCategory specialization) {
		this.specialization = specialization;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
}