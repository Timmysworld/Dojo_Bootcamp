package com.timmysworld.attendanceApp.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.timmysworld.attendanceApp.models.Member;
import com.timmysworld.attendanceApp.models.TheGroup;
import com.timmysworld.attendanceApp.services.GroupService;
import com.timmysworld.attendanceApp.services.MemberService;
import com.timmysworld.attendanceApp.services.UserService;

@Controller
public class TheGroupController {
	@Autowired
	GroupService gService;
	@Autowired
	UserService uService;
	@Autowired
	MemberService mService;
	
	//CREATE:
	@GetMapping("/admin/create/group")
	public String createGroup(Model model,Principal principal) {
		model.addAttribute("newGroup", new TheGroup());
		
		String username = principal.getName();
		
		model.addAttribute("currentUser", uService.findByUsername(username));
		model.addAttribute("Groups", gService.allGroups());
		model.addAttribute("groupleader", uService.allUsers());
//		model.addAttribute("newMembers", mService.addMember());
		return "addgroup.jsp";
	}
	
	@PostMapping("/admin/create/group")
	public String createGroup(
			@Valid @ModelAttribute("newGroup")TheGroup newGroup,
			BindingResult result,
			Model model,
			Principal principal
//			HttpSession session
			) {
//		TheGroup g = gService.creategroup(newGroup, result);

		if(result.hasErrors()) {
			return "addgroup.jsp";
		}
		gService.creategroup(newGroup, result);
		
		// stores the group id in session  
//		session.setAttribute("groupid", g.getId());
		//System.out.println(session.getAttribute("groupid"));

		return "redirect:/admin/dashboard";
	}
	
	//READ:
	@GetMapping("/group/{id}")
	public String groupdetails(
			@PathVariable("id")Long id,
			Model model

			) {
		
		model.addAttribute("groups", gService.findGroup(id));
		model.addAttribute("Groups", gService.allGroups());
		model.addAttribute("groupleader", uService.allUsers());
		model.addAttribute("newMember", new Member());
		model.addAttribute("members", mService.allMembers());
		//TODO check for userId = findGroup.user matches or principal authorites admin !=
		return "details.jsp";
	}
	
	//UPDATE:  ALLOWS ADMIN TO CHANGE GROUP NAME & REASSIGN GROUP LEADER
	@GetMapping("/group/{id}/edit")
	public String editGroup(
			@PathVariable("id")Long id,
			Model model
			) {
		model.addAttribute("groups",gService.findGroup(id));
		model.addAttribute("groupleader", uService.allUsers());
		return "edit.jsp";
	}
	
	@PostMapping("/group/{id}/edit")
	public String updateGroup(
			@PathVariable("id")Long  id,
			@Valid @ModelAttribute("groups") TheGroup  groups,
			Model model,
			BindingResult result
			) {
		 if(result.hasErrors()) {
			 return "details.jsp";
		 } else {

			 groups.setId(id);
			 gService.creategroup(groups, result);
			 return "redirect:/admin/dashboard";
		 }
	}
	
	//DELETE: ALLOWS ADMIN TO DELETE A GROUP 
	//TODO: MAKE SURE TO CREATE A SPACE FOR ALL UNASSIGN MEMBERS IF GROUP GETS DELETED.On ADMIN DASHBOARD
	@GetMapping("/group/{id}/delete")
	public String destroy(
			@PathVariable Long id
			) {
		gService.deleteGroup(id);
		return "redirect:/admin/dashboard";
	}
	

}
