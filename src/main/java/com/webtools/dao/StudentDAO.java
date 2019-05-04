package com.webtools.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.jboss.logging.Message;

import com.webtools.exception.StudentException;
import com.webtools.pojo.Courses;
import com.webtools.pojo.Student;

public class StudentDAO extends DAO {

	public StudentDAO() {
	}
		
	public Student fetchStudent(String usernm, String pass) throws StudentException {
		try {
			begin();
			Query query = getSession().createQuery("from Student where username=:usernm and password=:password");
			query.setString("usernm", usernm);
			query.setString("password", pass);
			query.setMaxResults(1);
			Student student = (Student) query.uniqueResult();
			commit();
			return student;
		} catch (HibernateException e) {
			rollback();
			throw new StudentException("Was unable to fetch the student");
		}
	}
	
	public Student fetchStudentByName(String usernm) throws StudentException {
		try {
			begin();
			Query query = getSession().createQuery("from Student where username=:usernm");
			query.setString("usernm", usernm);
			query.setMaxResults(1);
			Student student = (Student) query.uniqueResult();
			commit();
			return student;
		} catch (HibernateException e) {
			rollback();
			throw new StudentException("Was unable to fetch the student");
		}
	}
	
	public Student register(Student s)
			throws StudentException {
		try {
			begin();
			getSession().save(s);
			commit();
			return s;

		} catch (HibernateException e) {
			rollback();
			throw new StudentException("Registration Failed." + e.getMessage());
		}
	}
	
	public boolean checkIfAlreadyExists(){
		Query query = getSession().createQuery("from Courses");
		List<Courses> c = query.list();
		if(c.size()<1)
		return true;
		else 
		return false;	
	}

	public boolean checkIfEmailExists(String email) {
		Query query = getSession().createQuery("from Student where email=:email");
		query.setString("email", email);
		List<Student> list = query.list();
		if(list.size()==0 || list==null)
		return false;//it is unique
		else
			return true;
	}
}