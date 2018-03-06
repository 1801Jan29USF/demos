package com.revature.launcher;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.dao.BearDao;
import com.revature.dao.BearHib;
import com.revature.entities.Bear;
import com.revature.util.SessionUtil;

public class BearLauncher {
	private static Logger log = Logger.getRootLogger();
	private static BearDao bdao = new BearHib();
	private static SessionUtil su = SessionUtil.getSessionUtil();

	public static void main(String[] args) throws InterruptedException {
		// log.info(bdao.getById(3));
//		// log.info(bdao.loadById(5));
//		 Bear b = new Bear(0, "White", "Polar", 2, 9, new Cave(7, 100, "Deep", null),
//		 new HoneyPot(0, 4, 3), null);
//		 bdao.merge(b);

		// Bear b = bdao.getById(4);
		//// bdao.delete(b);
		// b.setWeight(10);
		// b.getHoneyPot().setHoneyAmount(15);
		// b.getCubs().add(bdao.getById(1));
		// b.getCubs().add(bdao.getById(3));
		// bdao.merge(b);

		// bdao.findByBreedHQL("winNie").forEach( bear -> {
		// log.info(bear);
		// });
//		moreHQLDemos();
//		moreCriteriaDemos();
//		namedQuery();
		
		Thread.sleep(3000);
		l1Cache();
	}

	private static void l1Cache() {
		Session se = su.getSession();
		log.info("================TRANSACTION 1========================");
		log.info("================TRANSACTION 1========================");
		log.info("================TRANSACTION 1========================");
		// find all bears where honey amount is greater than 3
		
		bdao.getAll();
		
		
		log.info("================TRANSACTION 2========================");
		log.info("================TRANSACTION 2========================");
		log.info("================TRANSACTION 2========================");
		
		bdao.getAll();
		
		
		se.close();
	}

	private static void namedQuery() {
		Session se = su.getSession();
		
		// find all bears where honey amount is greater than 3
		
		Query q = se.getNamedQuery("findByHoneyAmountGreaterThan");
		q.setParameter("amount", 3d);
		
		List<Bear> bears = q.list();
		bears.forEach(bear -> {
			log.info(bear);
		});
		
		se.close();
	}

	private static void moreCriteriaDemos() {
		Session se = su.getSession();
		
		// critera to find all bears in cold caves
		Criteria c = se.createCriteria(Bear.class);
		c.createAlias("dwelling", "home");
		c.createAlias("honeyPot", "pot");
		c.add(Restrictions.or(
				Restrictions.ilike("home.caveType", "Cold"),
				Restrictions.gt("pot.honeyAmount", 3d)
			)
		);		
		
		List<Bear> bears = c.list();
		bears.forEach(bear -> {
			log.info(bear);
		});
		
		se.close();
	}

	private static void moreHQLDemos() {
		Session se = su.getSession();
		
		// find all bears with cave type = deep
//		String hql = "FROM Bear WHERE dwelling.caveType = 'Deep'"; 
		
		// find all bears where honey amount is greater than 3
		String hql = "FROM Bear WHERE honeyPot.honeyAmount > 3";
		
		Query q = se.createQuery(hql);
		
		List<Bear> bears = q.list();
		bears.forEach(bear -> {
			log.info(bear);
		});
		
		se.close();

	}

}
