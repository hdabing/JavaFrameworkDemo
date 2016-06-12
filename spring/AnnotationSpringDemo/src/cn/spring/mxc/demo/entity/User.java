package cn.spring.mxc.demo.entity;

import java.io.Serializable;
/**
 * 用户实体
 * TODO 
 * @author mxc  
 * @date 2016年6月6日 上午11:15:47    
 *
 */
public class User implements Serializable {

	//记录编号
	protected Integer id = null;
	
	//账号
	protected String userName = null;
	
	//密码
	protected String  pwd = null;
	
	//email
	protected String  email = null;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
