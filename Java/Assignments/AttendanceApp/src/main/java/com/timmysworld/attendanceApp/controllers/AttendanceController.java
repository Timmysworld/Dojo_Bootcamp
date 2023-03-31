package com.timmysworld.attendanceApp.controllers;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.timmysworld.attendanceApp.models.Attendance;
import com.timmysworld.attendanceApp.services.AttendanceService;
import com.timmysworld.attendanceApp.services.GroupService;
import com.timmysworld.attendanceApp.services.MemberService;

@Controller
public class AttendanceController {
	@Autowired
	AttendanceService aService;
	@Autowired 
	MemberService mService;
	@Autowired
	GroupService gService;
	
	@GetMapping("/attendance/{attendance_id}/{member_id}/{group_id}/add")
	public String addAttendance(
			@PathVariable("attendance_id")Long id,
			@PathVariable("member_id")Long member_id,
			@PathVariable("group_id")Long group_id,
			Model model
			) {
		model.addAttribute("member", mService.findMemberById(member_id));
		model.addAttribute("groups", gService.findGroup(group_id));
		return "details.jsp";
	}
	
	@PostMapping("/attendance/{attendance_id}/{member_id}/add")
	public String addAttendance(
			@PathVariable("member_id")Long member_id,
			@Valid @ModelAttribute("attendance")Attendance attendance,
			BindingResult result,
			@RequestParam(name="member_id")Long currentMember_id,
			@RequestParam(name="date")Date currentDate,
			Model model
			) {
		if(result.hasErrors()) {
			 return "editmember.jsp";
		 } else {
			 attendance.setDate(currentDate);
			 attendance.setMember(mService.findMemberById(currentMember_id));
			 aService.addAttendance(attendance, result);
			 return "redirect:/group/{id}";
		 }
		
	}
	
		
	
}