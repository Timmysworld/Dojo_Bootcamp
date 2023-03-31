package com.timmysworld.attendanceApp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.timmysworld.attendanceApp.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findAll();
	User findByUsername(String username);
	Optional<User> findById(Long Id);
	Optional<User> findByEmail(String email);
}
