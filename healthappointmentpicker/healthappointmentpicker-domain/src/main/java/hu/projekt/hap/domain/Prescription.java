package hu.projekt.hap.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Prescription {

	@Id
	@GeneratedValue
	private int id;
	
	private LocalDateTime dateAndTime;
	private String justification;
	
	@Enumerated(EnumType.STRING)
	private PrescriptionStatus status;
	
	@ManyToOne
	private Medicine medicine;
	
	@ManyToOne
	private Doctor doctor;
	
	@ManyToOne
	private Patient patient;

	public Prescription() {
		
	}
	
	public Prescription(LocalDateTime dateAndTime, String justification, PrescriptionStatus status, Medicine medicine, Doctor doctor, Patient patient) {
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

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(LocalDateTime dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public PrescriptionStatus getStatus() {
		return status;
	}

	public void setStatus(PrescriptionStatus status) {
		this.status = status;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}