package hu.projekt.hap.application.webdomain;

import hu.projekt.hap.domain.ConsultationCategory;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AddDoctorRequest {

	@NotEmpty(message = "Az e-mail megadása kötelező!")
	@Email
	private String email;

	@NotEmpty(message = "A jelszó megadása kötelező!")
	private String password;

	@NotEmpty(message = "A jelszó megerősítése kötelező!")
	private String passwordAgain;

	@NotEmpty(message = "A név megadása kötelező!")
	private String name;
	
	@Min(1950)
	@Max(2022)
	private int yearOfGraduation;

	@NotNull(message = "A szakosztály megadása kötelező!")
	private ConsultationCategory specialization;

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

	public String getPasswordAgain() {
		return passwordAgain;
	}

	public void setPasswordAgain(String passwordAgain) {
		this.passwordAgain = passwordAgain;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearOfGraduation() {
		return yearOfGraduation;
	}

	public void setYearOfGraduation(int yearOfGraduation) {
		this.yearOfGraduation = yearOfGraduation;
	}

	public ConsultationCategory getSpecialization() {
		return specialization;
	}

	public void setSpecialization(ConsultationCategory specialization) {
		this.specialization = specialization;
	}
}