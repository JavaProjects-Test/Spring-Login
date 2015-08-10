package com.user.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.user.vo.Users;

public class LoginDaoImpl implements LoginDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Users checkValidation(Users objectCheckValidation) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Users.class);
		criteria.add(Restrictions.eq("emailID",
				objectCheckValidation.getEmailID()));
		criteria.add(Restrictions.eq("password",
				objectCheckValidation.getPassword()));
		System.out.println("ghty");
		Users validation = (Users) criteria.uniqueResult();
		// System.out.println(validation.getEmailID());
		return validation;

	}

	public boolean addAccountStatus(Users objectAddStatus) {
		Session session = sessionFactory.openSession();
		System.out.println("there");
		Transaction tx = session.beginTransaction();
		//System.out.println(objectAddStatus.getAccountStatus());
		session.update(objectAddStatus);
		tx.commit();
		session.close();
		return true;
	}
}
