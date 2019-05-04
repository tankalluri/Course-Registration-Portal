package com.webtools.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import com.webtools.pojo.Courses;
import com.webtools.pojo.Professor;

public class CourseDAO extends DAO{

	public List<Courses> searchCourseByCourseName(String keyword) {
		Query q = getSession().createQuery("from Courses where courseName like :cname");
		 q.setString("cname", "%"+keyword+"%");
		 List<Courses> c= q.list();
		return c;
	}
	
	public List<Courses> searchCourseByCourseId(String keyword) {
		int cid = Integer.parseInt(keyword);
		Query q = getSession().createQuery("from Courses where courseId=:cid");
		 q.setInteger("cid", cid);
		 List<Courses> c= q.list();
		return c;
	}
	
	public void buildCourseData(Courses c, ProfessorDAO p) {
		Query q = getSession().createQuery("from Courses where courseId=:cid");
		q.setInteger("cid", c.getCourseId());
		Professor prof=buildProfessorData(c, p);
	}

	public Courses getCurrentSelectedCourse(int cid) {
		begin();
		Criteria crit = getSession().createCriteria(Courses.class);
		crit.add(Restrictions.eq("courseId", cid));
		Courses course = (Courses) crit.uniqueResult();
		commit();
		return course;
		
	}
	
	public Professor buildProfessorData(Courses c, ProfessorDAO pd){
		Professor p= null;
		if(c.getCourseId()==1) {
			p = new Professor("parikh.t@northeastern.edu","Tejas Parikh");
		}
		else if(c.getCourseId()==2) {
			p = new Professor("chawla.v@northeastern.edu","Vishal Chawla");
		}
		else if(c.getCourseId()==3) {
			p = new Professor("ozbek.y@northeastern.edu","Yusuf Ozbek");
		}
		else if(c.getCourseId()==4) {
			p = new Professor("kokar.m@northeastern.edu","Michael Kokar");
		}
		else if(c.getCourseId()==5) {
			p = new Professor("pirozzi.m@northeastern.edu","Maricla Pirozzi");
		}
		else if(c.getCourseId()==6) {
			p = new Professor("bug.kal@northeastern.edu","Kal Bugrara");
		}
		else if(c.getCourseId()==7) {
			p = new Professor("ghassemi.m@northeastern.edu","Mohsin Ghassemi");
		}
		p.setCourse(c);
		pd.saveProfessorData(p);
		return p;
	}
	
	public List<Professor> getProfessorDetails(int cid) { 
		List<Professor> pf= new ArrayList<Professor>();
		Query q = getSession().createQuery("from Professor where courseId=:cid");
		q.setInteger("cid", cid);
		q.setMaxResults(1);
		pf =  q.list();
		return pf;
		
	}
}
