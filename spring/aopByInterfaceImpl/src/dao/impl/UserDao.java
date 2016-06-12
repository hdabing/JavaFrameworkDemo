package dao.impl;

import java.io.Serializable;
import java.sql.SQLException;

import org.aspectj.apache.bcel.generic.ReturnaddressType;

import dao.IUserDao;
import entity.User;

public class UserDao implements Serializable, IUserDao {

	/**
	 * 保存用户，仅用于测试
	 * @author mxc
	 * 2016年6月11日下午11:30:53   
	 * @param user
	 * @return
	 */
	@Override
	public Integer saveUser(User user) {
		System.out.println("save success！");
		return 1;
		
	}

}
