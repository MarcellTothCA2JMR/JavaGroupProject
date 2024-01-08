package hu.projekt.hap.domain;

import javax.persistence.Entity;

@Entity
public class Admin extends AppUser{
	
	private String phoneNumber;

	public Admin() {
		
	}
	
	public Admin(String email, String pw, String name, Role role, String phoneNumber) {
		super();
		this.email = email;
		this.password = pw;
		this.name = name;
		this.role = role;
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}