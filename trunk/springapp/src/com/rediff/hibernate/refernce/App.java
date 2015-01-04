package com.rediff.hibernate.refernce;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.rediff.minton.HibernateUtil;

public class App {
	public static void main(String[] args) {
		System.out.println("Hibernate many to many (XML Mapping)");
		manytomany();
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

			// 1:1 save address
			Criteria criteria = session.createCriteria(Address.class);
			criteria.add(Restrictions.eq("city", "mumbai"));

			Address address = (Address) criteria.uniqueResult();
			if (address == null) {
				address = new Address();
				address.setCity("mumbai");
				session.save(address);
			}

			// save student
			criteria = session.createCriteria(Student.class);
			criteria.add(Restrictions.eq("name", "samar"));
			Student student = (Student) criteria.uniqueResult();
			if (student == null) {
				student = new Student();
				student.setName("samar");
			}

			student.setAddress(address);
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

	public static void onetomany() {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			// 1:M save phone
			Set<Phone> phone_set = new HashSet<Phone>();
			Phone p1 = new Phone();
			p1.setPhone_no("1234");
			session.save(p1);
			Phone p2 = new Phone();
			p2.setPhone_no("22345");
			session.save(p2);

			phone_set.add(p1);
			phone_set.add(p2);

			// save student
			Criteria criteria = session.createCriteria(Student.class);
			criteria.add(Restrictions.eq("name", "samar"));
			Student student = (Student) criteria.uniqueResult();
			if (student == null) {
				student = new Student();
				student.setName("samar");
			}
			student.setPhone_set(phone_set);
			session.save(student);

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void manytomany() {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			// 1:M save phone
			Set<Syllabus> syllabus_set = new HashSet<Syllabus>();
			Syllabus s1 = new Syllabus();
			s1.setName("java");
			session.save(s1);

			Syllabus s2 = new Syllabus();
			s2.setName("c++");
			session.save(s2);

			syllabus_set.add(s1);
			syllabus_set.add(s2);

			// save student
			Criteria criteria = session.createCriteria(Student.class);
			criteria.add(Restrictions.eq("name", "samar"));
			Student student = (Student) criteria.uniqueResult();
			if (student == null) {
				student = new Student();
				student.setName("samar");
			}
			student.setSyllabus_set(syllabus_set);
			session.save(student);

			criteria = session.createCriteria(Student.class);
			criteria.add(Restrictions.eq("name", "vivek"));
			student = (Student) criteria.uniqueResult();
			if (student == null) {
				student = new Student();
				student.setName("vivek");
			}
			student.setSyllabus_set(syllabus_set);
			session.save(student);

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
