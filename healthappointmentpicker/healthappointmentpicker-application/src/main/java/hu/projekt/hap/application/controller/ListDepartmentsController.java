package hu.projekt.hap.application.controller;

import hu.projekt.hap.application.service.DepartmentService;
import hu.projekt.hap.application.webdomain.DepartmentListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ListDepartmentsController {

	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("departments")
	public String listDepartments(Model model) {
		
		List<DepartmentListView> departmentListViews = new ArrayList<>();

		departmentService.getAllDepartments().forEach(h -> departmentListViews.add(
				new DepartmentListView(h.getId(), h.getFloor(), h.getCategory())));
		
		departmentListViews.sort((o1, o2) -> o1.getCategory().name().compareTo(o2.getCategory().name()));
		model.addAttribute("departments", departmentListViews);
		
		return "departments";
	}
}