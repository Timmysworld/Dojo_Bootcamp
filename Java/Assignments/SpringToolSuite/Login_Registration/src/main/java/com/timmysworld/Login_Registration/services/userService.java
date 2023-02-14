package com.timmysworld.Login_Registration.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.timmysworld.Login_Registration.models.LoginUser;
import com.timmysworld.Login_Registration.models.User;
import com.timmysworld.Login_Registration.repositories.UserRepository;


@Service
public class userService {
	@Autowired
	private UserRepository repo;
	
//	public userService(UserRepository repo) {
//			this.repo  = repo;
	//	}
	 public List<User> allUsers() {
	        return repo.findAll();
	    }
	
	//REGISTER A USER
	public User register(User newUser, BindingResult result) {
		if(result.hasErrors()) {
		return null;
		}
		
		Optional<User> u = repo.findByEmail(newUser.getEmail());
		
		if(u.isPresent()) {
			
			result.rejectValue("email","email", "Email already exist. Please login!");
			return null;
		}
		
		if(!newUser.getPassword().equals(newUser.getConfirmPassword())) {
			result.rejectValue("confirmPassword","password", "Passwords must match!");
			return null;
		}
		
		String hashedPW  = BCrypt.hashpw(newUser.getPassword(),BCrypt.gensalt());
		newUser.setPassword(hashedPW);
		
		return  repo.save(newUser);
	}
		
	
	//LOGIN A USER
	public User login(LoginUser LoginUser, BindingResult result) {

		
		Optional<User> loginuser = repo.findByEmail(LoginUser.getEmail());
		
		//CHECKING IF EMAIL IS IN DATABASE
		if(!loginuser.isPresent()) {
			result.rejectValue("email","exist", "Invalid Login Attempt!" );
			return null;
		}
		//GRAB USER BEFORE CHECKING FOR PASSWORD 
		//need to compare form password with database password
		User user = loginuser.get();
		
		//CHECKING DATABASE PASSWORD
		if(!BCrypt.checkpw(LoginUser.getPassword(), user.getPassword())){
			result.rejectValue("password", "Matches", "Invalid Password!");
	    }
	    
		if(result.hasErrors()) {
			return null;
	}
		return user;
  }
	
    public User findById(Long id) {
    	Optional<User> loginUser = repo.findById(id);
    	if(loginUser.isPresent()) {
    		return loginUser.get();
    	}
    	return null;
    }

}
