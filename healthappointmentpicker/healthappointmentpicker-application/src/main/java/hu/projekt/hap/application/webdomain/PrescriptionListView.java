package hu.projekt.hap.application.webdomain;

import hu.projekt.hap.domain.Doctor;
import hu.projekt.hap.domain.Medicine;
import hu.projekt.hap.domain.Patient;
import hu.projekt.hap.domain.PrescriptionStatus;

import java.time.LocalDateTime;

public class PrescriptionListView {

	private final int id;
	private final LocalDateTime dateAndTime;
	private final String justification;
	private final PrescriptionStatus status;
	private final Medicine medicine;
	private final Doctor doctor;
	private final Patient patient;

	public PrescriptionListView(int id, LocalDateTime dateAndTime, String justification, PrescriptionStatus status, Medicine medicine, Doctor doctor, Patient patient) {
		super();
		this.id = id;
		this.dateAndTime = dateAndTime;
		this.justification = justification;
		this.status = status;
		this.medicine = medicine;
		this.doctor = doctor;
		this.patient = patient;
	}

	public int getId() {
		return id;
	}

	public LocalDateTime getDateAndTime() {
		return dateAndTime;
	}

	public String getJustification() {
		return justification;
	}

	public PrescriptionStatus getStatus() {
		return status;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public Patient getPatient() {
		return patient;
	}
}