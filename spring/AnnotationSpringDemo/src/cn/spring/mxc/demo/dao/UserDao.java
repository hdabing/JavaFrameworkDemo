package cn.spring.mxc.demo.dao;

import java.sql.SQLException;

import cn.spring.mxc.demo.entity.User;

/**
 * 用户业务
 * TODO 
 * @author mxc  
 * @date 2016年6月6日 上午11:21:24    
 *
 */
public interface UserDao {

	/**
	 * 
	 * TODO 保存 User
	 * 2016年6月6日上午11:21:46 
	 * @author mxc  
	 *  @param user
	 */
	 public Integer saveUser(User user);
}
