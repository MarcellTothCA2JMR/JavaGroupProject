package hu.projekt.hap.repository;

import org.springframework.data.repository.CrudRepository;

import hu.projekt.hap.domain.Admin;

public interface AdminRepository extends CrudRepository<Admin, Integer>{

	Admin findByEmail(String email);
}