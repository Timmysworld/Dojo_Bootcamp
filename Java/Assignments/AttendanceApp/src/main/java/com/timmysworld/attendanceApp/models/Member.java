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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "members")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String fName;
	
	private String lName;
	
	// This will not allow the createdAt column to be updated after creation
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    //DATABASE TABLE RELATIONSHIP CONNECTION
    
    	//MANY MEMBERS CAN JOIN ONE GROUP
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private TheGroup groups;
    
    	//A Members Attendance
    @OneToMany(mappedBy = "member" ,fetch = FetchType.LAZY)
    private List<Attendance> attendance;
    
    public Member() {}
    
    //GETTERS ANN SETTERS
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public TheGroup getGroups() {
		return groups;
	}

	public void setGroups(TheGroup groups) {
		this.groups = groups;
	}

	public List<Attendance> getAttendance() {
		return attendance;
	}

	public void setAttendance(List<Attendance> attendance) {
		this.attendance = attendance;
	}

	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
 
    
}
