package test;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import biz.UserBiz;

public class Test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserBiz biz = (UserBiz) context.getBean("biz");
		biz.saveUser();
	}

}
