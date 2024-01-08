package hu.projekt.hap.application.webdomain;

import hu.projekt.hap.domain.Doctor;
import hu.projekt.hap.domain.Medicine;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class AddPrescriptionRequest {

	@NotEmpty(message = "Indoklás megadása kötelező!")
	private String justification;

	@NotNull(message = "Az orvos megadása kötelező!")
	private Doctor doctor;

	@NotNull(message = "A gyógyszer megadása kötelező!")
	private Medicine medicine;

	private List<Doctor> doctorsToSelect;
	private List<Medicine> medicinesToSelect;

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public List<Doctor> getDoctorsToSelect() {
		return doctorsToSelect;
	}

	public void setDoctorsToSelect(List<Doctor> doctorsToSelect) {
		this.doctorsToSelect = doctorsToSelect;
	}

	public List<Medicine> getMedicinesToSelect() {
		return medicinesToSelect;
	}

	public void setMedicinesToSelect(List<Medicine> medicinesToSelect) {
		this.medicinesToSelect = medicinesToSelect;
	}
}