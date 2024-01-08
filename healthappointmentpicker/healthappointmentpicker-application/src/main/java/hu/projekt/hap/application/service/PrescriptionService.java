package hu.projekt.hap.application.service;

import hu.projekt.hap.application.security.SecurityHelper;
import hu.projekt.hap.domain.Doctor;
import hu.projekt.hap.domain.Medicine;
import hu.projekt.hap.domain.Patient;
import hu.projekt.hap.domain.Prescription;
import hu.projekt.hap.domain.PrescriptionStatus;
import hu.projekt.hap.domain.exception.HealthAppointmentPickerNotFoundException;
import hu.projekt.hap.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    public Prescription createPrescription(Doctor doctor, Patient patient, Medicine med, LocalDateTime time, String just, PrescriptionStatus status) {

        Prescription prescription = new Prescription(time, just, status, med, doctor, patient);

        return prescriptionRepository.save(prescription);
    }
    
    public void modifyPrescriptionStatus(int id, int modif) {

		Prescription prescription = getPrescriptionById(id);
		
		if(modif == 0) {
			prescription.setStatus(PrescriptionStatus.APPROVED);
		} else {
			prescription.setStatus(PrescriptionStatus.DENIED);
		}

		prescription.setDateAndTime(LocalDateTime.now().withSecond(0).withNano(0));
		
		prescriptionRepository.save(prescription);
	}
    
    public List<Prescription> getAllPrescriptionsByEmail(String email) {
    	
    	if(SecurityHelper.isDoctor()) {
    		return prescriptionRepository.findAllByDoctorEmail(email);
    	} else if(SecurityHelper.isPatient()){
    		return prescriptionRepository.findAllByPatientEmail(email);
    	} else {
    		return prescriptionRepository.findAll();
    	}
	}

    public Prescription getPrescriptionById(int id) {

        Optional<Prescription> optPrescription = prescriptionRepository.findById(id);

        if(optPrescription.isPresent()) {
            return optPrescription.get();
        } else {
            throw new HealthAppointmentPickerNotFoundException("A recept: " + id + " id-val nem található.");
        }
    }
}