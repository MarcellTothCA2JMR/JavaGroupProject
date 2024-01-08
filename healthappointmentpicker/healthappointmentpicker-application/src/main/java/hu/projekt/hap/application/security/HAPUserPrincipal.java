package hu.projekt.hap.application.security;

import hu.projekt.hap.domain.AppUser;
import hu.projekt.hap.domain.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class HAPUserPrincipal implements UserDetails{

	final private AppUser user;
	
	public HAPUserPrincipal(AppUser user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		if(user.getRole() == Role.ADMIN) {
			return List.of(UserRole.ROLE_ADMIN);
		} else if(user.getRole() == Role.DOCTOR) {
			return List.of(UserRole.ROLE_DOCTOR);
		} else {
			return List.of(UserRole.ROLE_PATIENT);
		}		
	}

	@Override
	public String getPassword() {

		return user.getPassword();
	}

	@Override
	public String getUsername() {

		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}
}