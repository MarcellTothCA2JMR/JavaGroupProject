package hu.projekt.hap.application.controller;

import hu.projekt.hap.application.security.SecurityHelper;
import hu.projekt.hap.application.service.AppointmentService;
import hu.projekt.hap.application.service.DepartmentService;
import hu.projekt.hap.application.service.DoctorService;
import hu.projekt.hap.application.service.PatientService;
import hu.projekt.hap.application.webdomain.AddAppointmentRequest;
import hu.projekt.hap.domain.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class AddAppointmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    @GetMapping("add-appointment-{depid}-{docid}")
    public String form(AddAppointmentRequest addAppointmentRequest, Model model, @PathVariable("depid") int depId, @PathVariable("docid") int docId) {

        addAppointmentRequest.setMedicalAttendant(doctorService.getDoctorById(docId));
        addAppointmentRequest.setDepartment(departmentService.getDepartmentById(depId));
        addAppointmentRequest.setPatient(patientService.getPatientByEmail(SecurityHelper.getUsername()));

        List<LocalDateTime> bTs = new ArrayList<>();
        doctorService.getDoctorById(docId).getBookableTimes().forEach(h -> {
            if (LocalDateTime.now().isBefore(h)) {
                bTs.add(h);
            }
        });

        addAppointmentRequest.setDateAndTimesToSelect(bTs);

        List<Attendance> attens = departmentService.getDepartmentById(depId).getAttendances();
        Collections.sort(attens, Comparator.comparing(Attendance::getServiceLevel)
                .thenComparing(Attendance::getName));
        addAppointmentRequest.setAttendancesToSelect(attens);

        return "add-appointment";
    }

    @PostMapping("add-appointment")
    public String addAppointment(Model model, @Valid AddAppointmentRequest addAppointmentRequest, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "add-appointment";
        }

        if (!(appointmentService.checkAppointmentCanBeAdded(addAppointmentRequest.getDepartment(), addAppointmentRequest.getAttendance()))) {
            model.addAttribute("levelForbidden", true);
            return "add-appointment";
        }

        appointmentService.createAppointment(addAppointmentRequest.getPatient(), addAppointmentRequest.getMedicalAttendant(),
                addAppointmentRequest.getDepartment(), addAppointmentRequest.getAttendance(), addAppointmentRequest.getDateAndTime());

        doctorService.deleteBookableTime(addAppointmentRequest.getMedicalAttendant().getBookableTimes().indexOf(addAppointmentRequest.getDateAndTime()), addAppointmentRequest.getMedicalAttendant());

        doctorService.addToPatients(addAppointmentRequest.getMedicalAttendant(), addAppointmentRequest.getPatient());

        return "redirect:departments";
    }
}