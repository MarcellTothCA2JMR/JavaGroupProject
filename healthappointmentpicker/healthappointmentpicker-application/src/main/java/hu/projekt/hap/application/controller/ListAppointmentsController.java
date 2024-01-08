package hu.projekt.hap.application.controller;

import hu.projekt.hap.application.security.SecurityHelper;
import hu.projekt.hap.application.service.AppointmentService;
import hu.projekt.hap.application.service.DoctorService;
import hu.projekt.hap.application.webdomain.AppointmentListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ListAppointmentsController {

	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private DoctorService doctorService;
	
	@GetMapping("appointments")
	public String listAppointments(Model model) {
		
		List<AppointmentListView> actualAppointmentListViews = new ArrayList<>();
		List<AppointmentListView> pastAppointmentListViews = new ArrayList<>();
		 
		appointmentService.getAllAppointmentsByEmail(SecurityHelper.getUsername()).forEach(h -> {
			if(h.getDateAndTime().isBefore(LocalDateTime.now())) {
				pastAppointmentListViews.add(new AppointmentListView(h.getId(), h.getDateAndTime(), h.getDepartment(),
						h.getMedicalAttendant(), h.getAttendance(), h.getPatient()));
			} else {
				actualAppointmentListViews.add(new AppointmentListView(h.getId(), h.getDateAndTime(), h.getDepartment(),
						h.getMedicalAttendant(), h.getAttendance(), h.getPatient()));
			}
		});
		
		actualAppointmentListViews.sort((o1, o2) -> o1.getDateAndTime().compareTo(o2.getDateAndTime()));
		pastAppointmentListViews.sort((o1, o2) -> o1.getDateAndTime().compareTo(o2.getDateAndTime()));

		model.addAttribute("actualAppointments", actualAppointmentListViews);
		model.addAttribute("pastAppointments", pastAppointmentListViews);
		
		return "appointments";
	}
	
	@GetMapping("remove-appointment-{appid}")
	public String removeAppointment(@PathVariable("appid") int appId) {
		
		doctorService.putBackBookableTime(appId);
		
		appointmentService.deleteAppointment(appId);
		
		return "redirect:appointments";
	}
}