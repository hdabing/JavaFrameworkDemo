package cn.jbit.jbitoa.action;

import org.apache.catalina.connector.Request;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 安全验证拦截器
 * @author mxc  
 * @date 2016年6月16日 下午4:06:33
 */
public class VerifyLoginInterceptor extends AbstractInterceptor {

	/**
	 * 拦截Action
	 * 
	 * 1.获取action的名称
	 * @author mxc
	 * 2016年6月16日下午4:06:52   
	 * @param ai
	 * @return
	 * @throws Exception
	 */
	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		
		//获取Action的名何曾
		String actionName=  ai.getInvocationContext().getName();
		
		//判断是否放行
		if (actionName.equals("login")||actionName.equals("logout")||actionName.equals("showVerifyCode")) {
			return ai.invoke();
		}
		
		//获取登录标识
		String currentSn = (String) ServletActionContext.getRequest().getSession().getAttribute("currentSn");
		
		if (currentSn==null) {
			ServletActionContext.getRequest().getSession().setAttribute("message", "请先登录");
			return "login";
		}
		
		return ai.invoke();
	}

}
