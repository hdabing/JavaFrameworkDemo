package cn.jbit.spring.struts2.action;

import java.io.Serializable;
/**
 * 
 * @author mxc  
 * @date 2016年6月14日 上午9:20:53
 */
public class HelloAction implements Serializable {

	protected String message = null;
	
	public String execute() {
		message= "你好，Spring And Struts2 的集成";
		return "success";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
