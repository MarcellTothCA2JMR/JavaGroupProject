package hu.projekt.hap.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Medicine {

	@Id
	@GeneratedValue
	private int id;
	
	private String identifierCode;
	private String name;
	private String description;
	
	@ManyToOne
	private Department department;

	public Medicine() {

	}

	public Medicine(String identifierCode, String name, String description, Department department) {
		this.identifierCode = identifierCode;
		this.name = name;
		this.description = description;
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdentifierCode() {
		return identifierCode;
	}

	public void setIdentifierCode(String identifierCode) {
		this.identifierCode = identifierCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}