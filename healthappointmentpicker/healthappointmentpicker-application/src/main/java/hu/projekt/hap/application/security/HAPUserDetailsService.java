package hu.projekt.hap.application.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hu.projekt.hap.domain.AppUser;
import hu.projekt.hap.repository.AdminRepository;
import hu.projekt.hap.repository.DoctorRepository;
import hu.projekt.hap.repository.PatientRepository;

@Service
public class HAPUserDetailsService implements UserDetailsService{
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) {

		AppUser user = doctorRepository.findByEmail(username);

		if(user == null) {
			user = patientRepository.findByEmail(username);
			if(user == null) {
				user = adminRepository.findByEmail(username);
				if(user == null) {
					throw new UsernameNotFoundException(username);
				}
			}
		}

		return new HAPUserPrincipal(user);
	}
}