package dao.impl;

import java.io.Serializable;

import dao.IUserDao;
import entity.User;

public class UserDao implements Serializable, IUserDao {

	@Override
	public Integer saveUser(User user) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("execute saveUser Method");
		throw new Exception("这里发生了异常");
		
	}

}
