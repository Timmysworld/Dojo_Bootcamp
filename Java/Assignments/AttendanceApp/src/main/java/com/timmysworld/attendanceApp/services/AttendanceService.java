package com.timmysworld.attendanceApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.timmysworld.attendanceApp.models.Attendance;
import com.timmysworld.attendanceApp.repositories.AttendanceRepository;

@Service
public class AttendanceService {
	@Autowired
	private AttendanceRepository aRepo;
	
	public List<Attendance> allAttendance(){
		return aRepo.findAll();
	}
	
	//CREATE ATTENDANCE:
	public Attendance addAttendance(Attendance newAttendance, BindingResult result) {
		return aRepo.save(newAttendance);
	}

}
