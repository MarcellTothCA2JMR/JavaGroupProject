package hu.projekt.hap.application.service;

import hu.projekt.hap.domain.BirthLocation;
import hu.projekt.hap.domain.Patient;
import hu.projekt.hap.domain.Role;
import hu.projekt.hap.domain.exception.HealthAppointmentPickerConflictException;
import hu.projekt.hap.domain.exception.HealthAppointmentPickerNotFoundException;
import hu.projekt.hap.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PatientService {

	@Autowired
    private PatientRepository patientRepository;
	
	public Patient createPatient(String email, String pwd, String name, Role role, String healthId, LocalDate birthday, BirthLocation birthLocation) {

		Patient patient = new Patient(email, pwd, name, role, healthId, birthday, birthLocation);
		
		try {
			return patientRepository.save(patient);
		} catch (DataIntegrityViolationException e) {
			throw new HealthAppointmentPickerConflictException("Érvénytelen e-mail vagy TAJ-szám, már szerepel az adatbázisban!");
		}
	}

	public Patient getPatientByEmail(String email) {
		
		return patientRepository.findByEmail(email);
    }

	public Patient getPatientById(int id) {

        Optional<Patient> optUser = patientRepository.findById(id);

        if(optUser.isPresent()) {
            return optUser.get();
        } else {
			throw new HealthAppointmentPickerNotFoundException("A beteg: " + id + " id-val nem található.");
		}
    }
	
	public void updatePatient(int id, String email, String pwd, String name, Role role, String hin, LocalDate birthday, BirthLocation birthLoc) {

		Patient patient = getPatientById(id);
		
		patient.setEmail(email);
		patient.setPassword(pwd);
		patient.setName(name);
		patient.setRole(role);
		patient.setHealthInsuranceNumber(hin);
		patient.setBirthday(birthday);
		patient.setBirthLocation(birthLoc);
		
		patientRepository.save(patient);
	}
}