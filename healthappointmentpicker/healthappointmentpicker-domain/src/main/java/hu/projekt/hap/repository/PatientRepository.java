package hu.projekt.hap.repository;

import org.springframework.data.repository.CrudRepository;
import hu.projekt.hap.domain.Patient;

public interface PatientRepository extends CrudRepository<Patient, Integer>{

	Patient findByEmail(String email);
}