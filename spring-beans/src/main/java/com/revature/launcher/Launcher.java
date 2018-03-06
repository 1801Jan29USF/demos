package com.revature.launcher;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		System.out.println(ac.getBean("Brick"));
		System.out.println(ac.getBean("Brick"));
		System.out.println(ac.getBean("CoolWall"));
		System.out.println(ac.getBean("CobraWall"));
	}
}
