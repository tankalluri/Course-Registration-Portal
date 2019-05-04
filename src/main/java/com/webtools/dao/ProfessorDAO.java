package com.webtools.dao;

import com.webtools.pojo.Professor;

public class ProfessorDAO extends DAO{

	public Professor saveProfessorData(Professor p) {
		begin();
		getSession().save(p);
		commit();
		return p;
	}
}
