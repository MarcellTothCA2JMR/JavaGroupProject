package hu.projekt.hap.repository;

import hu.projekt.hap.domain.Appointment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer>{

	List<Appointment> findAllByMedicalAttendantId(int id);
	
	List<Appointment> findAllByMedicalAttendantEmail(String email);
	
	List<Appointment> findAllByPatientEmail(String email);
	
	List<Appointment> findAll();
}