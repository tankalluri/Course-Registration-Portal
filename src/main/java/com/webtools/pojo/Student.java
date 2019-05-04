package com.webtools.pojo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;



@Entity
@Table(name="student")
public class Student {
	
	@Id
	@Column(name="nuid")
	@NumberFormat(style= Style.NUMBER)
	private int nuid;
	@NotNull
	@Size(min=2, max=30)
	@Pattern(regexp = "[a-zA-Z]+", message="Minimum 2 characters, Maximum 30 characters, Letters only")
	private String firstname;
	@NotNull
	@Size(min=2, max=30)
	@Pattern(regexp = "[a-zA-Z]+", message="Minimum 2 characters, Maximum 30 characters, Letters only" )
	private String lastname;
	@NotNull
	@Size(min=2, max=30)
	@Pattern(regexp = "[a-zA-Z0-9_.]+", message="Minimum 2 characters, Maximum 30 characters, Letters, numbers, (_,.) only")
	private String username;
	private String password;
	@Email(message="Please enter correct email format")
	private String email;
	private String role;
//	@OneToMany(fetch = FetchType.LAZY)
//	private Set<Courses> courses;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinTable(name = "student_courses", joinColumns = {@JoinColumn(name = "nuid" )},
    inverseJoinColumns = {@JoinColumn(name = "courseId")})
	private Set<Courses> courses = new HashSet<>();
	

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Set<Courses> getCourses() {
		return courses;
	}
	public void setCourses(Set<Courses> courses) {
		this.courses = courses;
	}
	public int getNuid() {
		return nuid;
	}
	public void setNuid(int nuid) {
		this.nuid = nuid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
