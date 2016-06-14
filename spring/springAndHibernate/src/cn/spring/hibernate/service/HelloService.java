package cn.spring.hibernate.service;

import java.io.Serializable;

import cn.spring.hibernate.entity.User;

public interface HelloService extends Serializable {

	/**
	 * 根据id查找user
	 * 2016年6月14日上午11:44:07 
	 * @author mxc  
	 *  @param userID
	 *  @return
	 */
	User findUser(Integer userID);

	/**
	 * 保存User
	 * 2016年6月14日上午11:52:20 
	 * @author mxc  
	 *  @param user
	 */
	void saveUser(User user);
}
