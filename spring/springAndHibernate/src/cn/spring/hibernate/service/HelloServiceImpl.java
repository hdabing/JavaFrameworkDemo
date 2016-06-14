package cn.spring.hibernate.service;

import java.io.Serializable;

import cn.spring.hibernate.dao.HelloDao;
import cn.spring.hibernate.entity.User;

public class HelloServiceImpl implements Serializable, HelloService {

	protected HelloDao helloDao = null;
	@Override
	public User findUser(Integer userID) {
		// TODO Auto-generated method stub
		return helloDao.findUser(userID);
	}
	/**
	 * 保存用户
	 * @author mxc
	 * 2016年6月14日上午11:54:11   
	 * @param user
	 */
	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		helloDao.saveUser(user);
	}
	public HelloDao getHelloDao() {
		return helloDao;
	}
	public void setHelloDao(HelloDao helloDao) {
		this.helloDao = helloDao;
	}
	

}
