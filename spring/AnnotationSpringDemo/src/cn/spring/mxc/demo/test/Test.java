package cn.spring.mxc.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.spring.mxc.demo.biz.UserBiz;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		UserBiz biz = (UserBiz) context.getBean("userBiz");
		biz.savaUser();
	}

}
