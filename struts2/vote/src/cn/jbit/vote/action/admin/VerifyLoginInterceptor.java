package cn.jbit.vote.action.admin;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 管理平台安全验证 
 * TODO
 * @date：May 27, 2016 1:51:50 PM
 * @author mxc
 */
public class VerifyLoginInterceptor extends AbstractInterceptor {

	/**
	 * 业务实现
	 * 
	 * 
	 * 开发时间：May 27, 2016 1:53:42 PM
	 * @author：mxc
	 * @param ai
	 * @return
	 * @throws Exception
	 */
	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		//获取Action名称
		String actionName =ai.getInvocationContext().getName();
		
		if (actionName.equals("login")||actionName.equals("logout")) {
			//放行
			return ai.invoke();
		}
		
		//获取 session 解耦方式获取
		HttpSession session= ServletActionContext.getRequest().getSession();
		
		//获取登录标识
		Integer adminId = (Integer) session.getAttribute("adminId");
		
		//验证是否登录
		if (adminId == null) {
			//返回  登录页面
			return "login";
		}
		
		return ai.invoke();
	}

}
