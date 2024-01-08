package hu.projekt.hap.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import hu.projekt.hap.domain.Admin;
import hu.projekt.hap.domain.Role;
import hu.projekt.hap.domain.exception.HealthAppointmentPickerConflictException;
import hu.projekt.hap.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
    private AdminRepository adminRepository;
	
	public Admin createAdmin(String email, String pwd, String name, String phonenumber, Role role) {

		Admin admin = new Admin(email, pwd, name, role, phonenumber);
	
		try {
			return adminRepository.save(admin);
		} catch (DataIntegrityViolationException e) {
			throw new HealthAppointmentPickerConflictException("Érvénytelen e-mail, már szerepel az adatbázisban!");
		}
	}
}