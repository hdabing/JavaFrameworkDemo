package cn.ssh.action;

import java.io.Serializable;

import cn.ssh.entity.User;
import cn.ssh.service.HelloService;
/**
 * Action 
 * @author mxc  
 * @date 2016年6月14日 下午2:57:47
 */
public class HelloAction implements Serializable {

	protected HelloService helloService = null;
	
	protected String message = null;
	
	/**
	 * 业务实现
	 * 2016年6月14日下午2:57:39 
	 * @author mxc  
	 *  @return
	 */
	public String execute(){
		//创建User对象
		User user = new User();
		user.setUserName("mxc");
		user.setPwd("mxc");
		user.setEmail("鳖孙");
		//保存用户
		helloService.saveUser(user);
		message="success save !";
		User user2 = helloService.findUser(1);
		message+=user2.getUserName();
		return "success";
	}
	public HelloService getHelloService() {
		return helloService;
	}
	public void setHelloService(HelloService helloService) {
		this.helloService = helloService;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
