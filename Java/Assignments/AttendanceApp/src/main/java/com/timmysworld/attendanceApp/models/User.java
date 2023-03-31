package com.timmysworld.attendanceApp.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
//	@Size(min=3, max=10, message= "Username must  be between 3 & 10 characters")
	private String username;
	
//	@Size(min=3, max=20, message="First Name must be between 3 and 20 characters")
	private String firstName;
	
//	@Size(min=3, max= 20, message="Last Name must be between 3 and 20 characters")
	private String lastName;
	
//	@NotEmpty(message="Email is required")
//	@Email(message="Please enter a valid email")
	private String email;
	
//	@Size(min=8, max=128, message="Password must be a minimum of 8 characters")
	private String password;
	
	@Transient
	private String confirmPassword;
	
	// This will not allow the createdAt column to be updated after creation
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
	//DATABASE TABLE RELATIONSHIP CONNECTION
    
		// USERS TO ROLES
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns= @JoinColumn(name = "role_id")
			)
	private List<Role> roles;
    
    	// USERS TO GROUPS
    @OneToOne(mappedBy ="groupleader", fetch = FetchType.LAZY)
    private TheGroup group;
    
//    	//many users to one group
//    @ManyToMany(fetch =FetchType.LAZY)
//	@JoinTable(
//			name = "users_groups",
//			joinColumns = @JoinColumn(name = "user_id"),
//			inverseJoinColumns = @JoinColumn(name = "group_id")
//			)
//	private List<TheGroup> groups;
    
    
	public User() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }



}//End Class
