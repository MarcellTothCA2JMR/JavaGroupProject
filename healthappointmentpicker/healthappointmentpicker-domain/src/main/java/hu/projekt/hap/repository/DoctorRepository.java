package hu.projekt.hap.repository;

import org.springframework.data.repository.CrudRepository;
import hu.projekt.hap.domain.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Integer>{

	Doctor findByEmail(String email);
}