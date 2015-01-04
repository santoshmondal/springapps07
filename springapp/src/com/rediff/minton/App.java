package com.rediff.minton;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

public class App {
	public static void main(String[] args) {
		System.out.println("Hibernate many to many (XML Mapping)");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Stock stock = new Stock();
		stock.setStockCode("7055");
		stock.setStockName("a");
		session.save(stock);

		Category category1 = new Category();
		category1.setCategoryId(1);
		Category categoryLoad = (Category) session.get(Category.class, 1);

		Set<Category> categories = new HashSet<Category>();
		categories.add(categoryLoad);
		stock.setCategories(categories);

		session.save(stock);

		session.getTransaction().commit();
		System.out.println("Done");
	}
}
