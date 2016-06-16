package cn.jbit.esale.action;

import java.io.Serializable;

import cn.jbit.esale.service.EsaleService;
/**
 * 用户登录Action
 * @author mxc  
 * @date 2016年6月15日 上午9:49:15
 */
public class LoginAction implements Serializable {

	protected EsaleService esaleService = null;
	
	public String execute() {
		return "success";
	}

	public EsaleService getEsaleService() {
		return esaleService;
	}

	public void setEsaleService(EsaleService esaleService) {
		this.esaleService = esaleService;
	}
	
	
}
