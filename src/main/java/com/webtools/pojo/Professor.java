package com.webtools.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="professor")
public class Professor {

	public Professor(String emailId, String name){
		this.emailId=emailId;
		this.name= name;
	}
	public Professor() {
		
	}
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int profId;
	
	private String emailId;
	
	@Column(name="profName")
	private String name;
	
	@OneToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name= "courseId")
	private Courses course;
	
	public int getProfId() {
		return profId;
	}
	public void setProfId(int profId) {
		this.profId = profId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Courses getCourse() {
		return course;
	}
	public void setCourse(Courses course) {
		this.course = course;
	}
	
	
}
