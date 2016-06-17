package cn.jbit.jbitoa.action;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
/**
 * 登出
 * @author mxc  
 * @date 2016年6月16日 下午3:20:36
 */
public class LogoutAction implements Serializable,ServletRequestAware {

	protected HttpServletRequest request = null;
	
	/**
	 * 业务实现
	 * 2016年6月16日下午3:41:47 
	 * @author mxc  
	 *  @return
	 */
	public String execute() {
		
		request.getSession().removeAttribute("currentSn");
		request.getSession().removeAttribute("verifyCode");
		return "success";
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request=arg0;
	}
}
