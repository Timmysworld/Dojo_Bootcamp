package com.timmysworld.attendanceApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.timmysworld.attendanceApp.models.User;
import com.timmysworld.attendanceApp.repositories.RoleRepository;
import com.timmysworld.attendanceApp.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository uRepo;
	@Autowired
    private RoleRepository rRepo;
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
//	@Autowired
//	private RoleRepository rRepo;
		
	public List<User> allUsers(){
		return uRepo.findAll();
	}
	
	// 1 Saves a client with only the user role.
    public User saveWithUserRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(rRepo.findByName("ROLE_USER"));
        User  loggedin  = uRepo.save(user);
        return loggedin;
        
    }
     
     // 2 Saves a client with only the admin role.
    public void saveUserWithAdminRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(rRepo.findByName("ROLE_ADMIN"));
        uRepo.save(user);
        //return user;
    } 
    
    // 3
    public User findByUsername(String username) {
        return uRepo.findByUsername(username);
    }
    
}
	
	