package hu.projekt.hap.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Appointment {

	@Id
	@GeneratedValue
	private int id;
	
	private LocalDateTime dateAndTime;
	
	@ManyToOne
	private Patient patient;
	
	@ManyToOne
	private Department department;
	
	@ManyToOne
	private Doctor medicalAttendant;
	
	@ManyToOne
	private Attendance attendance;

	public Appointment() {
		
	}
	
	public Appointment(LocalDateTime dateAndTime, Patient patient, Department department, Doctor medicalAttendant, Attendance attendance) {
		this.dateAndTime = dateAndTime;
		this.patient = patient;
		this.department = department;
		this.medicalAttendant = medicalAttendant;
		this.attendance = attendance;
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

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Doctor getMedicalAttendant() {
		return medicalAttendant;
	}

	public void setMedicalAttendant(Doctor medicalAttendant) {
		this.medicalAttendant = medicalAttendant;
	}

	public Attendance getAttendance() {
		return attendance;
	}

	public void setAttendance(Attendance attendance) {
		this.attendance = attendance;
	}
}