package hu.projekt.hap.application.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityHelper {

	public static boolean isAdmin() {

		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		return userDetails.getAuthorities().contains(UserRole.ROLE_ADMIN);
	}
	
	public static boolean isDoctor() {

		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		return userDetails.getAuthorities().contains(UserRole.ROLE_DOCTOR);
	}
	
	public static boolean isPatient() {

		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		return userDetails.getAuthorities().contains(UserRole.ROLE_PATIENT);
	}
	
	public static String getUsername() {

		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		return userDetails.getUsername();
	}
	
	public static String getPassword() {

		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		return userDetails.getPassword();
	}
}