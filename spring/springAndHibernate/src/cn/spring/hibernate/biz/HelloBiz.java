package cn.spring.hibernate.biz;

import java.io.Serializable;

import cn.spring.hibernate.entity.User;
import cn.spring.hibernate.service.HelloService;
/**
 * biz 也相当于Action
 * @author mxc  
 * @date 2016年6月14日 上午11:49:11
 */
public class HelloBiz implements Serializable {

	protected HelloService helloService = null;

	/**
	 * 业务方法 
	 * 2016年6月14日上午11:50:30 
	 * @author mxc
	 */
	public void sayHello() {
		User user =  new User();
		user.setUserName("mxc");
		user.setPwd("mxc");
		
		//保存用户
		helloService.saveUser(user);
		
		System.out.println("save success:"+user.getId());
		 
	}
	
	public HelloService getHelloService() {
		return helloService;
	}

	public void setHelloService(HelloService helloService) {
		this.helloService = helloService;
	}
	
	
	
}
