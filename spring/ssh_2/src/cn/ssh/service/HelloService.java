package cn.ssh.service;

import java.io.Serializable;

import cn.ssh.entity.User;

public interface HelloService extends Serializable {

	/**
	 * 根据id查找User
	 * 2016年6月14日下午2:48:42 
	 * @author mxc  
	 *  @param userId
	 *  @return
	 */
	User findUser(Integer userId);
	
	/**
	 * 保存用户
	 * 2016年6月14日下午2:48:58 
	 * @author mxc  
	 *  @param user
	 */
	void saveUser(User user);
}
