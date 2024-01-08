package hu.projekt.hap.repository;

import hu.projekt.hap.domain.Prescription;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PrescriptionRepository extends CrudRepository<Prescription, Integer>{

	List<Prescription> findAllByDoctorEmail(String email);
	
	List<Prescription> findAllByPatientEmail(String email);
	
	List<Prescription> findAll();
}