package dao;

import java.io.Serializable;

import entity.User;

public interface IUserDao extends Serializable {

	/**
	 * 保存 User
	 * TODO
	 * 2016年6月12日上午8:51:19 
	 * @author mxc  
	 *  @param user
	 *  @return
	 */
	Integer saveUser(User user)throws Exception;
}
