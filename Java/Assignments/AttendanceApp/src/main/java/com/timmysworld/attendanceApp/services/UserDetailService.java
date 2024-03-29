package com.timmysworld.attendanceApp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.timmysworld.attendanceApp.models.Role;
import com.timmysworld.attendanceApp.models.User;
import com.timmysworld.attendanceApp.repositories.UserRepository;


@Service
public class UserDetailService implements UserDetailsService {
	@Autowired
	private UserRepository uRepo;

	//1  Finds the user by their username. If a user is found, it returns it with the correct authorities. If the username does not exist, the method throws an error.
		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			
			User user = uRepo.findByUsername(username);
	        
	        if(user == null) {
	            throw new UsernameNotFoundException("User not found");
	        }
	        
	        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities(user));
		}
		
		// 2 returns a list of authorities/permissions for a specific user. For example, our clients can be 'user', 'admin', or both. For Spring Security to implement authorization, we must get the name of the possibles roles for current user from our database and create a new `SimpleGrantedAuthority' object with those roles.
	    private List<GrantedAuthority> getAuthorities(User user){
	        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	        for(Role role : user.getRoles()) {
	            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
	            authorities.add(grantedAuthority);
	        }
	        return authorities;
	    }

}
