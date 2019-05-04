package com.webtools.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name="courseList")
public class Courses {

	public Courses(String courseName, int section, String time){
		this.time= time;
		this.courseName=  courseName;
		this.section= section;
	}
	
	public Courses(int courseId, String courseName, int section, String time){
		this.time= time;
		this.courseName=  courseName;
		this.section= section;
		this.courseId=courseId;
	}
	
	public Courses() {
		
	}
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@NotNull
	@NumberFormat(style= Style.NUMBER)
	private int courseId;
	
	private String courseName;
	private int section;
	private String time;
	
	// new lines adding
	@ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL)
    Set<Student> users = new HashSet<Student>();
	
	public int getSection() {
		return section;
	}
	public void setSection(int section) {
		this.section = section;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}	
}
