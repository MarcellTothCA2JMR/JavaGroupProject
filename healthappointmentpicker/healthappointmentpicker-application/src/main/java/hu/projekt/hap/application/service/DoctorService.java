package hu.projekt.hap.application.service;

import hu.projekt.hap.application.security.SecurityHelper;
import hu.projekt.hap.domain.Appointment;
import hu.projekt.hap.domain.ConsultationCategory;
import hu.projekt.hap.domain.Doctor;
import hu.projekt.hap.domain.Patient;
import hu.projekt.hap.domain.Role;
import hu.projekt.hap.domain.exception.HealthAppointmentPickerConflictException;
import hu.projekt.hap.domain.exception.HealthAppointmentPickerNotFoundException;
import hu.projekt.hap.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

	@Autowired
    private DoctorRepository doctorRepository;
	
	@Autowired
    private AppointmentService appointmentService;
	
	public Doctor createDoctor(String email, String pwd, String name, int year, List<LocalDateTime> bookableTimes, ConsultationCategory specialization, List<Patient> patients, Role role) {

		Doctor doctor = new Doctor(email, pwd, name, year, bookableTimes, specialization,  patients, role);
	
		try {
			return doctorRepository.save(doctor);
		} catch (DataIntegrityViolationException e) {
			throw new HealthAppointmentPickerConflictException("Érvénytelen e-mail, már szerepel az adatbázisban!");
		}
	}
	
	public boolean createNewBookableTime(LocalDateTime bT) {
		
		Doctor doctor = getDoctorByEmail(SecurityHelper.getUsername());

		boolean appSameTime = false;

		for (Appointment app : appointmentService.getAllAppointmentsByDoctorId(doctor.getId())) {
			if(app.getDateAndTime().equals(bT)) {
				appSameTime = true;
				break;
			}
		}
		
		if(!appSameTime && !(doctor.getBookableTimes().contains(bT))) {
			List<LocalDateTime> bTs = doctor.getBookableTimes();
			bTs.add(bT);
			Collections.sort(bTs);
			doctor.setBookableTimes(bTs);

			doctorRepository.save(doctor);

			return true;
		}
		
		return false;
	}
	
	public void putBackBookableTime(int appointmentId) {
		
		Appointment appointment = appointmentService.getAppointmentById(appointmentId);

		List<LocalDateTime> bTs = appointment.getMedicalAttendant().getBookableTimes();
		bTs.add(appointment.getDateAndTime());
		Collections.sort(bTs);
		appointment.getMedicalAttendant().setBookableTimes(bTs);

		doctorRepository.save(appointment.getMedicalAttendant());
	}
	
	public void deleteBookableTime(int bT, Doctor doctor) {
		
		List<LocalDateTime> bTs = doctor.getBookableTimes();
		bTs.remove(bT);
		doctor.setBookableTimes(bTs);

		doctorRepository.save(doctor);
	}

	public void updateDoctor(int id, String email, String pw, String name, int yog, List<LocalDateTime> bookableTimes, ConsultationCategory specialization, List<Patient> patients, Role role) {

		Doctor doctor = getDoctorById(id);

		doctor.setEmail(email);
		doctor.setPassword(pw);
		doctor.setName(name);
		doctor.setYearOfGraduation(yog);
		doctor.setBookableTimes(bookableTimes);
		doctor.setSpecialization(specialization);
		doctor.setPatients(patients);
		doctor.setRole(role);
		
		doctorRepository.save(doctor);
	}
	
	public void addToPatients(Doctor doctor, Patient patient) {

		if(!(doctor.getPatients().contains(patient))) {
			List<Patient> ps = doctor.getPatients();
			ps.add(patient);
			doctor.setPatients(ps);

			doctorRepository.save(doctor);
		}
	}

	public Doctor getDoctorByEmail(String email) {
	
		return doctorRepository.findByEmail(email);
	}
	
	public Doctor getDoctorById(int id) {

        Optional<Doctor> optUser = doctorRepository.findById(id);

        if(optUser.isPresent()) {
            return optUser.get();
        } else {
			throw new HealthAppointmentPickerNotFoundException("Az orvos: " + id + " id-val nem található.");
		}
    }
}