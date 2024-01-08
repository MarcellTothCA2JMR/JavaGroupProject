package hu.projekt.hap.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Department {

	@Id
	@GeneratedValue
	private int id;
	
	private int floor;
	
	@Enumerated(EnumType.STRING)
	private ConsultationCategory category;
	
	@OneToMany
	private List<Doctor> doctors;
	
	@OneToMany
	private List<Attendance> attendances;
	
	public Department() {

	}

	public Department(int floor, ConsultationCategory category, List<Doctor> doctors, List<Attendance> attendances) {
		this.floor = floor;
		this.category = category;
		this.doctors = doctors;
		this.attendances = attendances;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public ConsultationCategory getCategory() {
		return category;
	}

	public void setCategory(ConsultationCategory category) {
		this.category = category;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public List<Attendance> getAttendances() {
		return attendances;
	}

	public void setAttendances(List<Attendance> attendances) {
		this.attendances = attendances;
	}
}