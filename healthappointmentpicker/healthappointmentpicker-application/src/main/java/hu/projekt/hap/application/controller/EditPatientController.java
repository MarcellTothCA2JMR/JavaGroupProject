package hu.projekt.hap.application.controller;

import hu.projekt.hap.application.security.SecurityHelper;
import hu.projekt.hap.application.service.PatientService;
import hu.projekt.hap.application.webdomain.EditPatientRequest;
import hu.projekt.hap.domain.BirthLocation;
import hu.projekt.hap.domain.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class EditPatientController {

	@Autowired
	private PatientService patientService;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("edit-patient")
	public String form(EditPatientRequest editPatientRequest) {

		Patient actPatient = patientService.getPatientByEmail(SecurityHelper.getUsername());

		editPatientRequest.setId(actPatient.getId());
		editPatientRequest.setEmail(actPatient.getEmail());
		editPatientRequest.setPassword("");
		editPatientRequest.setName(actPatient.getName());
		editPatientRequest.setRole(actPatient.getRole());
		editPatientRequest.setHealthInsuranceNumber(actPatient.getHealthInsuranceNumber());
		editPatientRequest.setBirthday(actPatient.getBirthday());
		editPatientRequest.setBirthLocation(actPatient.getBirthLocation());
		
		return "edit-patient";
	}
	
	@PostMapping("edit-patient")
	public String editActualPatient(@Valid EditPatientRequest editPatientRequest, BindingResult bindingResult) {

		if (bindingResult.hasErrors() || !(passwordEncoder.matches(editPatientRequest.getPassword(), SecurityHelper.getPassword()))) {
			return "edit-patient";
		}

		patientService.updatePatient(editPatientRequest.getId(), editPatientRequest.getEmail(), passwordEncoder.encode(editPatientRequest.getPassword()),
				editPatientRequest.getName(), editPatientRequest.getRole(), editPatientRequest.getHealthInsuranceNumber(), 
				editPatientRequest.getBirthday(), editPatientRequest.getBirthLocation());
		
		return "redirect:departments";
	}
	
	@ModelAttribute("birthLocations")
	public BirthLocation[] getBirthLocations(){

		return BirthLocation.values();
	}
}