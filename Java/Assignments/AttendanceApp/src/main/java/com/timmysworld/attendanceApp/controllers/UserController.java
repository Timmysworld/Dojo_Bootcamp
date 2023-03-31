package com.timmysworld.attendanceApp.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.timmysworld.attendanceApp.models.User;
import com.timmysworld.attendanceApp.services.GroupService;
import com.timmysworld.attendanceApp.services.UserService;

@Controller
//@RequestMapping("/api/v1")
public class UserController {
	@Autowired
	UserService uService;
	
	@Autowired
	GroupService gService;
	
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	// REGISTER USERS
	@GetMapping("/register")
	public String registerForm(Model model) {
		model.addAttribute("newUser", new User());
		return "register.jsp";
	}
	
	@PostMapping("/register")
    public String register(
    		@Valid @ModelAttribute("user") User user, 
    		BindingResult result, 
    		Model model,
    		Principal principal
    		) {
		//userValidator.validate(user, result);
        if (result.hasErrors()) {
        	
            return "register.jsp";
        }
        //TO DO: decide to set up if or create in userService, to check if user is admin or user
        	// stores newly added user.
        
//    uService.saveWithUserRole(user);
      uService.saveUserWithAdminRole(user);
//        	 stores newly added user id into sessions.
//        RequestContextHolder.currentRequestAttributes().getSessionId();
//        session.setAttribute("userId", user.getId());
//        System.out.println("SessionId:" + session.getAttribute("userId"));
        
        return "redirect:/admin/dashboard";
    }
	
	//  LOGIN  USERS 
	// when the credentials are wrong, Spring Security redirect the client to the /login?error url. Furthermore, when a client logs out via the form in our dashboard.jsp file, Spring Security redirects them to /login?logout url. Therefore, all we do is set a couple of optional request parameters, check for their existence, and add messages accordingly.
		@GetMapping("/login")
		public String login(
				@RequestParam(value="error", required=false) String error, 
				@RequestParam(value="logout", required=false) String logout, 
				Model model,
				Principal principal
				) {
	        if(error != null) {
//	        	System.out.println(error);
//	        	System.out.println("hi");
	            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
	        }
	        if(logout != null) {
	            model.addAttribute("logoutMessage", "Logout Successful!");
	        }
	        return "login.jsp";
	    }
		
		
    @GetMapping("/admin/dashboard")
    public String adminPage(Principal principal, Model model) {
        String username = principal.getName();
//        System.out.println(principal);
        model.addAttribute("currentUser", uService.findByUsername(username));
        model.addAttribute("newGroup", gService.allGroups());
        return "dashboard.jsp";
    }
	

}
