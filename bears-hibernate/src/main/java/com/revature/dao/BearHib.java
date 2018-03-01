package com.revature.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.entities.Bear;
import com.revature.util.SessionUtil;

public class BearHib implements BearDao {
	private Logger log = Logger.getRootLogger();
	private SessionUtil su = SessionUtil.getSessionUtil();

	@Override
	public Bear save(Bear b) {
		Session se = su.getSession();
		Transaction tx = se.beginTransaction();
		int id = (int) se.save(b); // b is now a persistent object
		log.trace("The generated id is: " + id);
		b.setBearColor("Silver"); // this should be reflected in the db

		tx.commit();
		se.close();
		return b;
	}

	@Override
	public Bear persist(Bear b) {
		Session se = su.getSession();
		Transaction tx = se.beginTransaction();
		se.persist(b); // b is now a persistent object
		log.trace("The generated id is: " + b.getBearId());
		// b.setBearColor("Silver"); // this should be reflected in the db

		tx.commit();
		se.close();
		return b;
	}

	@Override
	public Bear getById(int id) {
		Session se = su.getSession();
		Bear b = (Bear) se.get(Bear.class, id);
		se.close();
		return b;
	}

	@Override
	public Bear loadById(int id) {
		Session se = su.getSession();
		Bear b = (Bear) se.load(Bear.class, id);
		b.getBearId(); // accessing a field will retreive the proxy
		se.close();
		return b;
	}

	@Override
	public List<Bear> getAll() {
		Session se = su.getSession();
		Criteria c = se.createCriteria(Bear.class);
		List<Bear> bears = c.list();
		se.close();
		return bears;
	}

	@Override
	public Bear update(Bear b) {
		Session se = su.getSession();
		Transaction tx = se.beginTransaction();

		// this will cause us to get the non unique object exception
		// Bear b2 = loadById(b.getBearId());
		// se.update(b2);

		se.update(b); // b is now a persistent object

		tx.commit();
		se.close();
		log.info("done");
		return b;
	}

	@Override
	public Bear merge(Bear b) {
		Session se = su.getSession();
		Transaction tx = se.beginTransaction();

		Bear persistant = (Bear) se.merge(b);

		// Bear b2 = loadById(b.getBearId());
		// se.update(b2);
		// log.info("b2 weight: " + b2.getWeight());
		//
		// Bear persistant = (Bear) se.merge(b);
		// log.info("b2 weight after merge: " + b2);
		// log.info(b2 == persistant);

		tx.commit();
		se.close();
		log.info("done");
		return persistant;
	}

	@Override
	public void delete(Bear b) {
		Session se = su.getSession();
		Transaction tx = se.beginTransaction();

		se.delete(b); // b is now a persistent object

		tx.commit();
		se.close();
	}

	@Override
	public Set<Bear> findByBreedCriteria(String breed) {
		Session se = su.getSession();
		Criteria c = se.createCriteria(Bear.class);
		c.add(Restrictions.ilike("breed", breed));
		List<Bear> bears = c.list();
		se.close();
		return new HashSet<>(bears);
	}

	@Override
	public Set<Bear> findByBreedHQL(String breed) {
		Session se = su.getSession();
		String hql = "FROM Bear WHERE UPPER(breed) = UPPER(:breed)";
		Query q = se.createQuery(hql);
		q.setParameter("breed", breed);
		List<Bear> bears = q.list();
		se.close();
		return new HashSet<>(bears);
	}

}
