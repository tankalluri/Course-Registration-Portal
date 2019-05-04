package com.webtools.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import com.webtools.exception.StudentException;
import com.webtools.pojo.Courses;
import com.webtools.pojo.Semesters;

public class SemesterDAO extends DAO{
	
	public List<Semesters> fetchSemesters() throws StudentException {
		try {
			begin();
			Query query = getSession().createQuery("from Semesters");
			List<Semesters> sem = query.list();
			commit();
			return sem;
		} catch (HibernateException e) {
			rollback();
			throw new StudentException("Could not fetch the semesters");
		}
	}
	
	public void buildSemesters() throws StudentException, ClassNotFoundException, SQLException {
		try {
			begin();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursereg", "root", "root");
			PreparedStatement q = con.prepareStatement("insert into semester values(?,?,?), (?,?,?), (?,?,?), (?,?,?)");
			q.setInt(1, 1);
			q.setString(2, "Fall");
			q.setString(3, "2018");
			
			q.setInt(4, 2);
			q.setString(5, "Spring");
			q.setString(6, "2019");
			
			q.setInt(7, 3);
			q.setString(8, "Summer");
			q.setString(9, "2019");
			
			q.setInt(10, 13);
			q.setString(11, "Fall");
			q.setString(12, "2019");
			System.out.println("semester query->"+q);
//			con.commit();
		} catch (HibernateException e) {
			rollback();
			throw new StudentException("Could not build semester data");
		}
	}
	
	public List<Courses> fetchCoursesForEachSemester(String semm) throws StudentException {
		try {
			begin();
//			if(semm.equalsIgnoreCase(""))
			Query q = getSession().createQuery("from Courses where semester = :semm");
			q.setString("semm", semm);
			List<Courses> cr = q.list();
			commit();
			return cr;
		} catch (HibernateException e) {
			rollback();
			throw new StudentException("Could not fetch the semesters");
		}
	}	
}
