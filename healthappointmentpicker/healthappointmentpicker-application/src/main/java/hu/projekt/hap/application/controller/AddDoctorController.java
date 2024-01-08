package hu.projekt.hap.application.controller;

import hu.projekt.hap.application.service.DepartmentService;
import hu.projekt.hap.application.service.DoctorService;
import hu.projekt.hap.application.webdomain.AddDoctorRequest;
import hu.projekt.hap.domain.ConsultationCategory;
import hu.projekt.hap.domain.Doctor;
import hu.projekt.hap.domain.Patient;
import hu.projekt.hap.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AddDoctorController {

	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("register-doctor")
	public String form(AddDoctorRequest addDoctorRequest) {
		
		addDoctorRequest.setPassword("");
		addDoctorRequest.setPasswordAgain("");
		return "register-doctor";
	}
	
	@PostMapping("register-doctor")
	public String regDoctor(@Valid AddDoctorRequest addDoctorRequest , BindingResult bindingResult, RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors() || !(addDoctorRequest.getPassword().equals(addDoctorRequest.getPasswordAgain()))) {
			return "register-doctor";
		}

		List<LocalDateTime> bookable = new ArrayList<>();
		List<Patient> patients = new ArrayList<>();

		Doctor doctor = doctorService.createDoctor(addDoctorRequest.getEmail(), passwordEncoder.encode(addDoctorRequest.getPassword()), 
				addDoctorRequest.getName(), addDoctorRequest.getYearOfGraduation(), bookable, 
				addDoctorRequest.getSpecialization(), patients, Role.DOCTOR);
		
		departmentService.addDoctorToDepartment(doctor);
		redirectAttributes.addFlashAttribute("message", "Az új doktor regisztrációja sikeres!");

		return "redirect:departments";
	}
	
	@ModelAttribute("specializations")
	public ConsultationCategory[] getConsultationCategories(){

		return ConsultationCategory.values();
	}
}
