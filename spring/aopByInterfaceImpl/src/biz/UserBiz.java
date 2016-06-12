package biz;

import java.io.Serializable;
import java.sql.SQLException;

import dao.IUserDao;
import entity.User;

public class UserBiz implements Serializable {

	protected IUserDao dao =null;

	public void saveUser() {
		User user = new User();
		user.setAddress("北京市");
		user.setName("mxc");
		System.out.println( dao.saveUser(user));
	}
	
	public IUserDao getDao() {
		return dao;
	}

	public void setDao(IUserDao dao) {
		this.dao = dao;
	}
	
	
}
