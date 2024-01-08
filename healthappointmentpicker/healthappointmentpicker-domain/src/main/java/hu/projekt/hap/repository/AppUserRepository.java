package hu.projekt.hap.repository;

import org.springframework.data.repository.CrudRepository;
import hu.projekt.hap.domain.AppUser;

public interface AppUserRepository extends CrudRepository<AppUser, Integer>{

}