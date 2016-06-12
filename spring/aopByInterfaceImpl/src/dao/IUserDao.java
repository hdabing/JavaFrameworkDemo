package dao;

import java.io.Serializable;
import java.sql.SQLException;

import entity.User;
/**
 * 用户数据接口
 * TODO 
 * @author mxc  
 * @date 2016年6月11日 下午11:29:56    
 *
 */
public interface IUserDao extends Serializable {

	/**
	 * 保存 用户
	 * TODO
	 * 2016年6月11日下午11:29:49 
	 * @author mxc  
	 *  @param user
	 *  @return
	 */
	Integer saveUser(User user)  ;
}
