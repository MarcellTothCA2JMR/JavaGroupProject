package hu.projekt.hap.application.webdomain;

public class AttendanceListView {

	private final int id;
	private final String name;
	private final int serviceLevel;
	
	public AttendanceListView(int id, String name, int serviceLevel) {
		super();
		this.id = id;
		this.name = name;
		this.serviceLevel = serviceLevel;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getServiceLevel() {
		return serviceLevel;
	}
}