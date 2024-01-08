package hu.projekt.hap.application.controller;

import hu.projekt.hap.application.security.SecurityHelper;
import hu.projekt.hap.application.service.PrescriptionService;
import hu.projekt.hap.application.webdomain.PrescriptionListView;
import hu.projekt.hap.domain.PrescriptionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ListPrescriptionsController {

	@Autowired
	private PrescriptionService prescriptionService;
	
	@GetMapping("prescriptions")
	public String listPrescriptions(Model model) {
		
		List<PrescriptionListView> requestedPrescriptionListViews = new ArrayList<>();
		List<PrescriptionListView> evaluatedPrescriptionListViews = new ArrayList<>();
		
		prescriptionService.getAllPrescriptionsByEmail(SecurityHelper.getUsername()).forEach(h -> {
			if(h.getStatus() == PrescriptionStatus.REQUESTED) {
				requestedPrescriptionListViews.add(new PrescriptionListView(h.getId(), h.getDateAndTime(),
						h.getJustification(), h.getStatus(), h.getMedicine(), h.getDoctor(), h.getPatient()));
			} else {
				evaluatedPrescriptionListViews.add(new PrescriptionListView(h.getId(), h.getDateAndTime(),
						h.getJustification(), h.getStatus(), h.getMedicine(), h.getDoctor(), h.getPatient()));
			}
		});
		
		requestedPrescriptionListViews.sort((o1, o2) -> o1.getDateAndTime().compareTo(o2.getDateAndTime()));
		evaluatedPrescriptionListViews.sort((o1, o2) -> o1.getDateAndTime().compareTo(o2.getDateAndTime()));

		model.addAttribute("reqPrescriptions", requestedPrescriptionListViews);
		model.addAttribute("evaPrescriptions", evaluatedPrescriptionListViews);
		
		return "prescriptions";
	}
	
	@GetMapping("prescriptions-{prescriptionId}-{modif}")
	public String modifyPrescriptionStatus(@PathVariable("prescriptionId") int prescriptionId, @PathVariable("modif") int modif) {
		
		prescriptionService.modifyPrescriptionStatus(prescriptionId, modif);
		
		return "redirect:prescriptions";
	}
}