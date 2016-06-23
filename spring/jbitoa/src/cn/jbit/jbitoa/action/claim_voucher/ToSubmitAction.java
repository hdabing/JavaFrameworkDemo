package cn.jbit.jbitoa.action.claim_voucher;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.omg.CORBA.ARG_OUT;

import cn.jbit.jbitoa.entity.Dictionary;
import cn.jbit.jbitoa.entity.Employee;
import cn.jbit.jbitoa.service.JbitOAService;
/**
 * 去提交报销单
 * @author mxc  
 * @date 2016年6月20日 下午2:19:53
 */
public class ToSubmitAction implements Serializable,ServletRequestAware {

	protected JbitOAService jbitOAService = null;
	
	//当前用户
	protected Employee employee = null;
	
	protected HttpServletRequest request = null;
	
	//报销项目列表
	protected List<Dictionary> claimVouchItemList = null;
	
	
	public String execute(){
		//获取当前登录的标识
		HttpSession session=request.getSession();
		String currentSn=(String) session.getAttribute("currentSn");
		//找寻员工对象
		employee=jbitOAService.findEmployee(currentSn);
		
		//查询参数的集合
		Map<String, Object> queryParam =  new HashMap<String, Object>();
		
		queryParam.put("type", "报销单报销项目");
		
		//查询数据
		claimVouchItemList=jbitOAService.queryDictionary(queryParam);
		return "success";
	}

	

	public JbitOAService getJbitOAService() {
		return jbitOAService;
	}



	public void setJbitOAService(JbitOAService jbitOAService) {
		this.jbitOAService = jbitOAService;
	}



	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request=arg0;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Dictionary> getClaimVouchItemList() {
		return claimVouchItemList;
	}

	public void setClaimVouchItemList(List<Dictionary> claimVouchItemList) {
		this.claimVouchItemList = claimVouchItemList;
	}
	
	
}
