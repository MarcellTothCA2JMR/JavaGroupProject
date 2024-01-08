package hu.projekt.hap.application.controller;

import hu.projekt.hap.application.service.DepartmentService;
import hu.projekt.hap.application.webdomain.DoctorListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ListDoctorsController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("doctors-{depid}")
	public String listDoctors(Model model, @PathVariable("depid") int depid) {
		
		List<DoctorListView> doctorListViews = new ArrayList<>();
		
		departmentService.getDepartmentById(depid).getDoctors().forEach(h -> doctorListViews.add(
				new DoctorListView(h.getId(), h.getName(), h.getEmail(), h.getYearOfGraduation())));
		
		doctorListViews.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));

		model.addAttribute("doctors", doctorListViews);
		model.addAttribute("departmentid", depid);
		
		return "doctors";
	}
}