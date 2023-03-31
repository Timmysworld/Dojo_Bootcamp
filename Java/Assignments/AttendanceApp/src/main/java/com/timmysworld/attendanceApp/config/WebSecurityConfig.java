package com.timmysworld.attendanceApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
	
	private UserDetailsService userDetailsService;

    // Add BCrypt Bean
    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
//    @Bean
//    AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
//        return new SimpleUrlAuthenticationSuccessHandler();
//    }

		
	//configuration for FORM authentication.
	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.
		//Allows restricting access based upon the HttpServletRequest
	            authorizeRequests()
	            
	            //PathMatcher implementation for Ant-style path patterns.
	                .antMatchers("/css/**", "/images/**", "/js/**","/", "/register","/webjars/**").permitAll()
	                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
	                .anyRequest().authenticated()
	                .and()
	            .formLogin()
	                .loginPage("/login")
	                .defaultSuccessUrl("/admin/dashboard")
	                .permitAll()
	                .and()
	            .logout()
	                .permitAll();
		return http.build();
	}
	
	
	// configureGlobal(AuthenticationManagerBuilder): This method is configuring Spring Security to use our custom implementation of the UserDetailsService with BCrypt.
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    } 
	
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
    }

}
