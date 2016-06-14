package cn.spring.hibernate.dao;

import java.io.Serializable;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.spring.hibernate.entity.User;
/**
 * dao
 * @author mxc  
 * @date 2016年6月14日 上午11:28:03
 */
public class HelloDao extends HibernateDaoSupport implements Serializable {

	/**
	 * 根据id 查找用户
	 * 2016年6月14日上午11:29:21 
	 * @author mxc  
	 *  @param userID
	 *  @return
	 */
	public User	findUser(Integer userID) {
		HibernateTemplate ht = this.getHibernateTemplate();
		User user = ht.get(User.class, userID);
		return user;
	}
	/**
	 * 保存User
	 * 2016年6月14日上午11:54:56 
	 * @author mxc  
	 *  @param user
	 */
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		HibernateTemplate ht = this.getHibernateTemplate();
		ht.save(user);
	}
}
