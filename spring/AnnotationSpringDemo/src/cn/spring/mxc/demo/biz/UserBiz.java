
package cn.spring.mxc.demo.biz;

import java.io.Serializable;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.spring.mxc.demo.dao.UserDao;
import cn.spring.mxc.demo.dao.UserDaoImpl;
import cn.spring.mxc.demo.entity.User;

/**     
 * TODO 用户业务
 * @author mxc  
 * @date 2016年6月8日 上午11:47:34    
 *         
*/
public class UserBiz implements Serializable {

	protected UserDao dao =  null;

	public void savaUser() {
		User user = new User();
		user.setId(0);
		user.setUserName("mxc");
		user.setEmail("git@mxc.com");
		user.setPwd("123");
		
		Integer result=	dao.saveUser(user);
		
		
		System.out.println("用户对象保存成功！result:"+result);
	}
	
	public static void main(String[] args) {
		
	}

	public UserDao getDao() {
		return dao;
	}

	public void setDao(UserDao dao) {
		this.dao = dao;
	}
	
	
	
	
}
