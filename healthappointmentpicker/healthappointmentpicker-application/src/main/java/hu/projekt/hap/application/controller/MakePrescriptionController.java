package hu.projekt.hap.application.controller;

import hu.projekt.hap.application.security.SecurityHelper;
import hu.projekt.hap.application.service.AppointmentService;
import hu.projekt.hap.application.service.DepartmentService;
import hu.projekt.hap.application.service.DoctorService;
import hu.projekt.hap.application.service.MedicineService;
import hu.projekt.hap.application.service.PrescriptionService;
import hu.projekt.hap.application.webdomain.DoctorPrescribeRequest;
import hu.projekt.hap.domain.Department;
import hu.projekt.hap.domain.Doctor;
import hu.projekt.hap.domain.Medicine;
import hu.projekt.hap.domain.Patient;
import hu.projekt.hap.domain.PrescriptionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class MakePrescriptionController {

	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private PrescriptionService prescriptionService;
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private MedicineService medicineService;
	
	@GetMapping("make-prescription")
	public String form(DoctorPrescribeRequest doctorPrescribeRequest) {

		Doctor doctor = doctorService.getDoctorByEmail(SecurityHelper.getUsername());
		Department department = departmentService.getDepartmentByCategory(doctor.getSpecialization());

		List<Patient> pats = appointmentService.checkWhoHadAppointmentToday(doctor);
		pats.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
		doctorPrescribeRequest.setPatientsToSelect(pats);

		List<Medicine> meds = medicineService.getAllMedicinesByDepartmentId(department.getId());
		meds.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
		doctorPrescribeRequest.setMedicinesToSelect(meds);
		
		return "make-prescription";
	}
	
	@PostMapping("make-prescription")
	public String makePrescricption(@Valid DoctorPrescribeRequest doctorPrescribeRequest, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "make-prescription";
		}

		prescriptionService.createPrescription(doctorService.getDoctorByEmail(SecurityHelper.getUsername()),
				doctorPrescribeRequest.getPatient(), doctorPrescribeRequest.getMedicine(), LocalDateTime.now().withSecond(0).withNano(0), 
				doctorPrescribeRequest.getJustification(), PrescriptionStatus.APPROVED);
		
		return "redirect:prescriptions";
	}
}