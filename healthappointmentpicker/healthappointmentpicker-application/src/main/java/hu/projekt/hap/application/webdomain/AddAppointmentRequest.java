package hu.projekt.hap.application.webdomain;

import hu.projekt.hap.domain.Attendance;
import hu.projekt.hap.domain.Department;
import hu.projekt.hap.domain.Doctor;
import hu.projekt.hap.domain.Patient;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

public class AddAppointmentRequest {

	private Patient patient;
	private Department department;
	private Doctor medicalAttendant;

	@NotNull(message = "A szolgáltatás megadása kötelező!")
	private Attendance attendance;

	@NotNull(message = "A dátum és idő megadása kötelező!")
	private LocalDateTime dateAndTime;

	private List<Attendance> attendancesToSelect;
	private List<LocalDateTime> dateAndTimesToSelect;
	
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

	public LocalDateTime getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(LocalDateTime dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public List<Attendance> getAttendancesToSelect() {
		return attendancesToSelect;
	}

	public void setAttendancesToSelect(List<Attendance> attendancesToSelect) {
		this.attendancesToSelect = attendancesToSelect;
	}

	public List<LocalDateTime> getDateAndTimesToSelect() {
		return dateAndTimesToSelect;
	}

	public void setDateAndTimesToSelect(List<LocalDateTime> dateAndTimesToSelect) {
		this.dateAndTimesToSelect = dateAndTimesToSelect;
	}
}