package cn.ssh.dao;

import java.io.Serializable;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.ssh.entity.User;

public class HelloDao  implements Serializable {

	protected HibernateTemplate hibernateTemplate= null;
	
	/**
	 * 根据id查询 User
	 * 2016年6月14日下午2:42:39 
	 * @author mxc  
	 *  @param UserId
	 *  @return
	 */
	public User findUser(Integer UserId){
		HibernateTemplate ht = this.getHibernateTemplate();
		User user=ht.get(User.class, UserId);
		return user;
	}
	
	/**
	 * 保存User
	 * 2016年6月14日下午2:43:43 
	 * @author mxc  
	 *  @param user
	 */
	public void saveUser(User user ){
		HibernateTemplate ht = this.getHibernateTemplate();
		ht.save(user);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
}
