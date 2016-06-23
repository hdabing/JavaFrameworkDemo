package cn.jbit.jbitoa.action;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import cn.jbit.jbitoa.entity.Employee;
import cn.jbit.jbitoa.service.JbitOAService;
/**
 * 用户登录Action
 * @author mxc  
 * @date 2016年6月13日 下午2:00:30
 */
public class LoginAction implements Serializable ,ServletRequestAware {

	//service接口类型字段
	protected JbitOAService jbitOAService = null;
	
	protected String sn = null;
	
	protected String password = null;
	
	protected boolean verifyResult = true;
	
	protected String  message =  null;
	
	protected HttpServletRequest request = null;
	
	//验证码
	protected String verifyCode = null;
	/**
	 * 业务实现
	 * 2016年6月13日下午2:01:00 
	 * @author mxc  
	 *  @return
	 */
	public String execute(){
		
		//非空验证
		if (sn==null||sn.equals("")) {
			verifyResult=false;
			message="账号不能为空";
			
		}else if(password==null||password.equals("")){
			verifyResult=false;
			message="密码不能为空！";
		}else if (verifyCode==null||verifyCode.equals("")) {
			verifyResult=false;
			message="验证码不能为空";
		}
		
		
		//检测验证码
		if (verifyResult) {
			
			//session中的验证码
			String  sverifyCdoe = (String) request.getSession().getAttribute("verfiyCdoe");
			
			
			if (!sverifyCdoe.equals(verifyCode)) {
				verifyResult=false;
				message="验证码错误";
			}
			
		}
		
		
		//员工
		Employee employee= null;
		
		//验证账号
		if (verifyResult) {
			employee= jbitOAService.findEmployee(sn);
			if (employee==null) {
				verifyResult=false;
				message="账号不存在！";
			}
		}
		
		//验证密码：
		if (verifyResult) {
			if (!employee.getPassword().equals(password)) {
				verifyResult=false;
				message="用户名或密码不正确";
			}
		}
		
		//验证不通过
		if (!verifyResult) {
			return "input";
		}
		
		//保存登录标识
		request.getSession().setAttribute("currentSn", employee.getSn());
		message="登录成功！";
		//因为重定向，消息进行编码
		try {
			message=URLEncoder.encode(message, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	public JbitOAService getJbitOAService() {
		return jbitOAService;
	}
	public void setJbitOAService(JbitOAService jbitOAService) {
		this.jbitOAService = jbitOAService;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isVerifyResult() {
		return verifyResult;
	}
	public void setVerifyResult(boolean verifyResult) {
		this.verifyResult = verifyResult;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	public String getVerifyCode() {
		return verifyCode;
	}
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	
}
