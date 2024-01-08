package hu.projekt.hap.repository;

import org.springframework.data.repository.CrudRepository;
import hu.projekt.hap.domain.Attendance;

public interface AttendanceRepository extends CrudRepository<Attendance, Integer>{

}