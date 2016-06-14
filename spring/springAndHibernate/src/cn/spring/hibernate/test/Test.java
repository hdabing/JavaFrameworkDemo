package cn.spring.hibernate.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.spring.hibernate.biz.HelloBiz;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		HelloBiz biz = (HelloBiz) context.getBean("helloBiz");
		biz.sayHello();
	}
}
