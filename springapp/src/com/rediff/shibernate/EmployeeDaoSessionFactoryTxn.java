package com.rediff.shibernate;

import org.hibernate.SessionFactory;

public class EmployeeDaoSessionFactoryTxn {
	protected SessionFactory sessionFactory;

	public void saveEmployee(Employee e) {
		sessionFactory.getCurrentSession().save(e);
	}

	public void updateEmployee(Employee e) {
		sessionFactory.getCurrentSession().update(e);
	}

	public void deleteEmployee(Employee e) {
		sessionFactory.getCurrentSession().delete(e);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
