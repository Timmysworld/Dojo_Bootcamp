package com.timmysworld.attendanceApp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.timmysworld.attendanceApp.models.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	List<Role> findAll();
	List<Role> findByName(String name);
}
