package com.webtools.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="semester")
public class Semesters {

	public Semesters(){
		
	}
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int semNum;
	
	private int year;
	
	private String semesterName;
	
	@ManyToOne
	@JoinColumn(name= "courseId")
	private Courses course;

	public int getSemNum() {
		return semNum;
	}

	public void setSemNum(int semNum) {
		this.semNum = semNum;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getSemesterName() {
		return semesterName;
	}

	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}

	public Courses getCourse() {
		return course;
	}

	public void setCourse(Courses course) {
		this.course = course;
	}

	 
}
