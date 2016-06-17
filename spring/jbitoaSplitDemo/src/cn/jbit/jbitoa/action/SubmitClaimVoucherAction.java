package cn.jbit.jbitoa.action;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

import cn.jbit.jbitoa.entity.ClaimVoucher;
import cn.jbit.jbitoa.service.JbitOAService;
/**
 * 添加报销单
 * @author mxc  
 * @date 2016年6月13日 下午5:01:18
 */
public class SubmitClaimVoucherAction implements Serializable {

	//业务执行对象
	protected JbitOAService jbitOAService = null;
	
	//报销单对象
	protected ClaimVoucher claimVoucher123 = null;
	
	//消息
	protected String message = null;
	
	/**
	 * 业务实现
	 * 2016年6月13日下午5:03:39 
	 * @author mxc  
	 *  @return
	 */
	public String execute(){
		
		jbitOAService.saveClaimVoucher(claimVoucher123);
		
		try {
			message= URLEncoder.encode("报销单添加成功！","utf-8");
		} catch (UnsupportedEncodingException e) {
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

	

	public ClaimVoucher getClaimVoucher123() {
		return claimVoucher123;
	}

	public void setClaimVoucher123(ClaimVoucher claimVoucher123) {
		this.claimVoucher123 = claimVoucher123;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
}
