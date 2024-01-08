package hu.projekt.hap.application.service;

import hu.projekt.hap.domain.Department;
import hu.projekt.hap.domain.Medicine;
import hu.projekt.hap.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    public Medicine createMedicine(String code, String name, String description, Department department) {

        Medicine medicine = new Medicine(code, name, description, department);

        return medicineRepository.save(medicine);
    }

    public List<Medicine> getAllMedicinesByDepartmentId(int id) {

        return medicineRepository.findAllByDepartmentId(id);
    }
}