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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name= "thegroups")
public class TheGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	// This will not allow the createdAt column to be updated after creation
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    //DATABASE TABLE RELATIONSHIP CONNECTION
    
    	//GROUPS TO USERS
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User groupleader;
    
    	//ONE GROUP HAS MANY MEMBERS
    @OneToMany(mappedBy = "groups", fetch = FetchType.LAZY)
    private List<Member> members;
     
    public TheGroup() {}
    
    //GETTERS ANN SETTERS 
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public User getGroupleader() {
		return groupleader;
	}

	public void setGroupleader(User groupleader) {
		this.groupleader = groupleader;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    
}//END CLASS
