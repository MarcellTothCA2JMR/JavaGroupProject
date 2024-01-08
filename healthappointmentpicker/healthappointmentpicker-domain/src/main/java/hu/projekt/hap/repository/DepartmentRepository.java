package hu.projekt.hap.repository;

import hu.projekt.hap.domain.ConsultationCategory;
import hu.projekt.hap.domain.Department;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepartmentRepository extends CrudRepository<Department, Integer>{

	Department findByCategory(ConsultationCategory consultationCategory);
	
	List<Department> findAll();
}