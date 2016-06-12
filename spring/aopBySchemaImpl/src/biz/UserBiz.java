package biz;

import java.io.Serializable;
/**
 * 业务层
 * TODO 
 * @author mxc  
 * @date 2016年6月12日 上午8:52:18    
 *
 */

import dao.IUserDao;
import entity.User;
public class UserBiz implements Serializable {

	protected IUserDao dao =null;
	
	public void saveUser() {
		try {
			Integer result = dao.saveUser(new User());
			System.out.println("executeResult:"+result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public IUserDao getDao() {
		return dao;
	}

	public void setDao(IUserDao dao) {
		this.dao = dao;
	}
	
}
