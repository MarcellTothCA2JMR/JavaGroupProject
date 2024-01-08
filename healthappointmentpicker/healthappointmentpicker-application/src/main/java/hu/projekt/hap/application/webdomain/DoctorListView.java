package hu.projekt.hap.application.webdomain;

public class DoctorListView {

	private final int id;
	private final String name;
	private final String email;
	private final int yearOfGraduation;
	
	public DoctorListView(int id, String name, String email, int yearOfGraduation) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.yearOfGraduation = yearOfGraduation;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public int getYearOfGraduation() {
		return yearOfGraduation;
	}
}
