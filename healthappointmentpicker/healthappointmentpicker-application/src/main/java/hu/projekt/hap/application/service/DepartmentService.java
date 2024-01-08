package hu.projekt.hap.application.service;

import hu.projekt.hap.domain.Attendance;
import hu.projekt.hap.domain.ConsultationCategory;
import hu.projekt.hap.domain.Department;
import hu.projekt.hap.domain.Doctor;
import hu.projekt.hap.domain.exception.HealthAppointmentPickerNotFoundException;
import hu.projekt.hap.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department createDepartment(int floor, ConsultationCategory category, List<Doctor> doctors, List<Attendance> attendances) {

        Department dep = new Department(floor, category, doctors, attendances);
        
        return departmentRepository.save(dep);
    }

    public List<Department> getAllDepartments() {

        return departmentRepository.findAll();
    }
    
    public Department getDepartmentByCategory(ConsultationCategory cc) {
    	
    	return departmentRepository.findByCategory(cc);
    }
    
    public void addDoctorToDepartment(Doctor doctor) {
		
		Department department = getDepartmentByCategory(doctor.getSpecialization());

        List<Doctor> ds = department.getDoctors();
		ds.add(doctor);
		department.setDoctors(ds);

        departmentRepository.save(department);
	}

    public Department getDepartmentById(int id) {

        Optional<Department> optDepartment = departmentRepository.findById(id);

        if(optDepartment.isPresent()) {
            return optDepartment.get();
        } else {
            throw new HealthAppointmentPickerNotFoundException("A szakosztály: " + id + " id-val nem található.");
        }
    }

    public void updateDepartment(int id, int floor, ConsultationCategory category,List<Attendance> attendances) {

        Department department = getDepartmentById(id);

        department.setAttendances(attendances);
        department.setFloor(floor);
        department.setCategory(category);

        departmentRepository.save(department);
    }
}
