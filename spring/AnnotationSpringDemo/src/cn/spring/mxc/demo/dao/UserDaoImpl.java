package cn.spring.mxc.demo.dao;

import java.io.Serializable;
import java.sql.SQLException;

import cn.spring.mxc.demo.entity.User;
/**
 *
 * TODO 用户 数据 
 * @author mxc  
 * @date 2016年6月6日 上午11:18:39    
 *
 */
public class UserDaoImpl implements Serializable,UserDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * TODO 保存 user
	 * 2016年6月6日上午11:19:27 
	 * @author mxc  
	 *  @param user
	 * @throws SQLException 
	 */
	
	public Integer saveUser(User user)  {
		System.out.println(user.getUserName()+" save success!");
		return 1;
	}

	public UserDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
