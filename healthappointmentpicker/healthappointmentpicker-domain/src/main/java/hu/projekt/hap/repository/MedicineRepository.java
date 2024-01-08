package hu.projekt.hap.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hu.projekt.hap.domain.Medicine;

public interface MedicineRepository extends CrudRepository<Medicine, Integer>{

	List<Medicine> findAllByDepartmentId(int id);
}