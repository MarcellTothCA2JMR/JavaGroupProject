package hu.projekt.hap.application.webdomain;

import hu.projekt.hap.domain.Medicine;
import hu.projekt.hap.domain.Patient;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class DoctorPrescribeRequest {

	@NotEmpty(message = "Indoklás megadása kötelező!")
	private String justification;

	@NotNull(message = "A gyógyszer megadása kötelező!")
	private Medicine medicine;

	@NotNull(message = "A páciens megadása kötelező!")
	private Patient patient;

	private List<Medicine> medicinesToSelect;
	private List<Patient> patientsToSelect;

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<Medicine> getMedicinesToSelect() {
		return medicinesToSelect;
	}

	public void setMedicinesToSelect(List<Medicine> medicinesToSelect) {
		this.medicinesToSelect = medicinesToSelect;
	}

	public List<Patient> getPatientsToSelect() {
		return patientsToSelect;
	}

	public void setPatientsToSelect(List<Patient> patientsToSelect) {
		this.patientsToSelect = patientsToSelect;
	}
}