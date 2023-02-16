package com.timmysworld.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.timmysworld.bookclub.models.Book;
import com.timmysworld.bookclub.models.LoginUser;
import com.timmysworld.bookclub.models.User;
import com.timmysworld.bookclub.services.BookService;
import com.timmysworld.bookclub.services.userService;

@Controller
public class MainController {
	@Autowired 
	userService service;
	@Autowired
	BookService  BookService;
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/register")
	public String registerForm(Model model) {
		model.addAttribute("newUser", new User());
		return "register.jsp";
	}
	
	@GetMapping("/login")
	public String loginForm(Model model) {
		model.addAttribute("newLogin", new LoginUser());
		return "login.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		//CHECKS IF USER IS STORED IN SESSIONS
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/";
		}
		User user = service.findById(userId);
		model.addAttribute("user", user);
		model.addAttribute("books", BookService.allBooks());
		return "dashboard.jsp";
	}
	
	@PostMapping("/register")
	public String register(
			@Valid @ModelAttribute("newUser")User newUser,
			BindingResult result,			  
			HttpSession session
			) {
		User u = service.register(newUser,result);
		if (u == null) {
			return "register.jsp";
			}else {
			session.setAttribute("userId", u.getId());
			return "redirect:/dashboard";
		}
		
	}
	
	@PostMapping("/login")
	public String login(
			@Valid @ModelAttribute("newLogin") LoginUser newLogin,
			BindingResult result,
			Model model,
			HttpSession session
			) {
		User user = service.login(newLogin, result);
		 
	     if(result.hasErrors()) {
	         model.addAttribute("newUser", new User());
	         return "login.jsp";
	         }
	     session.setAttribute("userId", user.getId());
	     return "redirect:/dashboard";
	}
	
	//LOGS USER OUT OF SESSIONS
	 @GetMapping("/logout")
	 public String logout(HttpSession session) {
		 session.setAttribute("userId", null);
		 return "redirect:/";
	 }
	 
	 //CREATE : ADDS A BOOK TO USER SHELF
	 @GetMapping("/book/new")
	 public String addBookForm(Model model,HttpSession session) {
		 model.addAttribute("newBook",new Book());
		 //ATTACHED SESSION USER TO THE BOOK 
		 User user = service.findById((Long)session.getAttribute("userId"));
		 model.addAttribute("user",user);
		 return "addbook.jsp";
	 }
	 
	 @PostMapping("/book/new")
	 public String addBook(
			 @Valid @ModelAttribute("newBook")Book newBook,
			 BindingResult result,
			 Model model,
			 HttpSession session
			 ) {
		 Book b = BookService.addbook(newBook, result);
		 
		 if(result.hasErrors()) {
			 return "addbook.jsp";
		 }
		 session.setAttribute("userId",b.getId());
		 return "redirect:/dashboard";
	 }
	 
	 //READ: SHOWS DETAILS OF THE BOOK AND THOUGHTS 
	 @GetMapping("/book/{id}")
	 public String details(
			 @PathVariable("id")Long id,
			 Model model,
			 HttpSession session
			 ) {
		 	Long userId = (Long) session.getAttribute("userId");
			if(userId == null) {
				return "redirect:/";
			}
		 model.addAttribute("books", BookService.findBook(id));
		 //System.out.println(session.getAttribute("userId"));
		 return "details.jsp";
	 }
	 
	 //UPDATE: ALLOWS USER TO EDIT HIS/HER BOOK INPUT 
	 @GetMapping("/book/{id}/edit")
	 public String editBook(
			 @PathVariable("id")Long id,
			 Model model,
			 HttpSession session
			 ) {
		 	Long userId = (Long) session.getAttribute("userId");
			if(userId == null) {
				return "redirect:/";
			}
		 model.addAttribute("books", BookService.findBook(id));
		 return "edit.jsp";
	 }
	 @PostMapping("/book/{id}/edit")
	 public String updateBook(
			 @PathVariable("id")Long id,
			 @Valid @ModelAttribute("books")Book books,
			 BindingResult result
			 ) {
		 if(result.hasErrors()) {
			 return "details.jsp";
		 } else {
			 books.setId(id);
			 BookService.updateBook(books);
			 return "redirect:/dashboard";
		 }
		 
	 }
	 
	 //DELETE: ALLOWS USER TO DELETE HIS/HER ENTRY
		@GetMapping("/book/{id}/delete")
		public String destroy(
				@PathVariable Long id
				) {
			BookService.deleteBook(id);
			return "redirect:/dashboard";
		}
	     
	

}// END MAIN CONTROLLER
