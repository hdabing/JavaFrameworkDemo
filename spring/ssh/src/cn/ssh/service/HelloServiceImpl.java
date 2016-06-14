package cn.ssh.service;

import java.io.Serializable;

import cn.ssh.dao.HelloDao;
import cn.ssh.entity.User;

public class HelloServiceImpl implements Serializable, HelloService {

	protected HelloDao helloDao= null;
	
	@Override
	public User findUser(Integer userId) {
		// TODO Auto-generated method stub
		return helloDao.findUser(userId);
	}

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
