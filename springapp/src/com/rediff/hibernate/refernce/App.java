package com.rediff.hibernate.refernce;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.rediff.minton.HibernateUtil;

public class App {
	public static void main(String[] args) {
		System.out.println("Hibernate many to many (XML Mapping)");
		manytoone();
		System.out.println("Done");
	}

	public static void simple() {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Student student = new Student();
			student.setName("samar1");

			session.save(student);

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void onetoone() {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			// save student
			Criteria criteria = session.createCriteria(Student.class);
			criteria.add(Restrictions.eq("name", "samar"));
			Student student = (Student) criteria.uniqueResult();
			if (student == null) {
				student = new Student();
				student.setName("samar");
			}
			session.save(student);

			// 1:1 save address
			criteria = session.createCriteria(Address.class);
			criteria.add(Restrictions.eq("city", "mumbai"));
			Address uniqueResult = (Address) criteria.uniqueResult();
			if (uniqueResult == null) {
				uniqueResult = new Address();
				uniqueResult.setCity("mumbai");
				session.save(uniqueResult);
			}

			student.setAddress(uniqueResult);
			session.save(student);

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void manytoone() {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			// M:1 save company
			Criteria criteria = session.createCriteria(Company.class);
			criteria.add(Restrictions.eq("name", "cdac"));
			Company company = (Company) criteria.uniqueResult();
			if (company == null) {
				company = new Company();
				company.setName("cdac");
				session.save(company);
			}

			// save student
			criteria = session.createCriteria(Student.class);
			criteria.add(Restrictions.eq("name", "samar"));
			Student student = (Student) criteria.uniqueResult();
			if (student == null) {
				student = new Student();
				student.setName("samar");
			}
			student.setCompany(company);
			session.save(student);

			criteria = session.createCriteria(Student.class);
			criteria.add(Restrictions.eq("name", "vivek"));
			student = (Student) criteria.uniqueResult();
			if (student == null) {
				student = new Student();
				student.setName("vivek");
			}
			session.save(student);

			student.setCompany(company);
			session.save(student);

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
