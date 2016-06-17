package cn.jbit.jbitoa.action;

import java.io.Serializable;

import cn.jbit.jbitoa.service.JbitOAService;
/**
 * 登录成功之后进来的
 * @author mxc  
 * @date 2016年6月16日 下午3:59:25
 */
public class MainAction implements Serializable {

	protected JbitOAService jbitOAService = null;
	
	/**
	 * 业务实现
	 * 2016年6月16日下午4:00:47 
	 * @author mxc  
	 *  @return
	 */
	public String execute() {
		
		
		return "success";
	}

	public JbitOAService getJbitOAService() {
		return jbitOAService;
	}

	public void setJbitOAService(JbitOAService jbitOAService) {
		this.jbitOAService = jbitOAService;
	}
	
	
}
