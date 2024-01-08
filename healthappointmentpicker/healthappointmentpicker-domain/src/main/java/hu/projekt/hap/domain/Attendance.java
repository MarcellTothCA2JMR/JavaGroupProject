package hu.projekt.hap.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Attendance {

	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	private int serviceLevel;

	public Attendance() {
		
	}
	
	public Attendance(String name, int serviceLevel) {
		this.name = name;
		this.serviceLevel = serviceLevel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getServiceLevel() {
		return serviceLevel;
	}

	public void setServiceLevel(int serviceLevel) {
		this.serviceLevel = serviceLevel;
	}
}