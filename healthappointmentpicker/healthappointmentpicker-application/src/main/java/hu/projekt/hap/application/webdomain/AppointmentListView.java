package hu.projekt.hap.application.webdomain;

import hu.projekt.hap.domain.Attendance;
import hu.projekt.hap.domain.Department;
import hu.projekt.hap.domain.Doctor;
import hu.projekt.hap.domain.Patient;

import java.time.LocalDateTime;

public class AppointmentListView {

	private final int id;
	private final LocalDateTime dateAndTime;
	private final Department department;
	private final Doctor doctor;
	private final Attendance attendance;
	private final Patient patient;

	public AppointmentListView(int id, LocalDateTime dateAndTime, Department department, Doctor doctor, Attendance attendance, Patient patient) {
		super();
		this.id = id;
		this.dateAndTime = dateAndTime;
		this.department = department;
		this.doctor = doctor;
		this.attendance = attendance;
		this.patient = patient;
	}

	public int getId() {
		return id;
	}

	public LocalDateTime getDateAndTime() {
		return dateAndTime;
	}

	public Department getDepartment() {
		return department;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public Attendance getAttendance() {
		return attendance;
	}

	public Patient getPatient() {
		return patient;
	}
}