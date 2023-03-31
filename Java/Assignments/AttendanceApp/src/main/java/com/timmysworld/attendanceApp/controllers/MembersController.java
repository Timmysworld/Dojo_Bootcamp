package com.timmysworld.attendanceApp.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
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

import com.timmysworld.attendanceApp.models.Member;
import com.timmysworld.attendanceApp.services.GroupService;
import com.timmysworld.attendanceApp.services.MemberService;
import com.timmysworld.attendanceApp.services.UserService;

@Controller
public class MembersController {
	@Autowired
	MemberService mService;
	
	@Autowired
	GroupService gService;
	
	@Autowired
	UserService uService;
	
	//CREATE:
	@GetMapping("/member/add")
	public String addMember(
			@ModelAttribute ("newMember")Member newMember, 
			Principal principal
			) {
		return "details.jsp";
	}
	
	@PostMapping("/member/add")
	public String addMember(
			@Valid @ModelAttribute("newMember")Member newMember,
			BindingResult result,
			Model model,
			Principal principal,
			@RequestParam("group_id")Long groupId,
			HttpServletRequest request
			) {
		
		if(result.hasErrors()) {
			return "addgroup.jsp";
		}
		
		// creates relationship to group
		newMember.setGroups(gService.findGroup(groupId));
		// HOPEFULLY: stores group id into sessions
//		request.getSession().setAttribute("groupID_Session",groupId);
		mService.addMember(newMember, result);
		return "redirect:/admin/dashboard";
	}
	
	//READ: 

	//UPDATE:
	@GetMapping("/member/{id}/{groups_id}/edit")
	public String editMember(
			@PathVariable("id") Long id,
			@PathVariable("groups_id") Long groups_id,
			Model model
			) {
		model.addAttribute("groups", gService.findGroup(groups_id));
		model.addAttribute("member", mService.findMemberById(id));
		return "editmember.jsp";
	}
	@PostMapping("/member/{id}/edit")
	public String updateMember(
			@PathVariable("id")Long id,
			@Valid @ModelAttribute("member")Member member,
			BindingResult result,
			@RequestParam(name="group_id")Long groupId,
//			HttpServletRequest request,
			Model model
			) {
		if(result.hasErrors()) {
			 return "editmember.jsp";
		 } else { 
//			 request.getParameter("group_id");
//			 request.setAttribute("groupID_Session",groupId);
//			 System.out.println(groupId);
			 member.setId(id);
			 member.setGroups(gService.findGroup(groupId));
			 mService.addMember(member, result);
			 return "redirect:/admin/dashboard";
		 }
	}
	//DELETE:
	@GetMapping("/member/{id}/delete")
	public String destroy(
			@PathVariable Long id
			) {
		mService.deleteMember(id);
		return"redirect:/admin/dashboard";
			
	}
	
	


}
