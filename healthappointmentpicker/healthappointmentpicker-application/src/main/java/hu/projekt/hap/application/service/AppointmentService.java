package hu.projekt.hap.application.service;

import hu.projekt.hap.application.security.SecurityHelper;
import hu.projekt.hap.domain.Appointment;
import hu.projekt.hap.domain.Attendance;
import hu.projekt.hap.domain.Department;
import hu.projekt.hap.domain.Doctor;
import hu.projekt.hap.domain.Patient;
import hu.projekt.hap.domain.exception.HealthAppointmentPickerNotFoundException;
import hu.projekt.hap.domain.exception.HealthAppointmentPickerPreconditionException;
import hu.projekt.hap.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment createAppointment(Patient patient, Doctor doctor, Department dep, Attendance attendance, LocalDateTime time) {

        Appointment appointment = new Appointment(time, patient, dep, doctor, attendance);

        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointmentsByDoctorId(int id) {

        return appointmentRepository.findAllByMedicalAttendantId(id);
    }
    
    public List<Appointment> getAllAppointmentsByPatientEmail(String email) {

        return appointmentRepository.findAllByPatientEmail(email);
    }
    
    public List<Appointment> getAllAppointmentsByEmail(String email) {
    	
    	if(SecurityHelper.isDoctor()) {
    		return appointmentRepository.findAllByMedicalAttendantEmail(email);
    	} else if(SecurityHelper.isPatient()){
    		return appointmentRepository.findAllByPatientEmail(email);
    	} else {
    		return appointmentRepository.findAll();
    	}
    }

    public boolean checkAppointmentCanBeAdded(Department dep, Attendance att) {
    	
    	if(att.getServiceLevel() == 1) {
    		return true;
    	}
    	
    	for (Appointment app : getAllAppointmentsByPatientEmail(SecurityHelper.getUsername())) 
        {
    		if(app.getDepartment().equals(dep) && app.getAttendance().getServiceLevel()  == (att.getServiceLevel() - 1)) {
                if(app.getDateAndTime().isBefore(LocalDateTime.now()) &&
                		app.getDateAndTime().isAfter(LocalDateTime.now().minusMonths(2))) {
                	return true;
                }
            }
        }

    	return false;
    }
    
    public List<Patient> checkWhoHadAppointmentToday(Doctor doctor){
    	
    	List<Patient> whoHad = new ArrayList<>();

        for (Appointment app : getAllAppointmentsByDoctorId(doctor.getId())) {
    		if(app.getDateAndTime().isBefore(LocalDateTime.now()) && LocalDateTime.now().isBefore(app.getDateAndTime().plusDays(1))) {
    			whoHad.add(app.getPatient());
    		}
    	}
    	
    	return whoHad;
    }

    public Appointment getAppointmentById(int id) {

        Optional<Appointment> optAppointment = appointmentRepository.findById(id);

        if(optAppointment.isPresent()) {
            return optAppointment.get();
        } else {
            throw new HealthAppointmentPickerNotFoundException("Az időpont: " + id + " id-val nem található.");
        }
    }

    public void deleteAppointment(int id) {

        Optional<Appointment> optAppointment = appointmentRepository.findById(id);

        if(optAppointment.isPresent()) {
            appointmentRepository.deleteById(optAppointment.get().getId());
        } else {
            throw new HealthAppointmentPickerPreconditionException("Az időpont: " + id + " id-val nem törölhető.");
        }
    }
}