package hu.projekt.hap.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Entity
public class Patient extends AppUser{

	@Column(unique = true)
	private String healthInsuranceNumber;
	
	private LocalDate birthday;
	
	@Enumerated(EnumType.STRING)
	private BirthLocation birthLocation;

	public Patient() {
		
	}
	
	public Patient(String email, String pw, String name, Role role, String healthInsuranceNumber, LocalDate birthday, BirthLocation birthLocation) {
		this.email = email;
		this.password = pw;
		this.name = name;
		this.role = role;
		this.healthInsuranceNumber = healthInsuranceNumber;
		this.birthday = birthday;
		this.birthLocation = birthLocation;
	}

	public String getHealthInsuranceNumber() {
		return healthInsuranceNumber;
	}

	public void setHealthInsuranceNumber(String healthInsuranceNumber) {
		this.healthInsuranceNumber = healthInsuranceNumber;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public BirthLocation getBirthLocation() {
		return birthLocation;
	}

	public void setBirthLocation(BirthLocation birthLocation) {
		this.birthLocation = birthLocation;
	}
}