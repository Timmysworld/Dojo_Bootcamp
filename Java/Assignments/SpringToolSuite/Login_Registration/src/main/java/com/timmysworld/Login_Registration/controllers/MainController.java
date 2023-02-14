package com.timmysworld.Login_Registration.controllers;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.timmysworld.Login_Registration.models.LoginUser;
import com.timmysworld.Login_Registration.models.User;
import com.timmysworld.Login_Registration.services.userService;

//.. don't forget to include all your imports! ..

@Controller
public class MainController {
 
 // Add once service is implemented:
  @Autowired
  private final userService userService;
  public MainController(userService  service) {
	  this.userService = service;
  }
 
 @GetMapping("/")
 public String index(Model model) {
 //ONLY HERE BECAUSE BOTH FORMS ON SAME PAGE
     // Bind empty User and LoginUser objects to the JSP
     // to capture the form input
     model.addAttribute("newUser", new User());
     model.addAttribute("newLogin", new LoginUser());
    return "login_registration.jsp";
 }
 
 @PostMapping("/register")
 public String register(
		 @Valid @ModelAttribute("newUser") User newUser, 
         BindingResult result, 
         @ModelAttribute("newLogin") LoginUser newLogin,  
         HttpSession session
         ) {
     
     // call a register method in the service 
     // to do some extra validations and create a new user!
     User u = userService.register(newUser,result);
     if(u ==  null){
         // Be sure to send in the empty LoginUser before 
         // re-rendering the page.
         return "login_registration.jsp";
     } else {
     
     // No errors! 
     // Store their ID from the DB in session, 
     // in other words, log them in.
     session.setAttribute("userId", u.getId());
     return "redirect:/home";
     }
 }
 
 @PostMapping("/login")
 public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
         BindingResult result, Model model, HttpSession session) {
     
     // Add once service is implemented:
     User user = userService.login(newLogin, result);
 
     if(result.hasErrors()) {
         model.addAttribute("newUser", new User());
         return "login_registration.jsp";
     }
     // No errors! 
     // TO-DO Later: Store their ID from the DB in session, 
     // in other words, log them in.
     session.setAttribute("userId", user.getId());
     return "redirect:/home";
 }
 
 @GetMapping("/home")
 public String home(Model model, HttpSession session) {
	 //GATHERS SESSION ID AND CHECKS TO SEE IF STORED TO ALLOW VIEWING OF PAGE
	 Long userId = (Long) session.getAttribute("userId");
	 if(userId==null) {
		 return "redirect:/";
	 }
	 
	 User user = userService.findById(userId);
	 model.addAttribute("user", user);
	 return "index.jsp";
 }

 //LOGS USER OUT OF SESSIONS
 @GetMapping("/logout")
 public String logout(HttpSession session) {
	 session.setAttribute("userId", null);
	 return "redirect:/";
 }
}

