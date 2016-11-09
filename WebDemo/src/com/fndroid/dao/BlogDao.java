package com.fndroid.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fndroid.entity.Blog;
import com.fndroid.sessionfactory.HibernateSessionFactory;

public class BlogDao {

	public List<Blog> getBlogs() {
		Configuration conf = new Configuration().configure();
		SessionFactory sessionFactory = conf.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Blog");
		List<Blog> list = query.list();
		return list;
	}
}
