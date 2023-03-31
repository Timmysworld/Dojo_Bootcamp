package com.timmysworld.attendanceApp.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.timmysworld.attendanceApp.models.Attendance;

public interface AttendanceRepository extends CrudRepository<Attendance, Long> {
	List<Attendance> findAll();
	Optional<Attendance> findByDate(Date date);
}
