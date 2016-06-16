package cn.jbit.vote.action.user;

import java.io.Serializable;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
/**
 * 用户注销
 * TODO
 * @date：May 27, 2016 1:33:16 PM
 * @author mxc
 */
@ParentPackage("user")
@Namespace("/user")
public class LogoutAction implements Serializable ,ServletRequestAware{

	//request
	protected HttpServletRequest request = null;
	/**
	 * 业务实现
	 * @date：May 27, 2016
	 * @author：mxc
	 * @return
	 */
	@Action(value="logout",results={@Result(name="success",type="redirect", location="/html/user/login.jsp")})
	public String execute(){
		
		//获取session
		HttpSession session = request.getSession();
		
		//删除登录的标识
		session.removeAttribute("userId");
		session.removeAttribute("userVerifyCode");
		
		//返回函数值
		return "success";
	}
	/**
	 * 注入request
	 * 
	 * 
	 * 开发时间：May 27, 2016 1:34:11 PM
	 * @author：mxc
	 * @param request
	 */
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
}
