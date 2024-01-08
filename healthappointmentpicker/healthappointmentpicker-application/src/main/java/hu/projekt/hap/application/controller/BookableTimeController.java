package hu.projekt.hap.application.controller;

import hu.projekt.hap.application.security.SecurityHelper;
import hu.projekt.hap.application.service.DoctorService;
import hu.projekt.hap.application.webdomain.AddBookableTimeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class BookableTimeController {
	
	@Autowired
	private DoctorService doctorService;

	@GetMapping("bookable-times")
	public String form(AddBookableTimeRequest addBookableTimeRequest, Model model) {
		
		model.addAttribute("bookableTimes", doctorService.getDoctorByEmail(SecurityHelper.getUsername()).getBookableTimes());
		
		return "doctor-bookable-times";
	}

	@PostMapping("add-bookable-time")
	public String addBT(Model model, @Valid AddBookableTimeRequest addBookableTimeRequest, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("bookableTimes", doctorService.getDoctorByEmail(SecurityHelper.getUsername()).getBookableTimes());
			return "doctor-bookable-times";
		}
		
		boolean succesful = doctorService.createNewBookableTime(addBookableTimeRequest.getDateAndTime());
		
		if(!succesful) {
			redirectAttributes.addFlashAttribute("message", "A felvitel nem sikeres! A megadott időpont már szerepel a szabad vagy a lefoglalt időpontok között!");
		}
		
		return "redirect:bookable-times";
	}
	
	@GetMapping("bookable-times-remove-{bt}")
	public String removeBT(@PathVariable("bt") int bT) {
		
		doctorService.deleteBookableTime(bT, doctorService.getDoctorByEmail(SecurityHelper.getUsername()));
		
		return "redirect:bookable-times";
	}
}
