package cn.jbit.vote.action.admin;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


import javax.print.DocFlavor.STRING;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;

import cn.jbit.vote.dao.VoteDao;
import cn.jbit.vote.entity.VoteUser;
/**
 * 管理员登录
 * TODO
 * @date：May 27, 2016 11:45:15 AM
 * @author mxc
 */
@ParentPackage("admin")
@Namespace("/admin")
public class LoginAction implements Serializable,ServletRequestAware {
	
	//账号
	protected String vuUserName = null;
	
	//密码
	protected String vuPassword = null;
	
	//验证的结果
	protected Boolean verifyResult = null;
	
	//消息
	protected String message = null;
	
	//验证码
	protected String verifyCode = null;
	
	protected HttpServletRequest request =null;
	/**
	 * 业务实现
	 * @date：May 27, 2016
	 * @author：mxc
	 * @return
	 */
	@Action(value="login",results={@Result(name="success",type="redirect",location="/admin/index.action?message=${message}")
		,@Result(name="input",type="dispatcher",location="/html/admin/login.jsp")})
	public String execute(){
		//保存登录标识
		HttpSession session= request.getSession();
		//空验证
		if (vuUserName==null||vuUserName.equals("")) {
			verifyResult=false;
			message="用户名不能为空";
		}else if (vuPassword==null||vuPassword.equals("")) {
			verifyResult=false;
			message="密码不能为空";
		}else if(verifyCode==null||verifyCode.equals("")){
			message="验证码不能为空！";
			verifyResult=false;
		}else{
			verifyResult=true;
		}
	
		String sCode = (String) session.getAttribute("adminVerifyCode");
		//验证验证码
		if (verifyResult) {
			if (!verifyCode.equals(sCode)) {
				verifyResult=false;
				message="验证码错误";
			}
		}
		
		
		VoteDao dao = new VoteDao();
		//验证账号
		VoteUser user = null;
		if (verifyResult) {
			user= dao.findVoteUserById(vuUserName);
			if (user==null) {
				verifyResult=false;
				message="用户名不存在";
			}
		}
		//验证密码
		if (verifyResult) {
			if (!vuPassword.equals(user.getVuPassword())) {
				verifyResult=false;
				message="用户名或密码错误！";
			}
		}
		
		//验证身份
		if (verifyResult) {
			if (!user.getVuUserType().equals("管理员")) {
				verifyResult=false;
				message="普通用户无法登录，请使用管理员账号登录";
			}
		}
		
		//验证不通过
		if (!verifyResult) {
			return "input";
		}
		
	
		session.setAttribute("adminId", user.getVuId());
	
		//返回登录消息
		message="欢迎管理员  "+user.getVuUserName();
		
		//因为是get方式  需要 编码 防止乱码  使用的
		try {
			message=URLEncoder.encode(message,"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//返回函数值
		return "success";
	}
	/**
	 * 注入request
	 * 
	 * 
	 * 开发时间：May 27, 2016 12:03:50 PM
	 * @author：mxc
	 * @param request
	 */
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	/**
	 * @return the vuUserName
	 */
	public String getVuUserName() {
		return vuUserName;
	}
	/**
	 * @param vuUserName the vuUserName to set
	 */
	public void setVuUserName(String vuUserName) {
		this.vuUserName = vuUserName;
	}
	/**
	 * @return the vuPassword
	 */
	public String getVuPassword() {
		return vuPassword;
	}
	/**
	 * @param vuPassword the vuPassword to set
	 */
	public void setVuPassword(String vuPassword) {
		this.vuPassword = vuPassword;
	}
	/**
	 * @return the verifyResult
	 */
	public Boolean getVerifyResult() {
		return verifyResult;
	}
	/**
	 * @param verifyResult the verifyResult to set
	 */
	public void setVerifyResult(Boolean verifyResult) {
		this.verifyResult = verifyResult;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the verifyCode
	 */
	public String getVerifyCode() {
		return verifyCode;
	}
	/**
	 * @param verifyCode the verifyCode to set
	 */
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	
	
}
