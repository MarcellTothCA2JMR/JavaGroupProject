package hu.projekt.hap.application.webdomain;

import hu.projekt.hap.application.validation.HealthInsuranceNumberConstraint;
import hu.projekt.hap.domain.BirthLocation;
import hu.projekt.hap.domain.Role;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

public class EditPatientRequest {

	private int id;
	protected String email;

	@NotEmpty(message = "A jelszó megadása kötelező!")
	protected String password;

	@NotEmpty(message = "A név megadása kötelező!")
	protected String name;

	protected Role role;
	@HealthInsuranceNumberConstraint
	private String healthInsuranceNumber;

	@NotNull(message = "A születési idő megadása kötelező!")
	@PastOrPresent
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate birthday;

	@NotNull(message = "A születési hely megadása kötelező!")
	private BirthLocation birthLocation;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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