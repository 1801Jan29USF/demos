package com.revature.launcher;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.dao.BearDao;
import com.revature.services.BearService;

public class BearLauncher {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		BearDao bdao = (BearDao) ac.getBean("beardao");
		BearService bserv = (BearService) ac.getBean("bearservice");
		bserv.testTransactions();
		
//		System.out.println(bdao.findByIdTheRightWay(1));
		
	}
}
