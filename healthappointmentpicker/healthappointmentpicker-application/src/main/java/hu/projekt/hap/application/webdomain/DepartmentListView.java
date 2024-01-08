package hu.projekt.hap.application.webdomain;

import hu.projekt.hap.domain.ConsultationCategory;

public class DepartmentListView {

	private final int id;
	private final int floor;
	private final ConsultationCategory category;

	public DepartmentListView(int id, int floor, ConsultationCategory category) {
		super();
		this.id = id;
		this.floor = floor;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public int getFloor() {
		return floor;
	}

	public ConsultationCategory getCategory() {
		return category;
	}
}