package hu.projekt.hap.application.controller;

import hu.projekt.hap.application.security.SecurityHelper;
import hu.projekt.hap.application.service.DepartmentService;
import hu.projekt.hap.application.service.MedicineService;
import hu.projekt.hap.application.service.PatientService;
import hu.projekt.hap.application.service.PrescriptionService;
import hu.projekt.hap.application.webdomain.AddPrescriptionRequest;
import hu.projekt.hap.domain.Doctor;
import hu.projekt.hap.domain.Medicine;
import hu.projekt.hap.domain.PrescriptionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class RequestPrescriptionController {

	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private MedicineService medicineService;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private PrescriptionService prescriptionService;

	@GetMapping("request-prescription-{depid}")
	public String reqPrescricption(AddPrescriptionRequest addPrescriptionRequest, @PathVariable("depid") int depid) {
		
		List<Doctor> docs = departmentService.getDepartmentById(depid).getDoctors();
		docs.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
		addPrescriptionRequest.setDoctorsToSelect(docs);
		
		List<Medicine> meds = medicineService.getAllMedicinesByDepartmentId(depid);
		meds.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
		addPrescriptionRequest.setMedicinesToSelect(meds);
		
		return "prescription-request";
	}

	@PostMapping("request-prescription")
	public String addPrescricption(@Valid AddPrescriptionRequest addPrescriptionRequest, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "prescription-request";
		}
		
		prescriptionService.createPrescription(addPrescriptionRequest.getDoctor(), patientService.getPatientByEmail(SecurityHelper.getUsername()),
				addPrescriptionRequest.getMedicine(), LocalDateTime.now().withSecond(0).withNano(0), addPrescriptionRequest.getJustification(), 
				PrescriptionStatus.REQUESTED);
		
		return "redirect:departments";
	}
}