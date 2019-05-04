package com.webtools.dao;

import org.hibernate.Query;
import org.hibernate.HibernateException;
import com.webtools.exception.StudentException;
import com.webtools.pojo.Courses;

public class AdminDAO extends DAO{

	public void addCourse(Courses c) throws StudentException {
		try{
			begin();
		getSession().save(c);
		commit();	
		}
		catch (HibernateException e) {
			rollback();
			throw new StudentException("Operation Failed" + e.getMessage());
		}
	}

	public void removeCourse(String cid) {
		begin();
		Query q= getSession().createQuery("delete from Courses where courseId=:cid");
		q.setInteger("cid", Integer.parseInt(cid));
		q.executeUpdate();
		commit();
	}
	
	public void updateCourse(String name, String cid) {
		begin();
		Query q= getSession().createQuery("update Courses set courseName=:nm where courseId=:cid");
		q.setString("nm", name);
		q.setInteger("cid", Integer.parseInt(cid));
		q.executeUpdate();
		commit();
	}
}
