package hu.projekt.hap.application.controller;

import hu.projekt.hap.application.service.PatientService;
import hu.projekt.hap.application.webdomain.AddPatientRequest;
import hu.projekt.hap.domain.BirthLocation;
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

@Controller
public class AddPatientController {

	@Autowired
	private PatientService patientService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("register-patient")
	public String form(AddPatientRequest addPatientRequest) {
		
		addPatientRequest.setPassword("");
		addPatientRequest.setPasswordAgain("");

		return "register-patient";
	}
	
	@PostMapping("register-patient")
	public String regPatient(@Valid AddPatientRequest addPatientRequest, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors() || !(addPatientRequest.getPassword().equals(addPatientRequest.getPasswordAgain()))) {
			return "register-patient";
		}
		
		patientService.createPatient(addPatientRequest.getEmail(), passwordEncoder.encode(addPatientRequest.getPassword()), 
				addPatientRequest.getName(), Role.PATIENT, addPatientRequest.getHealthInsuranceNumber(), 
				addPatientRequest.getBirthday(), addPatientRequest.getBirthLocation());
		
		redirectAttributes.addFlashAttribute("message", "A regisztráció sikeres!");

		return "redirect:login";
	}
	
	@ModelAttribute("birthLocations")
	public BirthLocation[] getBirthLocations(){

		return BirthLocation.values();
	}
}