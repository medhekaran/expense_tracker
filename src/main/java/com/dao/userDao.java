package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entity.User;



public class userDao {

	private SessionFactory factory= null;
	private Session session=null;
	private Transaction tx= null;

	public userDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	public boolean saveUser(User user) {
		boolean f = false;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
			session.save(user);
			tx.commit();
			f=true;
		} catch (Exception e) {
			if (tx != null) {
				f = false;
				e.printStackTrace();
			}
		}
		return f;
	}
	
	
	public User login(String email,String password) {
		User u = null;
		
		Session s= factory.openSession();
		
		Query q=s.createQuery("FROM User WHERE email= :em and password =:ps");
		
		q.setParameter("em", email);
		q.setParameter("ps", password);
		
	    u=(User)q.uniqueResult();
		
		return u;
		
	}
	
}
